package com.zhelihenku.here.rest.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhelihenku.here.rest.modular.system.model.SystemUser;

import java.util.Map;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-31
 */
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    void deleteSystemUserByIds(Map<String, Object> params);
}
