package com.zhelihenku.here.rest.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhelihenku.here.rest.common.util.CommonConstant;
import com.zhelihenku.here.rest.common.util.RestScrviceExceptionEunm;
import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dao.SystemRoleMapper;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.model.SystemRole;
import com.zhelihenku.here.rest.modular.system.service.ISystemDepartmentService;
import com.zhelihenku.here.rest.modular.system.service.ISystemRoleMenuRelationService;
import com.zhelihenku.here.rest.modular.system.service.ISystemRoleService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-31
 */
@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole> implements ISystemRoleService {

    @Autowired
    private ISystemDepartmentService systemDepartmentService;

    @Autowired
    private ISystemRoleMenuRelationService systemRoleMenuRelationService;

    @Override
    public Result getSystemRolePageList(SystemRolePageListRequest request) {
        Result result = new Result();

        Page page = new Page<>(request.getIndex(), request.getPageSize());
        List<SystemRole> systemRoleList = this.baseMapper.selectPage(page, new EntityWrapper<SystemRole>()
                .eq("is_delete", CommonConstant.DELETE_STATUS_UNDELETE)
                .orderBy("create_time", false));
        List<SystemRoleListModel> listModels = new ArrayList<>();
        for (SystemRole systemRole : systemRoleList) {
            SystemRoleListModel model = this.getSystemRoleListModelBySystemRole(systemRole);
            listModels.add(model);
        }
        page.setRecords(listModels);

        result.setData(page);

        return result;
    }

    public SystemRoleListModel getSystemRoleListModelBySystemRole(SystemRole systemRole) {
        SystemRoleListModel model = new SystemRoleListModel();
        model.setId(systemRole.getId());
        model.setPid(systemRole.getPid());
        model.setName(systemRole.getName());
        model.setDesc(systemRole.getDesc());
        model.setStatus(systemRole.getStatus());
        model.setCreateTime(systemRole.getCreateTime());

        List<SystemRole> tempSyetemRoleList = new ArrayList<>();
        tempSyetemRoleList.add(systemRole);

        List<SystemRole> parentSystemRoleList= this.getParentSystemRole(systemRole.getPid(), tempSyetemRoleList);
        List<String> pids = new ArrayList<>();
        List<String> pNames = new ArrayList<>();
        for (SystemRole SystemRole : parentSystemRoleList) {
            pids.add(0, String.valueOf(SystemRole.getId()));
            pNames.add(0, SystemRole.getName());
        }
        model.setPids(String.join(",", pids));
        model.setFullName(String.join("-", pNames));

        SystemDepartmentListModel systemDepartmentListModel = systemDepartmentService.getSystemDepartmentListModelBySystemDepartmentId(systemRole.getDepartmentId());
        model.setDepartmentId(systemRole.getDepartmentId());
        model.setDepartmentIds(systemDepartmentListModel.getPids());
        model.setDepartmentName(systemDepartmentListModel.getName());
        model.setDepartmentFullName(systemDepartmentListModel.getFullName());

        return model;
    }

    public List<SystemRole> getParentSystemRole(Integer pid, List<SystemRole> SystemRoles) {

        if (pid == 0) {
            return SystemRoles;
        } else {
            SystemRole SystemRole = this.baseMapper.selectById(pid);
            if (null != SystemRole) {
                SystemRoles.add(SystemRole);
                if (SystemRole.getPid() != 0) {
                    this.getParentSystemRole(SystemRole.getPid(), SystemRoles);
                }
            }
        }

        return SystemRoles;
    }

    @Override
    public Result getSystemRoleAllList() {
        Result result = new Result();

        List<SystemRole> systemRoleList = this.getSystemRoleAlls();
        result.setData(systemRoleList);

        return result;
    }

    public List<SystemRole> getSystemRoleAlls() {

        List<SystemRole> systemRoleList = this.baseMapper.selectList(new EntityWrapper<SystemRole>()
                .eq("is_delete", CommonConstant.DELETE_STATUS_UNDELETE)
                .orderBy("create_time", false));

        return systemRoleList;
    }

    @Override
    public List<SystemRoleTreeModel> getSystemRoleAndSubRoleList(Integer roleId) {

        SystemRoleTreeModel systemRoleTreeModel = this.getSystemRoleTreeByRoleId(roleId);
        List<SystemRoleTreeModel> systemRoleTreeList = this.getChildRoleTreeList(systemRoleTreeModel);
        systemRoleTreeList.add(0, systemRoleTreeModel);

        return systemRoleTreeList;
    }

    private List<SystemRoleTreeModel> getChildRoleTreeList(SystemRoleTreeModel systemRoleTreeModel) {

        // 子菜单
        List<SystemRoleTreeModel> systemRoleTreeList = new ArrayList<>();

        // 为一级菜单设置子菜单，getChild是递归调用的
        System.out.println(systemRoleTreeModel.getChildRoles());
        for (SystemRoleTreeModel treeModel : systemRoleTreeModel.getChildRoles()) {
            List<SystemRoleTreeModel> childRoleTreeList = getChildRoleTreeList(treeModel);
            systemRoleTreeList.addAll(childRoleTreeList);
        }

        return systemRoleTreeList;
    }

    @Override
    public Result getSystemRoleTreeList() {
        Result result = new Result();

        List<SystemRole> systemRoleList = this.getSystemRoleAlls();

        // 最后的结果
        List<SystemRoleTreeModel> systemRoleTreeList = new ArrayList<>();

        List<SystemRole> tempSystemRoleList = new ArrayList<>();

        // 先找到所有的一级菜单
        for (SystemRole SystemRole : systemRoleList) {
            // 一级菜单没有parentId
            if (SystemRole.getPid() == 0) {
                SystemRoleTreeModel systemRoleTreeModel = new SystemRoleTreeModel();
                systemRoleTreeModel.setId(SystemRole.getId());
                systemRoleTreeModel.setPid(SystemRole.getPid());
                systemRoleTreeModel.setName(SystemRole.getName());

                systemRoleTreeList.add(systemRoleTreeModel);
            } else {
                tempSystemRoleList.add(SystemRole);
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SystemRoleTreeModel systemRoleTreeModel : systemRoleTreeList) {
            Map<String,Object> data = getChildRole(systemRoleTreeModel.getId(), tempSystemRoleList);
            if (null != data) {
                systemRoleTreeModel.setChildRoles((List<SystemRoleTreeModel>) data.get("childList"));
                tempSystemRoleList = (List<SystemRole>) data.get("oldList");
            }
        }

        result.setData(systemRoleTreeList);

        return result;
    }

    @Override
    public SystemRoleTreeModel getSystemRoleTreeByRoleId(Integer roleId) {
        SystemRoleTreeModel systemRoleTreeModel = new SystemRoleTreeModel();

        List<SystemRole> systemRoleList = this.getSystemRoleAlls();

        SystemRole systemRole = this.baseMapper.selectById(roleId);
        if (null != systemRole) {
            systemRoleTreeModel.setId(systemRole.getId());
            systemRoleTreeModel.setPid(systemRole.getPid());
            systemRoleTreeModel.setName(systemRole.getName());

            Map<String,Object> data = getChildRole(systemRoleTreeModel.getId(), systemRoleList);
            if (null != data) {
                systemRoleTreeModel.setChildRoles((List<SystemRoleTreeModel>) data.get("childList"));
            }
        }

        return systemRoleTreeModel;
    }


    private Map<String,Object> getChildRole(Integer id, List<SystemRole> roleList) {

        List<SystemRole> tempSystemRoleList = new ArrayList<>();
        List<Integer> tempIds = new ArrayList<>();

        // 子菜单
        List<SystemRoleTreeModel> childList = new ArrayList<>();
        for (SystemRole SystemRole : roleList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(String.valueOf(SystemRole.getPid()))) {
                if (SystemRole.getPid().equals(id)) {
                    SystemRoleTreeModel systemRoleTreeModel = new SystemRoleTreeModel();
                    systemRoleTreeModel.setId(SystemRole.getId());
                    systemRoleTreeModel.setPid(SystemRole.getPid());
                    systemRoleTreeModel.setName(SystemRole.getName());
                    childList.add(systemRoleTreeModel);
                } else {
                    tempSystemRoleList.add(SystemRole);
                    tempIds.add(SystemRole.getId());
                }
            }
        }

        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SystemRoleTreeModel systemRoleTreeModel : childList) {
            Map<String,Object> data = getChildRole(systemRoleTreeModel.getId(), tempSystemRoleList);
            if (null != data) {
                systemRoleTreeModel.setChildRoles((List<SystemRoleTreeModel>) data.get("childList"));
                tempSystemRoleList = (List<SystemRole>) data.get("oldList");
            }
        }

        Map<String,Object> data = new HashMap<>();
        data.put("childList", childList);
        data.put("oldList", tempSystemRoleList);

        return data;
    }

    @Override
    public Result addSystemRole(AddSystemRoleRequest request) {
        Result result = new Result();

        if (StringUtils.isEmpty(request.getName())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_ROLE_NAME);
        } else if (StringUtils.isEmpty(String.valueOf(request.getPid()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_ROLE_PID);
        } else if (StringUtils.isEmpty(String.valueOf(request.getDepartmentId()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_ROLE_DEPARTMENT_ID);
        }

        SystemRole systemRole = new SystemRole();
        systemRole.setPid(request.getPid());
        systemRole.setName(request.getName());
        systemRole.setDepartmentId(request.getDepartmentId());
        systemRole.setDesc(request.getDesc());

        this.baseMapper.insert(systemRole);

        return result;
    }

    @Override
    public Result updateSystemRole(AddSystemRoleRequest request) {
        Result result = new Result();

        if (StringUtils.isEmpty(String.valueOf(request.getId()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_ROLE_ID);
        } else if (StringUtils.isEmpty(request.getName())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_ROLE_NAME);
        } else if (StringUtils.isEmpty(String.valueOf(request.getPid()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_ROLE_PID);
        } else if (StringUtils.isEmpty(String.valueOf(request.getDepartmentId()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_ROLE_DEPARTMENT_ID);
        }

        SystemRole systemRole = new SystemRole();
        systemRole.setId(request.getId());
        systemRole.setPid(request.getPid());
        systemRole.setName(request.getName());
        systemRole.setDepartmentId(request.getDepartmentId());
        systemRole.setDesc(request.getDesc());

        this.baseMapper.updateById(systemRole);

        return result;
    }

    @Override
    public Result updateSystemRolePermissions(SystemRolePermissionsRequest request) {
        Result result = new Result();

        if (StringUtils.isEmpty(String.valueOf(request.getRoleId()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_ROLE_ID);
        }

        systemRoleMenuRelationService.delectRoleMenuRelationByRoleId(request.getRoleId());

        if (request.getMenuIds().size() > 0) {
            systemRoleMenuRelationService.addRoleMenuRelation(request.getRoleId(), request.getMenuIds());
        }

        return result;
    }

    @Override
    public Result deleteSystemRole(DeleteSystemRoleRequest request) {
        Result result = new Result();

        Map<String, Object> params = new HashedMap();
        params.put("ids", request.getIds());
        this.baseMapper.deleteSystemRoleByIds(params);

        return result;
    }

    @Override
    public Result getSystemRoleDetail(SystemRoleDetailRequest request) {
        Result result = new Result();

        SystemRole systemRole = this.baseMapper.selectById(request.getRoleId());
        result.setData(systemRole);

        return result;
    }
}
