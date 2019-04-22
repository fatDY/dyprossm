package com.dypro.controller;

import com.dypro.domain.Permission;
import com.dypro.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        try {
            List<Permission> permissionList = permissionService.findAll();
            mv.addObject("permissionList", permissionList);
            mv.setViewName("permission-list");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    @RequestMapping("save.do")
    public String save(Permission permission, HttpServletRequest request) {
        if(permission.getPermissionName()!=""&&!"".equals(permission.getPermissionName())
                &&permission.getUrl()!=""&&!"".equals(permission.getUrl())){
            try {
                permissionService.save(permission);
                return "redirect:findAll.do";
            } catch (Exception e) {
                request.setAttribute("Message","添加用户失败，请检查用户是否已存在");
                return "permission-add";
            }

        }
        else {
            request.setAttribute("Message","权限资源名或权限路径不能为空");
            return "permission-add";
        }



    }

}
