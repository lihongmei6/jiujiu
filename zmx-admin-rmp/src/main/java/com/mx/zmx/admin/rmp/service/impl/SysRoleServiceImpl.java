
package com.mx.zmx.admin.rmp.service.impl;

import com.mx.zmx.admin.rmp.mapper.SysRoleMapper;
import com.mx.zmx.admin.rmp.model.SysRole;
import com.mx.zmx.admin.rmp.service.SysRoleService;
import com.mx.zmx.core.service.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class SysRoleServiceImpl extends CommonServiceImpl<SysRole,Long> implements SysRoleService,InitializingBean{
    @Resource
    private SysRoleMapper sysRoleMapper;



    @Override
    public void afterPropertiesSet() {
        super.commonMapper = sysRoleMapper;
    }
}
