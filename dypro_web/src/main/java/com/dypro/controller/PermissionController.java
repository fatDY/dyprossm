package com.dypro.controller;

import com.dypro.domain.Permission;
import com.dypro.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

}
