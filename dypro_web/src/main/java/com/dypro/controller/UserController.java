package com.dypro.controller;

import com.dypro.domain.Role;
import com.dypro.domain.UserInfo;
import com.dypro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping("/addRoleToUser.do")
   public String addRoleToUser(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "ids") String[] roleIds,HttpServletRequest request){
        try {
            userService.addRoleToUser(userId,roleIds);
            return "redirect:findAll.do";
        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("Message","添加角色失败");
            return "user-role-add";
        }

    }
    /**
     * 查询用户以及用户可以添加的角色
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String id){
        ModelAndView mv=new ModelAndView();
        Integer userid=Integer.valueOf(id);
        //根据用户id查询用户
        try {
            UserInfo userInfo = userService.findById(userid);
            //根据用户的id查询可添加的角色
            List<Role> otherRoles=userService.findOtherRoles(userid);
            mv.addObject("user",userInfo);
            mv.addObject("roleList",otherRoles);
            mv.setViewName("user-role-add");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
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