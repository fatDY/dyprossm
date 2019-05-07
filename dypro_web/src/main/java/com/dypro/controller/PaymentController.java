package com.dypro.controller;

import com.dypro.domain.Payment;
import com.dypro.service.IPaymentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5") int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Payment> paymentList = paymentService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(paymentList);
        mv.addObject("pageInfo",pageInfo);
        // mv.addObject("paymentList",paymentList);
        mv.setViewName("payment/payment-list");
        //System.out.println(paymentList);
        return mv;
    }
}
