package com.zhelihenku.here.rest.modular.system.dto;

/**
 * SystemRouterMetaModel
 *
 * @Auther: PhilWang
 * @Date: 2018/9/10 21:06
 */
public class SystemRouterMetaModel {

    private String title;

    private String icon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "SystemRouterMetaModel{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
