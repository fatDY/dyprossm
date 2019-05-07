package com.dypro.service.impl;

import com.dypro.dao.IBankDao;
import com.dypro.domain.Bank;
import com.dypro.service.IBankService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IBankServiceImpl implements IBankService {
    @Autowired
    private IBankDao bankDao;
    @Override
    public Bank selectById(Integer id) throws Exception {
        return bankDao.selectById(id) ;
    }

    @Override
    public List<Bank> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return bankDao.findAll();
    }

    @Override
    public void insertBank(Bank bank) throws Exception {
        bankDao.insertBank(bank);
    }

    @Override
    public Bank findByUniteCode(String uniteCode) throws Exception {
        return bankDao.findByUniteCode(uniteCode);
    }

    @Override
    public void update(Bank bank) throws Exception {
        bankDao.update(bank);
    }
}
