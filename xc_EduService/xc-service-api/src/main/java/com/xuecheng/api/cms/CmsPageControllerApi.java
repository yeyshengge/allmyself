package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * Created by zps on 2019/12/20 17:50
 */
@Api(value = "cme页面管理", description = "cms页面管理接口，提供增删改查")
public interface CmsPageControllerApi {

    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int")
    })
    //页面查询
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    @ApiOperation("查找站点")
    //搜索时显示的站点
    public QueryResponseResult findSite();

    @ApiOperation("新增页面")
    //新增页面
    public CmsPageResult addPage(CmsPage cmsPage);

    @ApiOperation("编辑页面回写数据")
    //编辑页面的回写信息
    public CmsPage findById(String id);

    @ApiOperation("编辑页面保存数据")
    //编辑页面的保存
    public CmsPageResult edit(String id, CmsPage cmsPage);

    @ApiOperation("删除页面")
    //编辑页面的保存
    public ResponseResult del(String id);

    @ApiOperation("发布页面")
    //发布页面
    public ResponseResult post(String pageId);
}
