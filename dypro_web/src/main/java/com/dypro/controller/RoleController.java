package com.dypro.controller;

import com.dypro.domain.Role;
import com.dypro.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    /**
     * 新建角色
     * @param role
     * @return
     */
    @RequestMapping("save.do")
    public String save(Role role, HttpServletRequest request){
        if(role.getRoleName()!=""&&!"".equals(role.getRoleName())
                &&role.getRoleDesc()!=""&&!"".equals(role.getRoleDesc())){
            try {
                roleService.save(role);
                return "redirect:findAll.do";
            } catch (Exception e) {
                request.setAttribute("Message","添加角色失败，请检查角色是否已存在");
                return "role-add";
            }

        }
        else {
            request.setAttribute("Message","角色名或角色描述不能为空");
            return "role-add";
        }


    }

    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        try {
            List<Role> roleList = roleService.findAll();
            mv.addObject("roleList",roleList);
            mv.setViewName("role-list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
