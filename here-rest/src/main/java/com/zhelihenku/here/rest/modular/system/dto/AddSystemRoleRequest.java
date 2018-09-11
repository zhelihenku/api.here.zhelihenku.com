package com.zhelihenku.here.rest.modular.system.dto;

/**
 * SystemDepartmentPageListRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/9 19:34
 */
public class AddSystemRoleRequest {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 父角色ID
     */
    private Integer pid;
    /**
     * 名称
     */
    private String name;
    /**
     * 部门ID
     */
    private Integer departmentId;
    /**
     * 描述
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "AddSystemRoleRequest{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                ", desc='" + desc + '\'' +
                '}';
    }
}
