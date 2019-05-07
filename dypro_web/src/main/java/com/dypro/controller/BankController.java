package com.dypro.controller;

import com.dypro.domain.Bank;
import com.dypro.service.IBankService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/bank")
public class BankController {
    @Autowired
   private IBankService bankService;
    @RequestMapping("/update.do")
    public String update(Bank bank,HttpServletRequest request){
        if (bank.getBankName()!=null&&!"".equals(bank.getBankName())
                &&bank.getUniteCode()!=null&&!"".equals(bank.getUniteCode())
                &&bank.getBankCity()!=null&&!"".equals(bank.getBankCity())
                &&bank.getBankProvince()!=null&&!"".equals(bank.getBankProvince())  ){
            try {
                bankService.update(bank);
                return "redirect:findAll.do";
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("Message", "更新失败");
                return "redirect:findAll.do";
            }

        }
        else {
            request.setAttribute("Message", "添加失败，修改信息不能为空");
            return "bank/bank-update";
        }
    }
    /**
     * 编辑操作
     * @param bankId
     * @return
     * @throws Exception
     */
    @RequestMapping("/bankUpdateList.do")
    public ModelAndView bankUpdateList(@RequestParam(name = "id") Integer bankId) throws Exception {

        ModelAndView mv=new ModelAndView();
        Bank bankList = bankService.selectById(bankId);
        mv.addObject("bankList",bankList);
        mv.setViewName("bank/bank-update");
        return mv;
    }
    /**
     * 保存银行信息
     * @param bank
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public  String save(Bank bank, HttpServletRequest request)throws Exception{
        if (bank.getBankName()!=null&&!"".equals(bank.getBankName())
                &&bank.getUniteCode()!=null&&!"".equals(bank.getUniteCode())
                &&bank.getBankCity()!=null&&!"".equals(bank.getBankCity())
                &&bank.getBankProvince()!=null&&!"".equals(bank.getBankProvince())  ){
            //判断当前银行是否已存在
          Bank bankinfo= bankService.findByUniteCode(bank.getUniteCode());
          if (bankinfo==null){
              bankService.insertBank(bank);
              return "redirect:findAll.do";
          }
          else {
              request.setAttribute("Message", "添加失败，该银行已存在，请检查联行号");
              return "bank/bankB-add";
          }
        }
        else {
            request.setAttribute("Message", "添加失败，请检查提交信息是否完整");
            return "bank/bankB-add";
        }

    }
    //查询所有银行信息返回
    @RequestMapping("findBankToAccount.do")
    public ModelAndView findBankToAccount(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                          @RequestParam(name = "size",required = true,defaultValue = "5") int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Bank> bankList = bankService.findAll(page,size);
       // mv.addObject("bankList",bankList);
        PageInfo pageInfo=new PageInfo(bankList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("bank/bank-add");
        return mv;
    }
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5") int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Bank> bankList = bankService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(bankList);
        mv.addObject("pageInfo",pageInfo);
       // mv.addObject("bankList",bankList);
        mv.setViewName("bank/bank-list");
        return mv;
    }
}
