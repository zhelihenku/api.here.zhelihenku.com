package com.zhelihenku.here.rest.modular.system.service;

import com.zhelihenku.here.rest.modular.system.model.SystemRoleMenuRelation;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 服务类
 * </p>
 *
 * @author PhilWang
 * @since 2018-09-09
 */
public interface ISystemRoleMenuRelationService extends IService<SystemRoleMenuRelation> {

    void delectRoleMenuRelationByRoleId(Integer roleId);

    void addRoleMenuRelation(Integer roleId, List<Integer> menuIds);
}
