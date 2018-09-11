package com.zhelihenku.here.rest.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhelihenku.here.rest.modular.system.model.SystemRole;

import java.util.Map;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-31
 */
public interface SystemRoleMapper extends BaseMapper<SystemRole> {

    void deleteSystemRoleByIds(Map<String, Object> params);
}
