package com.dypro.service.impl;

import com.dypro.dao.IAccountDao;
import com.dypro.domain.Account;
import com.dypro.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IAccountServiceImpl implements IAccountService {
    @Autowired
   private IAccountDao accountDao;
    @Override
    public List<Account> findAll() throws Exception {
        return accountDao.findAll();
    }

    @Override
    public Account selectByAccountNo(String accountNo) throws Exception {
        return accountDao.selectByAccountNo(accountNo);
    }
}
