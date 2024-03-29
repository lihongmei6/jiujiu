package com.mx.zmx.admin.rmp.common.controller.admin.sys;

import com.mx.zmx.admin.rmp.model.SysRoleModulePermission;
import com.mx.zmx.admin.rmp.service.SysRoleModulePermissionService;
import com.mx.zmx.core.common.constant.PageConstant;
import com.mx.zmx.core.serialize.ResponseMsg;
import com.mx.zmx.core.service.CommonRestController;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;




@RequestMapping("/admin/sys_role_module_permission_rest/")
@RestController
public class AdminSysRoleModulePermissionRestController extends CommonRestController<SysRoleModulePermission,Long> implements InitializingBean
{

    @Resource
    private SysRoleModulePermissionService sysRoleModulePermissionService;
    //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="roleIdFirst")                            Long roleIdFirst ,
        @RequestParam(required = false,value ="moduleIdFirst")                            Long moduleIdFirst ,
        @RequestParam(required = false,value ="permissionIdFirst")                            Long permissionIdFirst ,
        @RequestParam int page,@RequestParam int limit,@RequestParam(required = false) String safeOrderBy)
    {
        limit = Math.min(limit, PageConstant.MAX_LIMIT);
        int start = (page - 1) * limit;
        Map<String,Object> query = new HashMap();
        query.put("roleIdFirst",roleIdFirst);
        query.put("moduleIdFirst",moduleIdFirst);
        query.put("permissionIdFirst",permissionIdFirst);
        Integer count = sysRoleModulePermissionService.getModelListCount(query);
        query.put("start",start);
        query.put("limit",limit);
        query.put("safeOrderBy",safeOrderBy);
        return new ResponseMsg(count,sysRoleModulePermissionService.getModelList(query));
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        super.commonService = sysRoleModulePermissionService;
        super.primaryKey = "id";//硬编码此实体的主键名称
    }
}
