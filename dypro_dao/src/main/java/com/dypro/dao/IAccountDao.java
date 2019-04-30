package com.dypro.dao;

import com.dypro.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的账户信息
     * @return
     * @throws Exception
     */
    @Select("select * from account")
    @Results({
            //查询银行关联对象
            @Result(
                    property = "bankId",
                    column = "bankid",
                    one = @One(select = "com.dypro.dao.IBankDao.selectById")
            )
    })
    List<Account> findAll() throws Exception;

    /**
     * 根据银行号码获取Account类
     * @param accountNo
     * @return
     */
    @Select("select * from account where accountno = #{accountNo}")
    @Results({
            //查询银行关联对象
            @Result(
                    property = "bankId",
                    column = "bankid",
                    one = @One(select = "com.dypro.dao.IBankDao.selectById")
            )
    })
    Account selectByAccountNo(@Param("accountNo") String accountNo) throws Exception;

    @Select("select * from account where id=#{id}")
    @Results({
            //查询银行关联对象
            @Result(
                    property = "bankId",
                    column = "bankid",
                    one = @One(select = "com.dypro.dao.IBankDao.selectById")
            )
    })
    Account findById(@Param("id") Integer id)throws Exception;
}
