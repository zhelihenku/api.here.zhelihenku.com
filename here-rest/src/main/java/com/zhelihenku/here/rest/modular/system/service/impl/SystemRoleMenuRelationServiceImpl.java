package com.zhelihenku.here.rest.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhelihenku.here.rest.modular.system.dao.SystemRoleMenuRelationMapper;
import com.zhelihenku.here.rest.modular.system.model.SystemRoleMenuRelation;
import com.zhelihenku.here.rest.modular.system.service.ISystemRoleMenuRelationService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author PhilWang
 * @since 2018-09-09
 */
@Service
public class SystemRoleMenuRelationServiceImpl extends ServiceImpl<SystemRoleMenuRelationMapper, SystemRoleMenuRelation> implements ISystemRoleMenuRelationService {

    @Override
    public void delectRoleMenuRelationByRoleId(Integer roleId) {
        this.baseMapper.delete(new EntityWrapper<SystemRoleMenuRelation>().eq("role_id", roleId));
    }

    @Override
    public void addRoleMenuRelation(Integer roleId, List<Integer> menuIds) {

        Map<String, Object> params = new HashedMap();
        params.put("menuIds", menuIds);
        params.put("roleId", roleId);
        this.baseMapper.insertRoleMenuRelation(params);
    }
}
