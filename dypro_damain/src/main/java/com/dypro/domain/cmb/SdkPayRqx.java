package com.dypro.domain.cmb;

import org.springframework.stereotype.Component;

/**
 * 付款信息抬头
 */
@Component
public class SdkPayRqx {
   // private  String paymentId; //付款单据Id
    private String busCod; //业务类别 默认N2031
    private String busMod;//业务模式名称 默认00001
   /* public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }*/

    public String getBusCod() {
        return busCod;
    }

    public void setBusCod(String busCod) {
        this.busCod = busCod;
    }

    public String getBusMod() {
        return busMod;
    }

    public void setBusMod(String busMod) {
        this.busMod = busMod;
    }

    @Override
    public String toString() {
        return "SdkPayRqx{" +
                "busCod='" + busCod + '\'' +
                ", busMod='" + busMod + '\'' +
                '}';
    }
}
