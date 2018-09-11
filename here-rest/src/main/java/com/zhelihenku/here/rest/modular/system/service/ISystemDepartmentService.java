package com.zhelihenku.here.rest.modular.system.service;

import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.model.SystemDepartment;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author PhilWang
 * @since 2018-09-09
 */
public interface ISystemDepartmentService extends IService<SystemDepartment> {

    Result getSystemDepartmentPageList(SystemDepartmentPageListRequest request);

    SystemDepartmentListModel getSystemDepartmentListModelBySystemDepartmentId(Integer departmentId);

    SystemDepartmentListModel getSystemDepartmentListModelBySystemDepartment(SystemDepartment department);

    Result getSystemDepartmentTreeList();

    SystemDepartmentTreeModel getSystemDepartmentTree(Integer departmentId);

    Result addSystemDepartment(AddSystemDepartmentRequest request);

    Result updateSystemDepartment(AddSystemDepartmentRequest request);

    Result deleteSystemDepartment(DeleteSystemDepartmentRequest request);

    Result getSystemDepartmentDetail(SystemDepartmentDetailRequest request);

}
