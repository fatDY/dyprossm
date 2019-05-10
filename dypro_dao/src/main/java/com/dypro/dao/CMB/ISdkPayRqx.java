package com.dypro.dao.CMB;


import com.dypro.domain.cmb.SdkPayRqx;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ISdkPayRqx {
    /**
     * 根据id查询信息
     * @return
     */
    @Select("select * from sdkpayrqx where paymentid = #{paymentId}")
    SdkPayRqx findById(@Param("paymentId") String paymentId) throws Exception;

    @Insert("insert into sdkpayrqx(paymentid) value(#{paymentId})")
    void save(@Param("paymentId") String paymentId) throws Exception;
}
