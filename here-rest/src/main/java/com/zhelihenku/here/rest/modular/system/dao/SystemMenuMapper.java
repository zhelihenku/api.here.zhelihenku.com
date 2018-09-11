package com.zhelihenku.here.rest.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhelihenku.here.rest.modular.system.model.SystemMenu;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-31
 */
public interface SystemMenuMapper extends BaseMapper<SystemMenu> {

    void deleteSystemMenuByIds(Map<String, Object> params);

    List<SystemMenu> selectSystemMenuListByRoleId(Integer roleId);
}
