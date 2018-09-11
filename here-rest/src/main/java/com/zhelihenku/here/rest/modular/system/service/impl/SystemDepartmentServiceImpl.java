package com.zhelihenku.here.rest.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhelihenku.here.rest.common.util.CommonConstant;
import com.zhelihenku.here.rest.common.util.RestScrviceExceptionEunm;
import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dao.SystemDepartmentMapper;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.model.SystemDepartment;
import com.zhelihenku.here.rest.modular.system.service.ISystemDepartmentService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author PhilWang
 * @since 2018-09-09
 */
@Service
public class SystemDepartmentServiceImpl extends ServiceImpl<SystemDepartmentMapper, SystemDepartment> implements ISystemDepartmentService {

    @Override
    public Result getSystemDepartmentPageList(SystemDepartmentPageListRequest request) {
        Result result = new Result();

        Page page = new Page<>(request.getIndex(), request.getPageSize());
        List<SystemDepartment> systemDepartmentList = this.baseMapper.selectPage(page, new EntityWrapper<SystemDepartment>()
                .eq("is_delete", CommonConstant.DELETE_STATUS_UNDELETE)
                .orderBy("create_time", false));

        List<SystemDepartmentListModel> listModels = new ArrayList<>();
        for (SystemDepartment department : systemDepartmentList) {
            SystemDepartmentListModel model = this.getSystemDepartmentListModelBySystemDepartment(department);
            listModels.add(model);
        }

        page.setRecords(listModels);
        result.setData(page);

        return result;
    }

    @Override
    public SystemDepartmentListModel getSystemDepartmentListModelBySystemDepartmentId(Integer departmentId) {
        SystemDepartment systemDepartment = this.baseMapper.selectById(departmentId);
        SystemDepartmentListModel model = this.getSystemDepartmentListModelBySystemDepartment(systemDepartment);

        return model;
    }

    @Override
    public SystemDepartmentListModel getSystemDepartmentListModelBySystemDepartment(SystemDepartment department) {
        SystemDepartmentListModel model = new SystemDepartmentListModel();
        model.setId(department.getId());
        model.setPid(department.getPid());
        model.setName(department.getName());
        model.setDesc(department.getDesc());
        model.setStatus(department.getStatus());
        model.setCreateTime(department.getCreateTime());

        List<SystemDepartment> tempSyetemDepartmentList = new ArrayList<>();
        tempSyetemDepartmentList.add(department);
        List<SystemDepartment> parentSystemDepartmentList= this.getParentSystemDepartment(department.getPid(), tempSyetemDepartmentList);

        List<String> pids = new ArrayList<>();
        List<String> pNames = new ArrayList<>();
        for (SystemDepartment systemDepartment : parentSystemDepartmentList) {
            pids.add(0, String.valueOf(systemDepartment.getId()));
            pNames.add(0, systemDepartment.getName());
        }
        model.setPids(String.join(",", pids));
        model.setFullName(String.join("-", pNames));

        return model;
    }

    public List<SystemDepartment> getParentSystemDepartment(Integer pid, List<SystemDepartment> systemDepartments) {

        if (pid == 0) {
            return systemDepartments;
        } else {
            SystemDepartment systemDepartment = this.baseMapper.selectById(pid);
            if (null != systemDepartment) {
                systemDepartments.add(systemDepartment);
                if (systemDepartment.getPid() != 0) {
                    this.getParentSystemDepartment(systemDepartment.getPid(), systemDepartments);
                }
            }
        }

        return systemDepartments;
    }

    public List<SystemDepartment> getSystemDepartmentAlls() {

        List<SystemDepartment> systemDepartmentList = this.baseMapper.selectList(new EntityWrapper<SystemDepartment>()
                .eq("is_delete", CommonConstant.DELETE_STATUS_UNDELETE)
                .orderBy("create_time", true));

        return systemDepartmentList;
    }

    @Override
    public Result getSystemDepartmentTreeList() {
        Result result = new Result();

        List<SystemDepartment> systemDepartmentList = this.getSystemDepartmentAlls();

        // 最后的结果
        List<SystemDepartmentTreeModel> systemDepartmentTreeList = new ArrayList<>();

        List<SystemDepartment> tempSystemDepartmentList = new ArrayList<>();

        // 先找到所有的一级菜单
        for (SystemDepartment systemDepartment : systemDepartmentList) {
            // 一级菜单没有parentId
            if (systemDepartment.getPid() == 0) {
                SystemDepartmentTreeModel systemDepartmentTreeModel = new SystemDepartmentTreeModel();
                systemDepartmentTreeModel.setId(systemDepartment.getId());
                systemDepartmentTreeModel.setPid(systemDepartment.getPid());
                systemDepartmentTreeModel.setName(systemDepartment.getName());
                systemDepartmentTreeList.add(systemDepartmentTreeModel);
            } else {
                tempSystemDepartmentList.add(systemDepartment);
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SystemDepartmentTreeModel systemDepartmentTreeModel : systemDepartmentTreeList) {
            Map<String,Object> data = getChildDepartment(systemDepartmentTreeModel.getId(), tempSystemDepartmentList);
            if (null != data) {
                systemDepartmentTreeModel.setChildDepartments((List<SystemDepartmentTreeModel>) data.get("childList"));
                tempSystemDepartmentList = (List<SystemDepartment>) data.get("oldList");
            }
        }

        result.setData(systemDepartmentTreeList);

        return result;
    }

    @Override
    public SystemDepartmentTreeModel getSystemDepartmentTree(Integer departmentId) {
        SystemDepartmentTreeModel systemDepartmentTreeModel = new SystemDepartmentTreeModel();

        List<SystemDepartment> systemDepartmentList = this.getSystemDepartmentAlls();

        SystemDepartment systemDepartment = this.baseMapper.selectById(departmentId);
        if (null != systemDepartment) {
            systemDepartmentTreeModel.setId(systemDepartment.getId());
            systemDepartmentTreeModel.setPid(systemDepartment.getPid());
            systemDepartmentTreeModel.setName(systemDepartment.getName());

            Map<String,Object> data = getChildDepartment(systemDepartmentTreeModel.getId(), systemDepartmentList);
            if (null != data) {
                systemDepartmentTreeModel.setChildDepartments((List<SystemDepartmentTreeModel>) data.get("childList"));
            }
        }

        return systemDepartmentTreeModel;
    }
    
    private Map<String,Object> getChildDepartment(Integer id, List<SystemDepartment> deptList) {

        List<SystemDepartment> tempSystemDepartmentList = new ArrayList<>();
        List<Integer> tempIds = new ArrayList<>();

        // 子菜单
        List<SystemDepartmentTreeModel> childList = new ArrayList<>();
        for (SystemDepartment systemDepartment : deptList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(String.valueOf(systemDepartment.getPid()))) {
                if (systemDepartment.getPid().equals(id)) {
                    SystemDepartmentTreeModel systemDepartmentTreeModel = new SystemDepartmentTreeModel();
                    systemDepartmentTreeModel.setId(systemDepartment.getId());
                    systemDepartmentTreeModel.setPid(systemDepartment.getPid());
                    systemDepartmentTreeModel.setName(systemDepartment.getName());
                    childList.add(systemDepartmentTreeModel);
                } else {
                    tempSystemDepartmentList.add(systemDepartment);
                    tempIds.add(systemDepartment.getId());
                }
            }
        }

        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SystemDepartmentTreeModel systemDepartmentTreeModel : childList) {
            Map<String,Object> data = getChildDepartment(systemDepartmentTreeModel.getId(), tempSystemDepartmentList);
            if (null != data) {
                systemDepartmentTreeModel.setChildDepartments((List<SystemDepartmentTreeModel>) data.get("childList"));
                tempSystemDepartmentList = (List<SystemDepartment>) data.get("oldList");
            }
        }

        if (childList.size() == 0) {
            return null;
        }

        Map<String,Object> data = new HashMap<>();
        data.put("childList", childList);
        data.put("oldList", tempSystemDepartmentList);

        return data;
    }

    @Override
    public Result addSystemDepartment(AddSystemDepartmentRequest request) {
        Result result = new Result();

        if (StringUtils.isEmpty(String.valueOf(request.getName()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_DEPARTMENT_NAME);
        } else if (StringUtils.isEmpty(String.valueOf(request.getPid()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_DEPARTMENT_PID);
        }

        SystemDepartment systemDepartment = new SystemDepartment();
        systemDepartment.setPid(request.getPid());
        systemDepartment.setName(request.getName());
        systemDepartment.setDesc(request.getDesc());

        baseMapper.insert(systemDepartment);

        return result;
    }

    @Override
    public Result updateSystemDepartment(AddSystemDepartmentRequest request) {
        Result result = new Result();

        if (StringUtils.isEmpty(String.valueOf(request.getId()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_DEPARTMENT_ID);
        } else if (StringUtils.isEmpty(request.getName())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_DEPARTMENT_NAME);
        } else if (StringUtils.isEmpty(String.valueOf(request.getPid()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_DEPARTMENT_PID);
        }

        SystemDepartment systemDepartment = new SystemDepartment();
        systemDepartment.setId(request.getId());
        systemDepartment.setPid(request.getPid());
        systemDepartment.setName(request.getName());
        systemDepartment.setDesc(request.getDesc());

        baseMapper.updateById(systemDepartment);

        return result;
    }

    @Override
    public Result deleteSystemDepartment(DeleteSystemDepartmentRequest request) {
        Result result = new Result();


        Map<String, Object> params = new HashedMap();
        params.put("ids", request.getIds());
        this.baseMapper.deleteSystemDepartmentByIds(params);

        return result;
    }

    @Override
    public Result getSystemDepartmentDetail(SystemDepartmentDetailRequest request) {
        Result result = new Result();

        SystemDepartment systemDepartment = this.baseMapper.selectById(request.getDepartmentId());
        result.setData(systemDepartment);

        return result;
    }
}
