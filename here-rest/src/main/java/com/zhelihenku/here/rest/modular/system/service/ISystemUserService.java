package com.zhelihenku.here.rest.modular.system.service;

import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.model.SystemUser;
import com.baomidou.mybatisplus.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-31
 */
public interface ISystemUserService extends IService<SystemUser> {

    Result systemUserLogin(SystemUserLoginRequest request);

    Result systemUserLogout(SystemUserLogoutRequest request);

    Result getSystemUserInfo(HttpServletRequest request);

    Result getSystemUserPageList(SystemUserPageListRequest request);

    Result addSystemUser(AddSystemUserRequest request);

    Result updateSystemUser(AddSystemUserRequest request);

    Result deleteSystemUser(DeleteSystemUserRequest request);
}
