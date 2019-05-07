package com.dypro.controller;

import com.dypro.domain.Account;
import com.dypro.domain.Bank;
import com.dypro.service.IAccountService;
import com.dypro.service.IBankService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 账户控制器
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IBankService bankService;

    /**
     * 根据账户id删除账户
     *
     * @param accountId
     * @return
     */
    @RequestMapping("/delAccountById.do")
    public String delAccountById(@RequestParam(name = "id") Integer accountId) {
        try {
            accountService.setDelAccount(accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:findAll.do";
    }
    /**
     * 添加账户
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Account account,@RequestParam(name = "banksId") String banksId, HttpServletRequest request) {
        if (account.getAccountName() != "" && !"".equals(account.getAccountName())
                || account.getAccountNo() != "" && !"".equals(account.getAccountNo())||banksId!=null&&!"".equals(banksId) ) {
            try {
           Account account1 = accountService.findByAccountNo(account.getAccountNo());
           if (account1==null||"".equals(account1)){
                    accountService.save(account,banksId);
                    return "redirect:findAll.do";
                }
                else {
               request.setAttribute("Message", "该账号已存在");
               return "account/account-add";
           }

            } catch (Exception e) {
                request.setAttribute("Message", "添加失败，请检查提交信息是否完整");
                return "account/account-add";
            }
        } else {
            request.setAttribute("Message", "账户名或号码,银行不能为空");
            return "account/account-add";
        }
    }
    /**
     * 返回选择的银行信息
     * @return
     */
    @RequestMapping("/backToAccountAdd.do")
    public  ModelAndView backToAccountAdd(@RequestParam(name = "ids")String[] bankIds, HttpServletRequest request) throws Exception {
        ModelAndView mv=new ModelAndView();
        int length = bankIds.length;
        if (length>1||length==0){
            request.setAttribute("Message","只能选择一个银行");
            mv.setViewName("account/account-add");
            return mv;
        }
        else {
            Integer id=Integer.valueOf(bankIds[0]);
           Bank bankList= bankService.selectById(id);
            mv.addObject("bankList",bankList);
            mv.setViewName("account/account-add");
            return mv;
        }
    }
    /**
     * Ajax返回账户详细信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findById.do")
    public @ResponseBody Account findById(@RequestBody String id) throws Exception {
        Integer accountId=Integer.valueOf(id.split("=")[1]);
        Account account=accountService.findById(accountId);
        return account;
    }
    @RequestMapping("/findAll.do")
      /*  @RolesAllowed("ADMIN")*/
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5") int size) {
        ModelAndView mv=new ModelAndView();
        try {
            List<Account> accountList = accountService.findAll(page,size);
            PageInfo pageInfo=new PageInfo(accountList);
            mv.addObject("pageInfo",pageInfo);
            //mv.addObject("accountList",accountList);
            mv.setViewName("account/account-list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
