package com.dypro.controller;

import com.dypro.domain.UserInfo;
import com.dypro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public String save(UserInfo userInfo, HttpServletRequest request){
        if(userInfo.getUsername()!=""&&!"".equals(userInfo.getUsername())
                &&userInfo.getPassword()!=""&&!"".equals(userInfo.getPassword())){
            try {
                userService.save(userInfo);
                return "redirect:findAll.do";
            } catch (Exception e) {
                request.setAttribute("Message","添加用户失败，请检查用户是否已存在");
                return "user-add";
            }
        }
        else {
            request.setAttribute("Message","用户或密码不能为空");
            return "user-add";
        }
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
