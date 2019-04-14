package com.dypro.dao;

import com.dypro.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的账户信息
     * @return
     * @throws Exception
     */
    @Select("select * from account")
    public List<Account> findAll() throws Exception;
}
