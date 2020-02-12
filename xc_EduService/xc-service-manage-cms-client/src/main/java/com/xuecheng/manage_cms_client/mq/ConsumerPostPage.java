package com.xuecheng.manage_cms_client.mq;

import com.alibaba.fastjson.JSON;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.manage_cms_client.service.PageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zps on 2020/1/6 20:14
 */
@Component
public class ConsumerPostPage {
    //日志记录
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerPostPage.class);

    @Autowired
    private PageService pageService;


    //监听队列
    @RabbitListener(queues = {"${xuecheng.mq.queue}"})
    public void postPage(String message) {
        System.out.println("信息来了");
        /*
        信息格式为：{"pageId":""}
         */
        //解析数据
        Map map = JSON.parseObject(message, Map.class);
        String pageId = (String) map.get("pageId");
        //判断id是否正确
        CmsPage cmsPage = pageService.findById(pageId);

        if (cmsPage == null) {
            //打印日志,抛出异常
            LOGGER.error("By pageId find cmsPage is null");
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_FINDPAGEISNULL);
        }
        //执行下载方法
        pageService.savePageToServerPath(pageId);
    }
}
