package com.zhelihenku.here.rest.modular.system.dto;

/**
 * SystemDepartmentPageListRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/9 19:34
 */
public class SystemRoleDetailRequest {

    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SystemRoleDetailRequest{" +
                "roleId=" + roleId +
                '}';
    }

}
