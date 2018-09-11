package com.zhelihenku.here.rest.modular.system.dto;

import java.util.List;

/**
 * SystemRoleTreeModel
 *
 * @Auther: PhilWang
 * @Date: 2018/9/10 11:26
 */
public class SystemRoleTreeModel {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 父角色ID
     */
    private Integer pid;
    /**
     * 父角色IDS
     */
    private String pids;
    /**
     * 名称
     */
    private String name;
    /**
     * 全称
     */
    private String fullName;
    /**
     * 部门ID
     */
    private Integer departmentId;
    /**
     * 描述
     */
    private String desc;

    private List<SystemRoleTreeModel> childRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<SystemRoleTreeModel> getChildRoles() {
        return childRoles;
    }

    public void setChildRoles(List<SystemRoleTreeModel> childRoles) {
        this.childRoles = childRoles;
    }

    @Override
    public String toString() {
        return "SystemRoleTreeModel{" +
                "id=" + id +
                ", pid=" + pid +
                ", pids='" + pids + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", departmentId=" + departmentId +
                ", desc='" + desc + '\'' +
                ", childRoles=" + childRoles +
                '}';
    }
}
