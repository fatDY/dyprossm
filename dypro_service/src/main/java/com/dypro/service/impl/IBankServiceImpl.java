package com.dypro.service.impl;

import com.dypro.dao.IBankDao;
import com.dypro.domain.Bank;
import com.dypro.service.IBankService;
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
    public List<Bank> findAll() throws Exception {
        return bankDao.findAll();
    }

    @Override
    public void insertBank(Bank bank) throws Exception {
        bankDao.insertBank(bank);
    }
}
