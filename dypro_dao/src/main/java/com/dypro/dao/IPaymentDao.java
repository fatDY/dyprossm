package com.dypro.dao;

import com.dypro.domain.Payment;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

public interface IPaymentDao {
    /**
     * 查询所有付款单
     *
     * @return
     * @throws Exception
     */
    @Select("select * from payment order by paymentdate desc")
    @Results({
            //查询关联对象
            @Result(
                    property = "paymentAccountId",
                    column = "paymentaccountid",
                    one = @One(select = "com.dypro.dao.IAccountDao.findById")
            )
    })
    List<Payment> findAll() throws Exception;

    @Select("select * from payment where id=#{id}")
    @Results({
            //查询关联对象
            @Result(
                    property = "paymentAccountId",
                    column = "paymentaccountid",
                    one = @One(select = "com.dypro.dao.IAccountDao.findById")
            )
    })
    Payment findById(@Param("id") Integer paymentId) throws Exception;

    @Select("select * from payment where paymentid=#{id}")
    @Results({
            //查询关联对象
            @Result(
                    property = "paymentAccountId",
                    column = "paymentaccountid",
                    one = @One(select = "com.dypro.dao.IAccountDao.findById")
            )
    })
    Payment findByPaymentId(@Param("id") String random) throws Exception;

    @Insert("insert into payment(paymentid,paymentaccountid,paymentamount,recname,recaccount,recbankname," +
            "recprovince,recity,recunitecode,memo) value(#{paymentId},#{paymentAccountId},#{paymentAmount}," +
            "#{recName},#{recAccount},#{recBankName},#{recProvince},#{reCity},#{recUniteCode},#{memo})")
    void save(@Param("paymentId") String paymentId, @Param("paymentAmount") BigDecimal paymentAmount, @Param("memo") String memo,
              @Param("recAccount") String recAccount, @Param("recName") String recName, @Param("recBankName") String recBankName,
              @Param("recUniteCode") String recUniteCode, @Param("reCity") String reCity, @Param("recProvince") String recProvince,
              @Param("paymentAccountId") Integer accountId) throws Exception;

    @Update("update payment set paymentAmount=#{paymentAmount},memo=#{memo},recAccount=#{recAccount},recName=#{recName}," +
            "recName=#{recName},recBankName=#{recBankName},recUniteCode=#{recUniteCode},reCity=#{reCity}," +
            "recProvince=#{recProvince},paymentAccountId=#{paymentAccountId} where id=#{id}")
    void update(@Param("id") Integer id, @Param("paymentAmount") BigDecimal paymentAmount, @Param("memo") String memo,
                @Param("recAccount") String recAccount, @Param("recName") String recName, @Param("recBankName") String recBankName,
                @Param("recUniteCode") String recUniteCode, @Param("reCity") String reCity, @Param("recProvince") String recProvince,
                @Param("paymentAccountId") Integer accountId);

    @Delete("delete from payment where id =#{id}")
    void delPaymentById(@Param("id") String id) throws Exception;

    @Update("update payment set statement=#{i} where id=#{id}")
    void updateConfirmPayment(@Param("id") String id, @Param("i") String i);

    @Select("select * from payment where statement='1' order by paymentdate desc")
    @Results({
            //查询关联对象
            @Result(
                    property = "paymentAccountId",
                    column = "paymentaccountid",
                    one = @One(select = "com.dypro.dao.IAccountDao.findById")
            )
    })
    List<Payment> findAllConfirm() throws Exception;
}
