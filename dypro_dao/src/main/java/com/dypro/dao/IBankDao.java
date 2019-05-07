package com.dypro.dao;

import com.dypro.domain.Bank;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Insert("insert into bank(bankName,uniteCode,bankProvince,bankCity) value(#{bankName},#{uniteCode},#{bankProvince},#{bankCity})")
    void insertBank(Bank bank) throws Exception;

    @Select("select * from bank where uniteCode=#{uniteCode}")
    Bank findByUniteCode(@Param("uniteCode") String uniteCode) throws Exception;
    @Update("update bank set bankName=#{bankName},bankProvince=#{bankProvince},bankCity=#{bankCity}" +
            "where id=#{id}")
    void update(Bank bank) throws Exception;
}
