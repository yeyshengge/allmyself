package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zps on 2019/12/22 23:48
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {
}
