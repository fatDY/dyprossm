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
    public Bank selectById(@Param("id") Integer id);

    /**
     * 查询银行所有信息
     * @return
     */
    @Select("select * from bank")
    public List<Bank> findAll();
    @Insert("insert into bank(bankname,unitecod,location)values(#{bankName},#{uniteCod},#{location})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertBank(Bank bank);
}
