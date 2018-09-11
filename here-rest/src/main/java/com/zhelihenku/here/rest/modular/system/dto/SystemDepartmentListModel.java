package com.zhelihenku.here.rest.modular.system.dto;

import java.util.Date;

/**
 * SystemDepartmentListModel
 *
 * @Auther: PhilWang
 * @Date: 2018/9/10 13:10
 */
public class SystemDepartmentListModel {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 父部门ID
     */
    private Integer pid;
    /**
     * 父部门IDS
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
        return "SystemDepartmentListModel{" +
                "id=" + id +
                ", pid=" + pid +
                ", pids=" + pids + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", desc='" + desc + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
