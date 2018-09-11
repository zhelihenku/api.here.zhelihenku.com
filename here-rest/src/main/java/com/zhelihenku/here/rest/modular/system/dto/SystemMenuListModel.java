package com.zhelihenku.here.rest.modular.system.dto;

import java.util.Date;

/**
 * SystemMenuListModel
 *
 * @Auther: PhilWang
 * @Date: 2018/9/10 20:08
 */
public class SystemMenuListModel {
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
     * 图标
     */
    private String icon;
    /**
     * url地址
     */
    private String url;
    /**
     * 排序号
     */
    private Integer sort;
    /**
     * 层级
     */
    private Integer levels;
    /**
     * 是否是菜单（0：不是，1：是）
     */
    private Integer isMenu;
    /**
     * 是否打开（0：未打开，1：打开）
     */
    private Integer isOpen;
    /**
     * 备注
     */
    private String desc;
    /**
     * 菜单状态（0：未启用，1：已启用）
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
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
        return "SystemMenuListModel{" +
                "id=" + id +
                ", pid=" + pid +
                ", pids='" + pids + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", sort=" + sort +
                ", levels=" + levels +
                ", isMenu=" + isMenu +
                ", isOpen=" + isOpen +
                ", desc='" + desc + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
