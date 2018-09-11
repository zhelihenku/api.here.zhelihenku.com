package com.zhelihenku.here.rest.modular.system.dto;

/**
 * SystemMenuDetailRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/9 20:43
 */
public class SystemMenuDetailRequest {

    private Integer menuId;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "SystemMenuDetailRequest{" +
                "menuId=" + menuId +
                '}';
    }
}
