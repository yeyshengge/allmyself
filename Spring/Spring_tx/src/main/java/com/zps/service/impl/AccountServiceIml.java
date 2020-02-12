package com.zps.service.impl;

import com.zps.dao.AccountDao;
import com.zps.service.AccountService;

public class AccountServiceIml implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan, money);
        int a = 3 / 0;
        accountDao.in(inMan, money);
    }
}
