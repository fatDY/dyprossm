package com.dypro.service.impl;

import com.dypro.dao.IAccountDao;
import com.dypro.domain.Account;
import com.dypro.service.IAccountService;
import com.github.pagehelper.PageHelper;
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
    public List<Account> findAll(int page, int size) throws Exception {
        //页码值
        PageHelper.startPage(page,size);
        return accountDao.findAll();
    }

    @Override
    public Account selectByAccountNo(String accountNo) throws Exception {
        return accountDao.selectByAccountNo(accountNo);
    }

    @Override
    public Account findById(Integer id) throws Exception {
        return accountDao.findById(id);
    }

    @Override
    public Account findByAccountNo(String accountNo) throws Exception {
        return accountDao.findByAccountNo(accountNo);
    }

    @Override
    public void save(Account account,String banksId) throws Exception {
        String currencyid = account.getCurrencyid();
        String accountName = account.getAccountName();
        String accountNo = account.getAccountNo();
        String accountPurposeId = account.getAccountPurposeId();
        String accountType = account.getAccountType();
        accountDao.save(currencyid,accountNo,accountName,accountPurposeId,banksId,accountType);
    }

    @Override
    public void setDelAccount(Integer accountId) throws Exception {
        accountDao.setDelAccount(accountId);
    }
}
