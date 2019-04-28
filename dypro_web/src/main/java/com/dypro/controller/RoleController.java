package com.dypro.controller;

import com.dypro.domain.Permission;
import com.dypro.domain.Role;
import com.dypro.service.IRoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    /**
     * 查询指定ID的用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role roleInfo=roleService.findById(id);
        mv.addObject("roleinfo", roleInfo);
        mv.setViewName("role-show");
        return mv;
    }

    /**
     * 添加权限方法
     */
    @RequestMapping("/addPemissionToRole.do")
    public String addPemissionToRole(@RequestParam(name = "roleId", required = true) Integer id,
                                     @RequestParam(name = "ids") String[] permissionIds, HttpServletRequest request) {
        try {
            roleService.addPermissionToRole(id, permissionIds);
            return "redirect:findAll.do";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("Message", "添加角色失败");
            return "role-permission-add";
        }

    }

    /**
     * 根据roleId查询可插入的权限
     *
     * @param id
     * @return
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String id) {
        ModelAndView mv = new ModelAndView();
        Integer roleId = Integer.valueOf(id);
        //根据用户查询Role
        try {
            Role role = roleService.findById(roleId);
            List<Permission> permissionList = roleService.findOtherPermission(roleId);
            mv.addObject("role", role);
            mv.addObject("permissionList", permissionList);
            mv.setViewName("role-permission-add");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //根据RoleId查询可添加的权限资源
        return mv;
    }

    /**
     * 新建角色
     *
     * @param role
     * @return
     */
    @RequestMapping("save.do")
    public String save(Role role, HttpServletRequest request) {
        if (role.getRoleName() != "" && !"".equals(role.getRoleName())
                && role.getRoleDesc() != "" && !"".equals(role.getRoleDesc())) {
            try {
                roleService.save(role);
                return "redirect:findAll.do";
            } catch (Exception e) {
                request.setAttribute("Message", "添加角色失败，请检查角色是否已存在");
                return "role-add";
            }

        } else {
            request.setAttribute("Message", "角色名或角色描述不能为空");
            return "role-add";
        }
    }

    /**
     * 查询所有角色
     *
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        try {
            List<Role> roleList = roleService.findAll();
            mv.addObject("roleList", roleList);
            mv.setViewName("role-list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
