package com.zhelihenku.here.rest.modular.system.dto;

import java.util.List;

/**
 * SystemRouterModel
 *
 * @Auther: PhilWang
 * @Date: 2018/9/10 21:05
 */
public class SystemRouterModel {

    private Integer id;

    private Integer pid;

    private String path;

    private String component;

    private String name;

    private String redirect;

    private SystemRouterMetaModel meta;

    private List<SystemRouterModel> children;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public SystemRouterMetaModel getMeta() {
        return meta;
    }

    public void setMeta(SystemRouterMetaModel meta) {
        this.meta = meta;
    }

    public List<SystemRouterModel> getChildren() {
        return children;
    }

    public void setChildren(List<SystemRouterModel> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SystemRouterModel{" +
                "id=" + id +
                ", pid=" + pid +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", name='" + name + '\'' +
                ", redirect='" + redirect + '\'' +
                ", meta=" + meta +
                ", children=" + children +
                '}';
    }
}
