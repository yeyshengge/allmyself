package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zps on 2019/12/30 16:03
 */
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate, String> {
}
