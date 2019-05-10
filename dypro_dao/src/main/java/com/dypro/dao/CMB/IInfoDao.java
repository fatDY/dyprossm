package com.dypro.dao.CMB;

import com.dypro.domain.cmb.Info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IInfoDao {
    /**
     * 根据id查询抬头信息
     * @return
     */
    @Select("select * from info where paymentid = #{paymentId}")
    Info findById(@Param("paymentId") String paymentId) throws Exception;

    @Insert("insert into info(paymentid,funnam) value(#{paymentId},#{funnam})")
    void save(@Param("funnam") String funnam, @Param("paymentId") String paymentId) throws Exception;
}
