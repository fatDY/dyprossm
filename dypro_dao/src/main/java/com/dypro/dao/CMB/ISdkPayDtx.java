package com.dypro.dao.CMB;

import com.dypro.domain.cmb.SdkPayDtx;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

public interface ISdkPayDtx {

    /**
     * 根据id查询信息
     * @return
     */
    @Select("select * from sdkpaydtx where paymentid = #{paymentId}")
    SdkPayDtx findById(@Param("paymentId") String paymentId) throws Exception;

    @Insert("INSERT INTO sdkpaydtx(paymentid,yurref,dbtacc,c_dbtbbk,trsamt,c_ccynbr,nusage,crtacc,crtnam,crtbnk,crtpvc,crtcty) " +
            "VALUES(#{paymentId},#{yurRef},#{dbtAcc},#{c_dbtBbk},#{trsAmt}," +
            "#{c_ccyNbr},#{nuSage},#{crtAcc},#{crtNam}," +
            "#{crtBnk},#{crtpvc},#{crtCty})")
    void save(@Param("paymentId") String paymentId,@Param("yurRef") String yurRef,
              @Param("dbtAcc")String dbtAcc, @Param("c_dbtBbk") String c_dbtBbk,
              @Param("trsAmt") BigDecimal trsAmt, @Param("c_ccyNbr") String c_ccyNbr,
              @Param("nuSage")String nuSage,@Param("crtAcc") String crtAcc,
              @Param("crtNam")String crtNam,@Param("crtBnk") String crtBnk,
              @Param("crtpvc")String crtpvc,@Param("crtCty")String crtCty) throws Exception;
}
