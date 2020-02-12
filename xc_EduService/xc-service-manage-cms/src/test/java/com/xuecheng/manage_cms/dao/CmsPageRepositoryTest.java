package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * Created by zps on 2019/12/20 20:21
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;

    //自定义条件查询
    @Test
    public void findByExample() {
        //定义条件，用对象封装
        CmsPage cmsPage = new CmsPage();
        //根据别名模糊查询
        //cmsPage.setPageAliase("轮播");

        cmsPage.setSiteId("");
        //定义条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        /*
        参数一：按那个字段查询
        参数二:条件
         */
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());

        /*
        定义条件器
        参数1：查询条件
        参数2：查询匹配器
         */
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        //分页信息
        Pageable pageable = PageRequest.of(0, 10);
        //根据条件查询
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        List<CmsPage> content = all.getContent();
        System.out.println(content);
    }

    //查询单个
    @Test
    public void testFindAll() {
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }

    //分页查询
    @Test
    public void testPageHelper() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }

    //根据id修改
    @Test
    public void testUpdateById() {
        //先查询
        Optional<CmsPage> op = cmsPageRepository.findById("5abefd525b05aa293098fca6");
        if (op.isPresent()) { // jdk1.8新出来的 优点是：1，提醒你进行非空判断 2，将对象非空检测标准化
            //get()方法直接获取内容
            CmsPage cmsPage = op.get();
            //修改
            cmsPage.setPageAliase("bbb");
            //保存
            cmsPageRepository.save(cmsPage);
        }
    }

    //测试自定义查询方法
    @Test
    public void testFindByName() {
        CmsPage cmsPage = cmsPageRepository.findCmsPageByPageName("10101.html");
        System.out.println(cmsPage);
    }
}
