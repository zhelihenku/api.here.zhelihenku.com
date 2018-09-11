package com.zhelihenku.here.rest.modular.system.dto;

import java.util.List;

/**
 * SystemUserInfoResponse
 *
 * @Auther: PhilWang
 * @Date: 2018/9/4 17:10
 */
public class SystemUserInfoResponse {

    private String avatar;

    private String name;

    private List<String> menus;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMenus() {
        return menus;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "SystemUserInfoResponse{" +
                "avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", menus=" + menus +
                '}';
    }
}
