package com.dypro.controller;

import com.dypro.domain.Account;
import com.dypro.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * 账户控制器
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll.do")
/*    @RolesAllowed("ADMIN")*/
    public ModelAndView findAll() {
        ModelAndView mv=new ModelAndView();
        try {
            List<Account> accountList = accountService.findAll();
            mv.addObject("accountList",accountList);
            mv.setViewName("account-list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}
