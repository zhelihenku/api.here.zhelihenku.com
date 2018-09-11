package com.zhelihenku.here.rest.modular.system.dto;

import java.util.List;

/**
 * SystemMenuTreeModel
 *
 * @Auther: PhilWang
 * @Date: 2018/9/10 20:11
 */
public class SystemMenuTreeModel {

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

    private List<SystemMenuTreeModel> childMenus;

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

    public List<SystemMenuTreeModel> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<SystemMenuTreeModel> childMenus) {
        this.childMenus = childMenus;
    }

    @Override
    public String toString() {
        return "SystemMenuTreeModel{" +
                "id=" + id +
                ", pid=" + pid +
                ", pids='" + pids + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", childMenus=" + childMenus +
                '}';
    }
}
