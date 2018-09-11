package com.zhelihenku.here.rest.modular.system.dto;

import java.util.List;

/**
 * SystemDepartmentTreeModel
 *
 * @Auther: PhilWang
 * @Date: 2018/9/9 22:48
 */
public class SystemDepartmentTreeModel {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 父部门id
     */
    private Integer pid;
    /**
     * 父级ids
     */
    private String pids;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 全称
     */
    private String fullName;

    private List<SystemDepartmentTreeModel> childDepartments;

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

    public List<SystemDepartmentTreeModel> getChildDepartments() {
        return childDepartments;
    }

    public void setChildDepartments(List<SystemDepartmentTreeModel> childDepartments) {
        this.childDepartments = childDepartments;
    }

    @Override
    public String toString() {
        return "SystemDepartmentTreeModel{" +
                "id=" + id +
                ", pid=" + pid +
                ", pids='" + pids + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", childDepartments=" + childDepartments +
                '}';
    }
}
