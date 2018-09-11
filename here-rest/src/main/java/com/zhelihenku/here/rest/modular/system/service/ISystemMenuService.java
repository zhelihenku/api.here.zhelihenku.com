package com.zhelihenku.here.rest.modular.system.service;

import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.model.SystemMenu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-31
 */
public interface ISystemMenuService extends IService<SystemMenu> {

    Result getSystemMenuPageList(SystemMenuPageListRequest request);

    Result getSystemMenuAllList();

    List<SystemMenu> getSystemMenuAlls();

    Result getSystemMenuTreeList(SystemMenuTreeRequest request);

    Result addSystemMenu(AddSystemMenuRequest request);

    Result updateSystemMenu(AddSystemMenuRequest request);

    Result deleteSystemMenu(DeleteSystemMenuRequest request);

    Result getSystemMenuDetail(SystemMenuDetailRequest request);

    List<SystemMenu> getSystemMenuListByRoleId(Integer roleId);

    List<SystemRouterModel> getSystemMenuRouterList();

}
