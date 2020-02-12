package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.constant.MessageConstant;
import com.zps.entity.PageResult;
import com.zps.entity.QueryPageBean;
import com.zps.entity.Result;
import com.zps.pojo.CheckGroup;
import com.zps.pojo.CheckItem;
import com.zps.service.CheckGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/checkGroup")
public class CheckGroupController {

    @Reference
    private CheckGroupService checkGroupService;


    /**
     * 删除功能
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Integer id) {
        try {
            checkGroupService.delete(id);
        } catch (Exception e) {
            return new Result(false, MessageConstant.DELETE_CHECKGROUP_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);
    }

    /**
     * 编辑功能
     *
     * @param checkitemIds
     * @param checkGroup
     * @return
     */
    @RequestMapping("/edit")
    public Result edit(Integer[] checkitemIds, @RequestBody CheckGroup checkGroup) {
        try {
            checkGroupService.edit(checkitemIds, checkGroup);
        } catch (Exception e) {
            return new Result(false, MessageConstant.EDIT_CHECKGROUP_FAIL);
        }
        return new Result(true, MessageConstant.EDIT_CHECKGROUP_SUCCESS);

    }

    /**
     * 显示编辑第二列全部检查项
     *
     * @param id
     * @return
     */
    @RequestMapping("/findCheckItemId")
    public Result findCheckItemId(Integer id) {
        List<Integer> list = checkGroupService.findCheckItemId(id);

        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, list);
    }

    /**
     * 查询页面
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = checkGroupService.findPage(queryPageBean);
        return pageResult;
    }

    /**
     * 新建检查组
     *
     * @param checkitemIds
     * @param checkGroup
     * @return
     */
    @RequestMapping("/add")
    public Result add(Integer[] checkitemIds, @RequestBody CheckGroup checkGroup) {
        try {
            checkGroupService.add(checkitemIds, checkGroup);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
        return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }


    @RequestMapping("/findCheckItemAll")
    public Result findCheckItemAll() {
        List<CheckItem> checkItemAllList = checkGroupService.findCheckItemAll();
        if (checkItemAllList == null || checkItemAllList.size() <= 0) {
            return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
        return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS, checkItemAllList);
    }
}
