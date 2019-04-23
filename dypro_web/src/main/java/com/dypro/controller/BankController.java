package com.dypro.controller;

import com.dypro.domain.Bank;
import com.dypro.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/bank")
public class BankController {
    @Autowired
   private IBankService bankService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Bank> bankList = bankService.findAll();
        mv.addObject("bankList",bankList);
        mv.setViewName("bank-list");
        return mv;
    }
}
