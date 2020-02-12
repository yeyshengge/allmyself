package com.zps.controller;

import com.zps.domin.Account;
import com.zps.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/save", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String save(Account account) throws Exception {
        try {
            accountService.save(account);
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败";
        }
        return "保存成功";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        List<Account> list = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("accountList");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

}
