package com.zhelihenku.here.rest.modular.system.dto;

import java.util.Date;

/**
 * SystemRoleListModel
 *
 * @Auther: PhilWang
 * @Date: 2018/9/10 13:44
 */
public class SystemRoleListModel {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 父ID
     */
    private Integer pid;
    /**
     * 父IDS
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
     * 部门IDS
     */
    private String departmentIds;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门全称
     */
    private String departmentFullName;
    /**
     * 提示
     */
    private String desc;
    /**
     * 状态（0：不可用，1：可用）
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;

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

    public String getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(String departmentIds) {
        this.departmentIds = departmentIds;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentFullName() {
        return departmentFullName;
    }

    public void setDepartmentFullName(String departmentFullName) {
        this.departmentFullName = departmentFullName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SystemRoleListModel{" +
                "id=" + id +
                ", pid=" + pid +
                ", pids='" + pids + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", departmentId=" + departmentId +
                ", departmentIds=" + departmentIds +
                ", departmentName='" + departmentName + '\'' +
                ", departmentFullName='" + departmentFullName + '\'' +
                ", desc='" + desc + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
