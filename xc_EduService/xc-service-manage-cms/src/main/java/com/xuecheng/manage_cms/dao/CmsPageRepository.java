package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zps on 2019/12/20 20:19
 */
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {

    //自定义查询方法
    public CmsPage findCmsPageByPageName(String pageName);

    ////根据页面名称、站点Id、页面webpath为唯一索引去查询是否数据已经存在了
    public CmsPage findCmsPageByPageNameAndSiteIdAndPageWebPath(String pageName,String siteId,String pageWebPath);

}
