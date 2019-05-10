package com.dypro.dao.CMB;

import com.dypro.domain.cmb.Info;
import com.dypro.domain.cmb.SdkPayDtx;
import com.dypro.domain.cmb.SdkPayRqx;
import com.dypro.domain.cmb.cmbSdkPgk;
import org.apache.ibatis.annotations.*;

public interface ICmbSdkPgk {
    @Select("select * from cmbsdkpgk where paymentid=#{paymentId} ")
    @Results({
            //查询关联对象
           /* @Result(id = true, property = "paymentId", column = "paymentid"),*/
            @Result(
                    property = "infoId",
                    column = "infoid",
                    javaType = Info.class,
                    one = @One(select = "com.dypro.dao.CMB.IInfoDao.findById")
            ),
            @Result(
                    property = "sdkPayRqxId",
                    column = "sdkpayrqxid",
                    javaType = SdkPayRqx.class,
                    one = @One(select = "com.dypro.dao.CMB.ISdkPayRqx.findById")
            ),
            @Result(
                    property = "sdkPayDtxId",
                    column = "sdkpaydtxid",
                    javaType = SdkPayDtx.class,
                    one = @One(select = "com.dypro.dao.CMB.ISdkPayDtx.findById")
            )
    })
    cmbSdkPgk findById(@Param("paymentId") String paymentId) throws Exception;

    @Insert("insert into cmbsdkpgk(paymentid,infoid,sdkpayrqxid,sdkpaydtxid) " +
            "VALUES (#{paymentId},#{infoid},#{sdkpayrqxid},#{sdkpaydtxid})")
    void save(@Param("paymentId") String paymentId,@Param("infoid") String paymentId1,
              @Param("sdkpayrqxid")String paymentId2,@Param("sdkpaydtxid") String paymentId3) throws Exception;
}
