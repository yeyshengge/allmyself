package com.xuecheng.manage_cms.service;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.*;
import com.xuecheng.manage_cms.config.RabbitmqConfig;
import com.xuecheng.manage_cms.dao.CmsConfigRepository;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import com.xuecheng.manage_cms.dao.CmsTemplateRepository;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by zps on 2019/12/20 21:02
 */
@Service
public class CmsPageService {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Autowired
    private CmsSiteRepository cmsSiteRepository;

    @Autowired
    private CmsTemplateRepository cmsTemplateRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    //显示页面
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {

        if (queryPageRequest == null) {
            queryPageRequest = new QueryPageRequest();
        }
        if (queryPageRequest.getSiteId().length() <= 0) {
            queryPageRequest.setSiteId(null);
        }
        if (queryPageRequest.getPageAliase().length() <= 0) {
            queryPageRequest.setPageAliase(null);
        }
        //操作参数
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        //定义条件，用对象封装
        CmsPage cmsPage = new CmsPage();
        //根据站点id查询
        if (StringUtils.isEmpty(queryPageRequest.getSiteId())) {
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        //根据模板id查询
        if (StringUtils.isEmpty(queryPageRequest.getTemplateId())) {
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());
        }
        //根据别名模糊查询
        if (StringUtils.isEmpty(queryPageRequest.getPageAliase())) {
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());

        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);


        //Spring Date页面查询是从0页开始查询的
        page = page - 1;

        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> pages = cmsPageRepository.findAll(example, pageable);
        List<CmsPage> content = pages.getContent(); //获取集合数据
        long totalElements = pages.getTotalElements();//获取总页数
        //构建一个QueryResult，因为返回值需要
        QueryResult queryResult = new QueryResult();
        queryResult.setList(content);
        queryResult.setTotal(totalElements);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    //页面查询
    public QueryResponseResult findSite() {
        List<CmsSite> all = cmsSiteRepository.findAll();

        QueryResult queryResult = new QueryResult();
        queryResult.setList(all);
        queryResult.setTotal(all.size());
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);

    }

    //新增页面
    public CmsPageResult addPage(CmsPage cmsPage) {
        if (cmsPage == null) {
            ExceptionCast.cast(CommonCode.FAIL);
        }

        //根据页面名称、站点Id、页面webpath为唯一索引去查询是否数据已经存在了
        CmsPage cmsPage1 = cmsPageRepository.findCmsPageByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if (cmsPage1 != null) {
            ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        cmsPage.setPageId(null);
        cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS, cmsPage);


    }


    //编辑页面的回写信息
    public CmsPage findById(String id) {
        Optional<CmsPage> byId = cmsPageRepository.findById(id);
        if (byId.isPresent()) {
            CmsPage cmsPage = byId.get();
            return cmsPage;
        }
        return null;
    }

    //编辑页面的保存
    public CmsPageResult edit(String id, CmsPage cmsPage) {
        //先查询
        CmsPage c = this.findById(id);
        if (c != null) {
            //只需修改某些值，某些值不能被修改
            c.setTemplateId(cmsPage.getTemplateId());
            c.setSiteId(cmsPage.getSiteId());
            c.setPageAliase(cmsPage.getPageAliase());
            c.setPageWebPath(cmsPage.getPageWebPath());
            c.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
            c.setDataUrl(cmsPage.getDataUrl());
            CmsPage save = cmsPageRepository.save(c);
            if (save != null) {
                return new CmsPageResult(CommonCode.SUCCESS, save);
            }
        }
        return new CmsPageResult(CommonCode.FAIL, null);
    }

    //根据id删除
    public ResponseResult del(String id) {
        try {
            cmsPageRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseResult(CommonCode.FAIL);
        }
    }

    //获取静态化页面
    public String getStaticHtml(String pageId) {
        //获取页面模型数据
        Map map = getModelData(pageId);
        //获取页面模板
        String pageTemplate = getPageTemplate(pageId);
        //执行静态化
        String html = executeStatic(pageTemplate, map);
        return html;
    }

    //获取页面模型数据
    private Map getModelData(String pageId) {
        //根据id获取页面信息
        CmsPage cmsPage = this.findById(pageId);
        if (cmsPage == null) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_FINDPAGEISNULL);
        }
        //获取dataUrl
        String dataUrl = cmsPage.getDataUrl();
        if (dataUrl == null) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        //通过restTemplate获取数据
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
        Map map = forEntity.getBody();
        if (map == null) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_DATAISNULL);
        }
        return map;
    }

    //获取页面模板
    private String getPageTemplate(String pageId) {
        //根据id获取页面信息
        CmsPage cmsPage = this.findById(pageId);
        if (cmsPage == null) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_FINDPAGEISNULL);
        }
        String templateId = cmsPage.getTemplateId();
        if (templateId == null) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        //通过模板id查询该模板对应的文件id
        Optional<CmsTemplate> cmsTemplate = cmsTemplateRepository.findById(templateId);
        if (cmsTemplate.isPresent()) {
            CmsTemplate cmsTemplate1 = cmsTemplate.get();

            //获取文件id
            String templateFileId = cmsTemplate1.getTemplateFileId();

            //先查询该文件
            GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(templateFileId)));
            //获取他的objectId
            ObjectId objectId = gridFSFile.getObjectId();
            //开启一个下载流
            GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(objectId);
            //创建GridFsResource对象，用于获取流对象
            GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
            //转换为string，便于输出查看
            String content = null;
            try {
                content = IOUtils.toString(gridFsResource.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        } else {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
            return null;
        }
    }

    //执行静态化
    private String executeStatic(String template, Map model) {
        Configuration configuration = new Configuration(Configuration.getVersion());
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("template", template);
        configuration.setTemplateLoader(stringTemplateLoader);
        try {
            Template template1 = configuration.getTemplate("template");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template1, model);
            return html;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //页面发布
    public ResponseResult postPage(String pageId) {
        //执行静态化
        String HtmlContent = this.getStaticHtml(pageId);
        //保存静态化文件
        CmsPage cmsPage = saveHtml(pageId, HtmlContent);
        //发送页面发布消息
        sendPostPage(pageId);
        //回执数据，发送成功
        return new ResponseResult(CommonCode.SUCCESS);
    }

    //发送页面发布消息
    private void sendPostPage(String pageId) {
        //获取页面信息，后面会用到相关参数
        Optional<CmsPage> byId = cmsPageRepository.findById(pageId);
        if (!byId.isPresent()) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_SAVEHTMLERROR);
        }
        CmsPage cmsPage = byId.get();
        //设置信息
        Map<String, String> map = new HashMap<>();
        map.put("pageId", cmsPage.getPageId());
        //把map装换为json
        String message = JSON.toJSONString(map);
        //发送mq消息
        rabbitTemplate.convertAndSend(RabbitmqConfig.EX_ROUTING_CMS_POSTPAGE, cmsPage.getSiteId(), message);

    }

    //保存静态页面内容
    private CmsPage saveHtml(String pageId, String content) {
        Optional<CmsPage> byId = cmsPageRepository.findById(pageId);
        if (!byId.isPresent()) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_SAVEHTMLERROR);
        }
        CmsPage cmsPage = byId.get();
        //存储之前删除原来的
        String htmlFileId = cmsPage.getHtmlFileId();
        if (!StringUtils.isEmpty(htmlFileId)) {
            gridFsTemplate.delete(Query.query(Criteria.where("_id").is(htmlFileId)));
        }
        InputStream inputStream = null;
        try {
            //把String 转为流
            inputStream = IOUtils.toInputStream(content, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //存储并返回一个文件id
        ObjectId objectId = gridFsTemplate.store(inputStream, cmsPage.getPageName());

        String fileId = objectId.toHexString();
        //更新HtmlFileId
        cmsPage.setHtmlFileId(fileId);

        CmsPage save = cmsPageRepository.save(cmsPage);

        return save;
    }
}
