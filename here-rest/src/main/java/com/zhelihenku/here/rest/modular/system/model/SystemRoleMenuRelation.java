package com.zhelihenku.here.rest.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author PhilWang
 * @since 2018-09-09
 */
@TableName("tb_system_role_menu_relation")
public class SystemRoleMenuRelation extends Model<SystemRoleMenuRelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 菜单id
     */
    @TableField("menu_id")
    private Integer menuId;
    /**
     * 角色id
     */
    @TableField("role_id")
    private Integer roleId;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SystemRoleMenuRelation{" +
                "id=" + id +
                ", menuId=" + menuId +
                ", roleId=" + roleId +
                ", createTime=" + createTime +
                '}';
    }
}
