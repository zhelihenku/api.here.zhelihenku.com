package com.zhelihenku.here.rest.modular.system.dao;

import com.zhelihenku.here.rest.modular.system.model.SystemRoleMenuRelation;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 * 角色和菜单关联表 Mapper 接口
 * </p>
 *
 * @author PhilWang
 * @since 2018-09-09
 */
public interface SystemRoleMenuRelationMapper extends BaseMapper<SystemRoleMenuRelation> {

    void insertRoleMenuRelation(Map<String, Object> params);
}
