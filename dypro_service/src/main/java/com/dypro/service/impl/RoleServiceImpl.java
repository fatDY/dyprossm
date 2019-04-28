package com.dypro.service.impl;

import com.dypro.dao.IRoleDao;
import com.dypro.domain.Permission;
import com.dypro.domain.Role;
import com.dypro.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer roleId) throws Exception {
        return roleDao.findByID(roleId);
    }

    @Override
    public List<Permission> findOtherPermission(Integer roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(Integer id, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(id,permissionId);
        }
    }

    @Override
    public void roleUpdate(Role role) throws Exception {
        Integer id=role.getId();
        String roleName=role.getRoleName();
        String roleDesc=role.getRoleDesc();
        roleDao.roleUpdate(id,roleName,roleDesc);
    }

    @Override
    public void removePermissionToRole(Integer roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.removePermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public void delRoleToPermission(Integer roleid) {
        roleDao.delRoleToPermisson(roleid);
    }

    @Override
    public void delRoleById(Integer roleid) {
        roleDao.delRoleById(roleid);
    }
}
