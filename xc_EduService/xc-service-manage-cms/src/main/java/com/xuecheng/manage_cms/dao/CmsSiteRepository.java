package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zps on 2019/12/22 23:48
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {
}
