package com.dypro.dao;

import com.dypro.domain.Payment;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPaymentDao {
    /**
     * 查询所有付款单
     * @return
     * @throws Exception
     */
    @Select("select * from payment")
    @Results({
            //查询关联对象
            @Result(
                    property = "paymentAccountId",
                    column = "paymentaccountid",
                    one = @One(select = "com.dypro.dao.IAccountDao.findById")
            )
    })
    List<Payment> findAll() throws Exception;
}
