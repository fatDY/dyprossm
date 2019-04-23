package com.dypro.dao;

import com.dypro.domain.Bank;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IBankDao {
    /**
     * 根据id查询银行信息
     * @return
     */
    @Select("select * from bank where id = #{id}")
    Bank selectById(@Param("id") Integer id) throws Exception;

    /**
     * 查询银行所有信息
     * @return
     */
    @Select("select * from bank")
    List<Bank> findAll() throws Exception;

    /**
     * 插入银行语句
     * @param bank
     */
    @Insert("insert into bank(bankname,unitecod,bankprovince,bankcity)values(#{bankName},#{uniteCod},#{bankProvince},#{bankCity})")
    void insertBank(Bank bank) throws Exception;
}
