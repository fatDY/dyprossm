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
}
