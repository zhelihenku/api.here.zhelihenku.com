package com.zhelihenku.here.rest.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhelihenku.here.rest.modular.system.model.SystemDepartment;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author PhilWang
 * @since 2018-09-09
 */
public interface SystemDepartmentMapper extends BaseMapper<SystemDepartment> {

    List<SystemDepartment> selectSystemDepartmentPageList(Page page);

    void deleteSystemDepartmentByIds(Map<String, Object> params);
}
