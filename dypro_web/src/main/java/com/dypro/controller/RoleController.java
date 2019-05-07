package com.dypro.controller;

import com.dypro.domain.Permission;
import com.dypro.domain.Role;
import com.dypro.service.IRoleService;
import com.github.pagehelper.PageInfo;
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
     * 根据用户id删除用户
     *
     * @param roleid
     * @return
     */
    @RequestMapping("/delRoleById.do")
    public String delRoleById(@RequestParam(name = "id") Integer roleid,HttpServletRequest request) {
        try {
            Role roleInfo = roleService.findById(roleid);
            if (roleInfo.getRoleName().equals("ADMIN")||roleInfo.getRoleName().equals("USER")){
                //request.setAttribute("Message","");
                return "redirect:findAll.do?Message=1";
            }
            if (roleInfo.getPermissions() != null && roleInfo.getPermissions().size() > 0) {
                roleService.delRoleToPermission(roleid);
            }
            try {
                roleService.delRoleById(roleid);
            } catch (Exception e) {
                return "redirect:findAll.do?Message=2";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:findAll.do";
    }
    /**
     * 根据角色ID删除用户所绑定角色
     *
     * @param
     * @param permissionIds
     * @param request
     * @return
     */
    @RequestMapping("/removePermissonToRole.do")
    public String removePermissonToRole(@RequestParam(name = "roleId") Integer roleId, @RequestParam(name = "ids") String[] permissionIds, HttpServletRequest request) {
        try {
            roleService.removePermissionToRole(roleId, permissionIds);
            request.setAttribute("Message", "移除权限成功");
            return "redirect:findRoleByIdToPermission.do?id=" + roleId;
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("Message", "移除权限失败");
            return "role/role-permission-remove";
        }
    }
    /**
     * 展示角色所拥有权限信息
     *
     * @param
     * @return
     */
    @RequestMapping("/findRoleByIdToPermission.do")
    public ModelAndView findRoleByIdToPermission(@RequestParam(name = "id", required = true) Integer roleId) {
        ModelAndView mv = new ModelAndView();
        //根据角色ID查询角色
        try {
            Role roleInfo = roleService.findById(roleId);
            mv.addObject("role", roleInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("role/role-permission-remove");
        return mv;
    }

    /**
     * 更新角色
     * @param role
     * @param request
     * @return
     */
    @RequestMapping("/roleUpdate.do")
    public String roleUpdate (Role role,HttpServletRequest request){
        if (role.getRoleName() == null || role.getRoleName().equals("")) {
            request.setAttribute("Message", "角色名不能为空");
            return "role/role-update";
        }
        if (role.getRoleDesc() == null || role.getRoleDesc().equals("")) {
            request.setAttribute("Message", "角色描述不能为空");
            return "role/role-update";
        }
        try {
            roleService.roleUpdate(role);
            request.setAttribute("Message", "修改角色成功");
            return "redirect:findAll.do";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("Message", "修改角色失败");
            return "role/role-update";
        }
    }
    /**
     * 执行更新页面跳转
     * @param
     * @return
     */
    @RequestMapping("/beforeRoleUpdate.do")
    public ModelAndView beforeRoleUpdate(@RequestParam(name = "id",required = true) Integer roleId) throws Exception {
        ModelAndView mv=new ModelAndView();
        //判断是否为user和admin用户
        Role role = roleService.findById(roleId);
        if (role.getRoleName().equals("ADMIN")||role.getRoleName().equals("USER")){
            mv.addObject("Message","ADMIN用户或USER用户无法被修改");
            mv.setViewName("role/role-list");
            return mv;
        }
        else {mv.addObject("role",role);
        mv.setViewName("role/role-update");
        return mv;}
    }
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
        mv.setViewName("role/role-show");
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
            return "role/role-permission-add";
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
            mv.setViewName("role/role-permission-add");
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
                return "role/role-add";
            }

        } else {
            request.setAttribute("Message", "角色名或角色描述不能为空");
            return "role/role-add";
        }
    }

    /**
     * 查询所有角色
     *
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5") int size) {
        ModelAndView mv = new ModelAndView();
        try {
            List<Role> roleList = roleService.findAll(page,size);
            PageInfo pageInfo=new PageInfo(roleList);
            mv.addObject("pageInfo",pageInfo);
           // mv.addObject("roleList", roleList);
            mv.setViewName("role/role-list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
