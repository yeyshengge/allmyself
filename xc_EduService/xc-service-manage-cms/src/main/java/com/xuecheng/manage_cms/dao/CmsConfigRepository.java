package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zps on 2019/12/30 16:03
 */
public interface CmsConfigRepository extends MongoRepository<CmsConfig, String> {
}
