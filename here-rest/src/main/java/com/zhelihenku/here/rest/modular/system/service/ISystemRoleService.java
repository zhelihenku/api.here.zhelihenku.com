package com.zhelihenku.here.rest.modular.system.service;

import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.model.SystemRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-31
 */
public interface ISystemRoleService extends IService<SystemRole> {

    Result getSystemRolePageList(SystemRolePageListRequest request);

    Result getSystemRoleAllList();

    List<SystemRoleTreeModel> getSystemRoleAndSubRoleList(Integer roleId);

    Result getSystemRoleTreeList();

    SystemRoleTreeModel getSystemRoleTreeByRoleId(Integer roleId);

    Result addSystemRole(AddSystemRoleRequest request);

    Result updateSystemRole(AddSystemRoleRequest request);

    Result updateSystemRolePermissions(SystemRolePermissionsRequest request);

    Result deleteSystemRole(DeleteSystemRoleRequest request);

    Result getSystemRoleDetail(SystemRoleDetailRequest request);

}
