package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.manage_cms.dao.CmsConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by zps on 2019/12/30 16:13
 */
@Service
public class CmsConfigService {

    @Autowired
    private CmsConfigRepository cmsConfigRepository;


    //根据id查询CmsConfig
    public CmsConfig getCmsConfigById(String id) {
        Optional<CmsConfig> byId = cmsConfigRepository.findById(id);
        //判断是否为空
        if (byId.isPresent()) {
            CmsConfig cmsConfig = byId.get();
            return cmsConfig;
        }
        return null;
    }

}
