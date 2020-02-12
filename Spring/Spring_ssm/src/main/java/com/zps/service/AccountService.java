package com.zps.service;

import com.zps.domin.Account;

import java.util.List;

public interface AccountService {

    public void save(Account account) throws Exception;

    public List<Account> findAll() throws Exception;
}
