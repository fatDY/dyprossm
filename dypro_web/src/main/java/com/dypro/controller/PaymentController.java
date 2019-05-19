package com.dypro.controller;

import com.dypro.domain.Account;
import com.dypro.domain.Payment;
import com.dypro.service.CMB.ICmbSdkPgkService;
import com.dypro.service.IAccountService;
import com.dypro.service.IPaymentService;
import com.dypro.utils.PaymentCheckUtils;
import com.dypro.utils.RandomCharDataUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ICmbSdkPgkService cmbSdkPgkService;

    /**
     * 查询所有指令状态付款单
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findPaymentToBank.do")
    public ModelAndView findPaymentToBank(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                       @RequestParam(name = "size",required = true,defaultValue = "5") int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Payment> paymentList = paymentService.findPaymentToBank(page,size);
        PageInfo pageInfo=new PageInfo(paymentList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("payment/payment-bank-list");
        return mv;
    }

    /**
     * 指令发送确认
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("confirmPaymentToBank.do")
    public ModelAndView confirmPaymentToBank(@RequestParam(name = "ids") String[] ids) throws Exception{
        ModelAndView mv=new ModelAndView();
        if (ids.length>0){
            for (String id : ids) {
                Payment paymentInfo = paymentService.findById(Integer.valueOf(id));
                //将paymentInfo封装进银行指令中
                cmbSdkPgkService.savePaymentToCmb(paymentInfo);
                if (paymentInfo.getStatement().equals("审批中")){
                    String statement=String.valueOf(2);
                    paymentService.updateConfirmPayment(id,statement);
                }
            }
        }
        mv.setViewName("redirect:findAllConfirm.do");
        return mv;
    }

    /**
     * 复核单据退回
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateBackPayment.do")
    public ModelAndView updateBackPayment(@RequestParam(name = "ids") String[] ids) throws Exception{
        ModelAndView mv=new ModelAndView();
        if (ids.length>0){
            for (String id : ids) {
                Payment paymentInfo = paymentService.findById(Integer.valueOf(id));
                if (paymentInfo.getStatement().equals("指令发送中")){
                    mv.addObject("Message","该单据已提交指令发送");
                    mv.setViewName("forward:findAllConfirm.do");
                    return mv;
                }
                System.out.println(paymentInfo.getStatement());
                if (paymentInfo.getStatement().equals("审批中")){
                    String statement=String.valueOf(0);
                    paymentService.updateConfirmPayment(id,statement);
                }
            }
        }
        mv.setViewName("redirect:findAllConfirm.do");
        return mv;
    }
    /**
     * 查询所有提交状态付款单
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllConfirm.do")
    public ModelAndView findAllConfirm(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                       @RequestParam(name = "size",required = true,defaultValue = "5") int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Payment> paymentList = paymentService.findAllConfirm(page,size);
        PageInfo pageInfo=new PageInfo(paymentList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("payment/payment-confirm-list");
        return mv;
    }
    /**
     * 提交状态
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/confirmPayment.do")
    public ModelAndView confirmPayment(@RequestParam(name = "ids",defaultValue="empty") String[] ids) throws Exception {
        ModelAndView mv=new ModelAndView();
        if (ids.length>0){
            for (String id : ids) {
                if ("empty".equals(id)){
                    mv.setViewName("redirect:findAll.do");
                }
                else{
                    Payment paymentInfo = paymentService.findById(Integer.valueOf(id));
                    if (!paymentInfo.getStatement().equals("保存")){
                        mv.addObject("Message","该单据已提交请等待复核");
                        mv.setViewName("forward:findAll.do");
                        return mv;
                    }
                   // System.out.println(paymentInfo.getStatement());
                    if (paymentInfo.getStatement().equals("保存")){
                        String statement=String.valueOf(1);
                        paymentService.updateConfirmPayment(id,statement);
                    }}

            }
        }
        mv.setViewName("redirect:findAll.do");
        return mv;
    }
    /**
     * 删除
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/paymentDelete.do")
    public ModelAndView paymentDelete(@RequestParam(name = "ids",defaultValue="empty") String[] ids) throws Exception {
      ModelAndView mv=new ModelAndView();
        if (ids.length>0){
            for (String id : ids) {
                if ("empty".equals(id)){
                    mv.setViewName("redirect:findAll.do");
                }
                else { Payment paymentInfo = paymentService.findById(Integer.valueOf(id));
                    if (!paymentInfo.getStatement().equals("保存")){
                        mv.addObject("Message","该单据已提交请等待复核后处理");
                        mv.setViewName("forward:findAll.do");
                        return mv;
                    }
                    if (paymentInfo.getStatement().equals("保存")){
                        paymentService.delPaymentById(ids);
                        mv.setViewName("redirect:findAll.do");
                    }}

            }

        }
        return mv;
    }
    /**
     * 更新付款单信息
     * @param payment
     * @param accountId
     * @param amount
     * @return
     */
    @RequestMapping("/update.do")
    public ModelAndView update(Payment payment,@RequestParam(name = "accountId") Integer accountId,@RequestParam(name = "amount") String amount){
        ModelAndView mv=new ModelAndView();
        String message = PaymentCheckUtils.checkPayment(payment, accountId, amount);
        if (message==null||message.equals("")){
            payment.setPaymentAmount(new BigDecimal(amount));
            try {
                paymentService.update(payment,accountId);
                mv.addObject("Message","更新成功");
                mv.setViewName("redirect:findAll.do");
            } catch (Exception e) {
                mv.addObject("Message",e.getMessage());
                mv.setViewName("forward:findAll.do");
            }
        }
        else {
            mv.addObject("Message",message);
            mv.setViewName("forward:findAll.do");
        }
     //   System.out.println(payment);
      //  System.out.println(accountId+amount);
        return mv;
    }
    /**
     * 付款更新单
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/paymentUpdate.do")
    public ModelAndView paymentUpdate(@RequestParam(name = "ids",defaultValue="empty") String[] ids,HttpServletRequest request) throws Exception {
        ModelAndView mv=new ModelAndView();
        if(ids.length!=1){
            mv.setViewName("redirect:findAll.do");
        }
        else {
            for (String id : ids) {
                if ("empty".equals(id)){
                    mv.setViewName("redirect:findAll.do");
                }
                else {
                    Payment paymentInfo = paymentService.findById(Integer.valueOf(id));
                    if (!paymentInfo.getStatement().equals("保存")){
                        mv.addObject("Message","该单据已提交请等待复核，无法修改");
                        mv.setViewName("forward:findAll.do");
                        //   return mv;
                    }
                    // System.out.println(paymentInfo.getStatement());
                    if (paymentInfo.getStatement().equals("保存")){
                        Integer id1=Integer.valueOf(id);
                            Payment paymentList = paymentService.findById(id1);
                            mv.addObject("paymentList",paymentList);

                        mv.setViewName("payment/payment-update");
                        // return mv;
                    }
                }
            }

        }
            return mv;
    }
    /**
     * 保存付款单
     * @param payment
     * @param accountId
     * @param amount
     * @return
     */
    @RequestMapping("/save.do")
    public ModelAndView save(Payment payment,@RequestParam(name = "accountId") Integer accountId,@RequestParam(name = "amount") String amount){
        ModelAndView mv=new ModelAndView();
        String message = PaymentCheckUtils.checkPayment(payment, accountId, amount);
        if (message==null||message.equals("")){
            payment.setPaymentAmount(new BigDecimal(amount));
            try {
                paymentService.save(payment,accountId);
                mv.addObject("Message","添加成功");
                mv.setViewName("redirect:findAll.do");
            } catch (Exception e) {
                mv.addObject("Message",e.getMessage());
                mv.setViewName("forward:paymentAddView.do");
            }
        }
       else {
            mv.addObject("Message",message);
            mv.setViewName("forward:paymentAddView.do");
        }
        return mv;
    }
    /**
     * 返回付款单据添加页面
     * @param accountIds
     * @param paymentId
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/backToPaymentAdd.do")
    public  ModelAndView backToAccountAdd(@RequestParam(name = "ids")String[] accountIds,@RequestParam(name = "paymentId") String paymentId, HttpServletRequest request) throws Exception {
        ModelAndView mv=new ModelAndView();
        int length = accountIds.length;
        if (length>1||length==0){
            request.setAttribute("Message","只能选择一个账户");
            return new ModelAndView("forward:paymentAddView.do");
        }
        else {
            Integer id=Integer.valueOf(accountIds[0]);
            Account accountList= accountService.findById(id);
            mv.addObject("accountList",accountList);
            Payment paymentList = paymentService.findByPaymentId(paymentId);
            if(paymentList!=null){
                mv.addObject("paymentList",paymentList);
                mv.setViewName("payment/payment-update");
            }
           else {
                mv.addObject("paymentId",paymentId);
                mv.setViewName("payment/payment-add");
            }

          //  mv.addObject("payIds",);

            return mv;
        }
    }
    /**
     * 获取付款账户信息
     * @param page
     * @param size
     * @param paymentId
     * @return
     * @throws Exception
     */
    @RequestMapping("findAccountToPayment.do")
    public ModelAndView findAccountToPayment(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                          @RequestParam(name = "size",required = true,defaultValue = "5") int size,@RequestParam(name = "paymentId") String paymentId) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Account> accountList = accountService.findAll(page,size);
        // mv.addObject("bankList",bankList);
        PageInfo pageInfo=new PageInfo(accountList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("paymentId",paymentId);
        mv.setViewName("payment/payment-account-add");
        return mv;
    }
    /**
     * 自定获取订单编号
     * @return
     */
    @RequestMapping("/paymentAddView.do")
    public ModelAndView paymentAddView() throws Exception {
        ModelAndView mv=new ModelAndView();
        String random="";
        do {
            random = RandomCharDataUtils.getStringRandom(10);
        }
        while (paymentService.findByPaymentId(random)!=null);
        mv.addObject("paymentId",random);
        mv.setViewName("payment/payment-add");
        return mv;
    }
    /**
     * Ajax查询付款单据
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findById.do")
    public @ResponseBody Payment findById(@RequestBody String id) throws Exception {
        Integer paymentId=Integer.valueOf(id.split("=")[1]);
        Payment payment=paymentService.findById(paymentId);
        return payment;
    }
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
