package com.zhelihenku.here.rest.modular.system.dto;

/**
 * SystemMenuTreeRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/11 16:50
 */
public class SystemMenuTreeRequest {

    private Integer menuPid;

    public Integer getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(Integer menuPid) {
        this.menuPid = menuPid;
    }

    @Override
    public String toString() {
        return "SystemMenuTreeRequest{" +
                "menuPid=" + menuPid +
                '}';
    }
}
