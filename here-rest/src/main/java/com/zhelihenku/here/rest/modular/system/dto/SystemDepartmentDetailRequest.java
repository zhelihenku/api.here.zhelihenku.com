package com.zhelihenku.here.rest.modular.system.dto;

/**
 * SystemDepartmentPageListRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/9 19:34
 */
public class SystemDepartmentDetailRequest {

    private Integer departmentId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "SystemDepartmentDetailRequest{" +
                "departmentId=" + departmentId +
                '}';
    }
}
