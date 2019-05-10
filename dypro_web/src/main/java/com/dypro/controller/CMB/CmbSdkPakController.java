package com.dypro.controller.CMB;

import com.dypro.domain.cmb.cmbSdkPgk;
import com.dypro.service.CMB.ICmbSdkPgkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cmb")
public class CmbSdkPakController {
    @Autowired
    private ICmbSdkPgkService cmbSdkPgkService;
  /*  @RequestMapping("/findById.do")
    public ModelAndView findById() throws Exception{
      ModelAndView mv=new ModelAndView();
        cmbSdkPgk cmbSdkPgk = cmbSdkPgkService.findById("XC11212222212122");
        mv.addObject("cmbSdkPgk",cmbSdkPgk);
        System.out.println(cmbSdkPgk);
        return mv;
    }*/

    /**
     * Ajax查询付款单据银行指令
     * @param paymentId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findById.do")
    public @ResponseBody cmbSdkPgk findById(@RequestBody String paymentId) throws Exception {
        String id = paymentId.split("=")[1];
        cmbSdkPgk cmbSdkPgk = cmbSdkPgkService.findById(id);
        return cmbSdkPgk;
    }
}
