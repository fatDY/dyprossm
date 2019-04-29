package com.dypro.controller;

import com.dypro.domain.Permission;
import com.dypro.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("/delPermissionById.do")
    public String delPermissionById(@RequestParam(name = "id") Integer permissionId){
        try {
            Permission permissionInfo = permissionService.findById(permissionId);
            if (permissionInfo.getUrl()  == null || permissionInfo.getUrl().equals("")){
                //request.setAttribute("Message","");
                return "redirect:findAll.do?Message=1";
            }
            //查询是否有用户使用该资源权限
              if (permissionService.findUsedRoleById(permissionId)){
                return "redirect:findAll.do?Message=2";
              }
              else {
                  permissionService.delPermissionById(permissionId);
                  return "redirect:findAll.do?Message=success";
              }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:findAll.do";
    }
    /**
     * 根据Perssion类更新
     * @param permission
     * @param request
     * @return
     */
    @RequestMapping("/permissionUpdate.do")
    public String roleUpdate (Permission permission,HttpServletRequest request){
        if (permission.getPermissionName() == null ||permission.getPermissionName() .equals("")) {
            request.setAttribute("Message", "权限名不能为空");
            return "permission-update";
        }
        if (permission.getUrl()  == null || permission.getUrl().equals("")) {
            request.setAttribute("Message", "权限路径不能为空");
            return "permission-update";
        }
        try {
            permissionService.permissionUpdate(permission);
         //   request.setAttribute("Message", "修改角色成功");
            return "redirect:findAll.do";
        } catch (Exception e) {
            e.printStackTrace();
            //request.setAttribute("Message", "修改权限失败");
            return "redirect:findAll.do";
        }
    }

    /**
     * 查询所有资源信息返回更新页面
     * @param permissionId
     * @return
     * @throws Exception
     */
    @RequestMapping("/beforePermissionUpdate.do")
    public ModelAndView beforePermissionUpdate(@RequestParam(name = "id",required = true) Integer permissionId) throws Exception {
        ModelAndView mv=new ModelAndView();
        //判断是否为user和admin用户
        Permission permission = permissionService.findById(permissionId);
            mv.addObject("permission",permission);
            mv.setViewName("permission-update");
            return mv;
    }

    /**
     * 查询所有资源
     * @return
     */
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

    /**
     * 用户保存
     * @param permission
     * @param request
     * @return
     */
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
