package com.xuecheng.framework.domain.cms.request;

import lombok.Data;

/**
 * Created by zps on 2019/12/20 17:43
 */
@Data
//接收页面查询条件
public class QueryPageRequest {

    //站点id
    private String siteId;
    //页面id
    private String pageId;
    //页面名称
    private String pageName;
    //页面别名
    private String pageAliase;
    //模板id
    private String templateId;


}
