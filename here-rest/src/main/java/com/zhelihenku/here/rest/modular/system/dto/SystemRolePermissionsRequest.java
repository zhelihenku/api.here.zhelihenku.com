package com.zhelihenku.here.rest.modular.system.dto;

import java.util.List;

/**
 * SystemRolePermissionsRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/11 21:54
 */
public class SystemRolePermissionsRequest {

    private Integer roleId;

    private List<Integer> menuIds;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "SystemRolePermissionsRequest{" +
                "roleId=" + roleId +
                ", menuIds=" + menuIds +
                '}';
    }
}
