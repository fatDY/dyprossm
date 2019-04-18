package com.dypro.controller;

import com.dypro.domain.UserInfo;
import com.dypro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用户信息操作
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询指定ID的用户信息
     * @param id
     * @return
     */
    @RequestMapping("findById.do")
    public ModelAndView findById(Integer id) throws Exception {
        ModelAndView mv=new ModelAndView();
        UserInfo userInfos=userService.findById(id);
        mv.addObject("userinfo",userInfos);
        mv.setViewName("user-show");
        return mv;
    }
    /**
     * 添加用户
     * @return
     * @throws Exception
     */
    @RequestMapping("save.do")
    public String save(UserInfo userInfo) throws  Exception{
       // ModelAndView mv =new ModelAndView();
        userService.save(userInfo);

        return "redirect:findAll.do";
    }

    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<UserInfo> userInfos= userService.findAll();
        mv.addObject("userList",userInfos);
        mv.setViewName("user-list");
        return mv;
    }
}
