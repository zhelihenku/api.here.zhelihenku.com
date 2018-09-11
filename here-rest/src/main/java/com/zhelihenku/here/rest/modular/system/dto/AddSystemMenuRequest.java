package com.zhelihenku.here.rest.modular.system.dto;

/**
 * AddSystemMenuRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/9 20:43
 */
public class AddSystemMenuRequest {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 菜单父ID
     */
    private Integer pid;
    /**
     * 名称
     */
    private String name;
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
     * 备注
     */
    private String desc;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "AddSystemMenuRequest{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", sort=" + sort +
                ", levels=" + levels +
                ", isMenu=" + isMenu +
                ", desc='" + desc + '\'' +
                '}';
    }
}
