package com.dypro.service.impl;

import com.dypro.dao.IPermissionDao;
import com.dypro.domain.Permission;
import com.dypro.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 权限管理业务操作
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return  permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public Permission findById(Integer permissionId) {
        return permissionDao.findById(permissionId);
    }

    @Override
    public void permissionUpdate(Permission permission) {
        permissionDao.permissionUpdate(permission);
    }

    @Override
    public boolean findUsedRoleById(Integer permissionId) throws Exception {
        boolean flag=false;
       List<String> list= permissionDao.findUsedRoleById(permissionId);
       if (list.size()!=0){
           flag=true;
       }
        return flag;
    }

    @Override
    public void delPermissionById(Integer permissionId) throws Exception {
        permissionDao.delPermissionById(permissionId);
    }
}
