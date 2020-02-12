package com.zps.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zps.domain.User;
import com.zps.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/test22")
    public ModelAndView test22() {
        System.out.println("controller进来了");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "zhangsan");
        modelAndView.setViewName("target");
        return modelAndView;
    }

    @RequestMapping("/test21")
    @ResponseBody
    public void test21(String username, MultipartFile multipartFile) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        multipartFile.transferTo(new File("E://test//" + filename));
    }

    /**
     * 获取cook 的id
     *
     * @param cook
     * @throws IOException
     */
    @RequestMapping("/test20")
    @ResponseBody
    public void test20(@CookieValue(value = "JSESSIONID") String cook) throws IOException {
        System.out.println(cook);
    }


    /**
     * 获取请求头参数，根据键名获取值
     *
     * @param user_agent
     * @throws IOException
     */
    @RequestMapping("/test19")
    @ResponseBody
    public void test19(@RequestHeader(value = "User-Agent") String user_agent) throws IOException {
        System.out.println(user_agent);
    }

    /**
     * 日期转换器
     *
     * @param date
     * @throws IOException
     */
    @RequestMapping("/test18")
    @ResponseBody
    public void test18(Date date) throws IOException {
        System.out.println(date);
    }

    /**
     * Restful风格
     *
     * @param username
     * @throws IOException
     */
    @RequestMapping("/test17/{name}")
    @ResponseBody
    public void test17(@PathVariable(value = "name") String username) throws IOException {
        System.out.println(username);
    }


    /**
     * RequestParam的使用
     *
     * @param username
     * @throws IOException
     */
    @RequestMapping("/test16")
    @ResponseBody
    public void test16(@RequestParam(value = "name", required = false, defaultValue = "默认值") String username) throws IOException {
        //required默认为true,如果没有该参数则保错，defaultValue为未提交时的默认值
        System.out.println(username);

    }

    @RequestMapping("/test15")
    @ResponseBody
    public void test15(@RequestBody List<User> list) throws IOException {
        System.out.println(list);

    }

    /**
     * 目前获取集合对象只能封装在javabean中
     *
     * @param vo
     * @throws IOException
     */
    @RequestMapping("/test14")
    @ResponseBody
    public void test14(VO vo) throws IOException {
        System.out.println("vo = " + vo);
    }

    /**
     * 请求数组
     *
     * @param username
     * @param age
     * @throws IOException
     */
    @RequestMapping("/test13")
    @ResponseBody
    public void test13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }


    /**
     * 获取请求数据（基本类型）
     *
     * @param username
     * @param age
     * @throws IOException
     */
    @RequestMapping("/test12")
    @ResponseBody
    public void test12(String username, int age) throws IOException {
        System.out.println(username);
        System.out.println(age);

    }

    /**
     * 使用了 <mvc:annotation-driven>配置文件
     *
     * @return
     * @throws IOException
     */
    @RequestMapping("/test11")
    @ResponseBody
    public User test11() throws IOException {
        User user = new User("zhangsan", 18);

        return user;
    }

    /**
     * xml配置适配器
     *
     * @return
     * @throws IOException
     */
    @RequestMapping("/test10")
    @ResponseBody
    public User test10() throws IOException {
        User user = new User("zhangsan", 18);
       /* ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);*///可以注释
        return user;
    }


    /**
     * 导包
     * 返回json
     *
     * @return
     * @throws IOException
     */
    @RequestMapping("/test09")
    @ResponseBody
    public String test09() throws IOException {
        User user = new User("zhangsan", 18);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;
    }

    /**
     * 直接把json输出到页面
     *
     * @return
     * @throws IOException
     */
    @RequestMapping("/test08")
    @ResponseBody
    public String test08() throws IOException {
        return "{\"username\":\"张三\",\"age\":18}";
    }

    /**
     * 告诉spring框架只输出到页面，不进行页面跳转
     *
     * @param
     * @throws IOException
     */
    @RequestMapping("/test07")
    @ResponseBody
    public String test07() throws IOException {

        return "Hello ResponseBody";


    }


    /**
     * 向页面写会数据，不需要返回值
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("/test06")
    public void test06(HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello Response");

    }


    @RequestMapping("/test05")
    public String test05(HttpServletRequest request) {
        request.setAttribute("username", "张三");
        return "success";
    }


    /**
     * addAttribute
     *
     * @param model
     * @return
     */
    @RequestMapping("/test04")
    public String test04(Model model) {
        model.addAttribute("username", "wangwu");
        return "success";
    }

    /**
     * spring会为你所需的参数自动注入
     * ModelAndView
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("/test03")
    public ModelAndView test03(ModelAndView modelAndView) {
        modelAndView.setViewName("success");
        modelAndView.addObject("username", "lisi");
        return modelAndView;


    }

    /**
     * 模型and视图
     *
     * @return
     */
    @RequestMapping("/test02")
    public ModelAndView test02() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("username", "zhangsan");
        return modelAndView;

    }

    /**
     * 会自动把请求数据封装在javaBean中
     *
     * @param user
     */
    @RequestMapping("/test01")
    @ResponseBody
    public void Demo(User user) {
        System.out.println(user);
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("controller save running...");
        return "success";
    }


}
