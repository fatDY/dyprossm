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
    Bank selectById(@Param("id") Integer id);

    /**
     * 查询银行所有信息
     * @return
     */
    @Select("select * from bank")
    List<Bank> findAll();

    /**
     * 插入银行语句
     * @param bank
     */
    @Insert("insert into bank(bankname,unitecod,bankProvince,bankCity)values(#{bankName},#{uniteCod},#{bankProvince},#{bankCity})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertBank(Bank bank);
}
