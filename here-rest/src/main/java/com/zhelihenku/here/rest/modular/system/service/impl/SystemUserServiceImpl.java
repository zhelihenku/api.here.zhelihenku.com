package com.zhelihenku.here.rest.modular.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhelihenku.here.core.util.MD5Util;
import com.zhelihenku.here.rest.common.util.CommonConstant;
import com.zhelihenku.here.rest.common.util.RestScrviceExceptionEunm;
import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.auth.util.JwtTokenUtil;
import com.zhelihenku.here.rest.modular.auth.util.UserInfoUtil;
import com.zhelihenku.here.rest.modular.system.dao.SystemUserMapper;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.model.SystemMenu;
import com.zhelihenku.here.rest.modular.system.model.SystemUser;
import com.zhelihenku.here.rest.modular.system.service.ISystemDepartmentService;
import com.zhelihenku.here.rest.modular.system.service.ISystemMenuService;
import com.zhelihenku.here.rest.modular.system.service.ISystemRoleService;
import com.zhelihenku.here.rest.modular.system.service.ISystemUserService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-31
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ISystemMenuService systemMenuService;

    @Autowired
    private ISystemDepartmentService systemDepartmentService;

    @Autowired
    private ISystemRoleService systemRoleService;

    @Autowired
    UserInfoUtil userInfoUtil;

    @Override
    public Result systemUserLogin(SystemUserLoginRequest request) {
        Result result = new Result();

        if (StringUtils.isEmpty(request.getAccount())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_ACCOUNT);
        } else if (StringUtils.isEmpty(request.getPassword())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_PASSWORD);
        }

        SystemUser params = new SystemUser();
        params.setAccount(request.getAccount());
        SystemUser systemUser = this.baseMapper.selectOne(params);

        if (null == systemUser || systemUser.getIsDelete().equals(CommonConstant.DELETE_STATUS_DELETED)) {
            return Result.getResult(RestScrviceExceptionEunm.ERROR_NON_EXISTENT_SYSTEM_USER);
        }

        System.out.println(MD5Util.encrypt(request.getPassword()));

        if (!systemUser.getPassword().equals(MD5Util.encrypt(request.getPassword()))) {
            return Result.getResult(RestScrviceExceptionEunm.ERROR_SYSTEM_USER_LOGIN_PASSWORD);
        }

        if (systemUser.getStatus().equals(CommonConstant.SYSTEM_USER_STATUS_DISENABLE)) {
            return Result.getResult(RestScrviceExceptionEunm.ERROR_SYSTEM_USER_DISENABLE);
        }

        if (systemUser.getStatus().equals(CommonConstant.SYSTEM_USER_STATUS_FROZEN)) {
            return Result.getResult(RestScrviceExceptionEunm.ERROR_SYSTEM_USER_FROZEN);
        }

        SystemUserInfoModel systemUserInfoModel = new SystemUserInfoModel();
        systemUserInfoModel.setId(systemUser.getId());
        systemUserInfoModel.setAccount(systemUser.getAccount());
        systemUserInfoModel.setName(systemUser.getName());
        String userInfo = JSONObject.toJSONString(systemUserInfoModel);

        String randomKey = jwtTokenUtil.getRandomKey();
        String token = "Bearer " + jwtTokenUtil.generateToken(userInfo, randomKey);

        SystemUserLoginResponse response = new SystemUserLoginResponse();
        response.setToken(token);
        response.setRandomKey(randomKey);
        result.setData(response);

        return result;
    }

    @Override
    public Result systemUserLogout(SystemUserLogoutRequest request) {
        Result result = new Result();

        return result;
    }

    @Override
    public Result getSystemUserInfo(HttpServletRequest request) {
        Result result = new Result();

        SystemUserInfoModel systemUserInfoModel = userInfoUtil.getUserInfo(request);

        if (null == systemUserInfoModel) {
            return Result.getResult(RestScrviceExceptionEunm.ERROR_UNKNOWN);
        }

        SystemUser systemUser = this.baseMapper.selectById(systemUserInfoModel.getId());
        if (null == systemUser || systemUser.getIsDelete().equals(CommonConstant.DELETE_STATUS_DELETED)) {
            return Result.getResult(RestScrviceExceptionEunm.ERROR_NON_EXISTENT_SYSTEM_USER);
        }

        if (systemUser.getStatus().equals(CommonConstant.SYSTEM_USER_STATUS_DISENABLE)) {
            return Result.getResult(RestScrviceExceptionEunm.ERROR_SYSTEM_USER_DISENABLE);
        }

        if (systemUser.getStatus().equals(CommonConstant.SYSTEM_USER_STATUS_FROZEN)) {
            return Result.getResult(RestScrviceExceptionEunm.ERROR_SYSTEM_USER_FROZEN);
        }

        SystemUserInfoResponse response = new SystemUserInfoResponse();
        response.setAvatar(systemUser.getAvatar());
        response.setName(systemUser.getName());

        List<SystemMenu> systemMenuList = systemMenuService.getSystemMenuListByRoleId(systemUser.getRoleId());

        List<String> menus = new ArrayList<>();
        for (SystemMenu systemMenu : systemMenuList) {
            menus.add(toUpperCaseFirstOne(systemMenu.getUrl()));
        }

        response.setMenus(menus);

        result.setData(response);

        return result;
    }

    //首字母转大写
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    @Override
    public Result getSystemUserPageList(SystemUserPageListRequest request) {
        Result result = new Result();

        Page page = new Page<>(request.getIndex(), request.getPageSize());
        List<SystemUser> systemUserList = this.baseMapper.selectPage(page, new EntityWrapper<SystemUser>()
                .eq("is_delete", CommonConstant.DELETE_STATUS_UNDELETE)
                .orderBy("create_time", false));
        page.setRecords(systemUserList);

        result.setData(page);

        return result;
    }


    @Override
    public Result addSystemUser(AddSystemUserRequest request) {
        Result result = new Result();

        if (StringUtils.isEmpty(request.getAccount())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_ACCOUNT);
        } else if (StringUtils.isEmpty(request.getPassword())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_PASSWORD);
        } else if (StringUtils.isEmpty(request.getName())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_NAME);
        } else if (StringUtils.isEmpty(String.valueOf(request.getRoleId()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_ROLE_ID);
        } else if (StringUtils.isEmpty(String.valueOf(request.getDepartmentId()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_DEPARTMENT_ID);
        }

        SystemUser systemUser = new SystemUser();
        systemUser.setAccount(request.getAccount());
        systemUser.setPassword(MD5Util.encrypt(request.getPassword()));
        systemUser.setName(request.getName());
        systemUser.setAvatar(request.getAvatar());
        systemUser.setName(request.getName());
        systemUser.setRoleId(request.getRoleId());
        systemUser.setDepartmentId(request.getDepartmentId());

        baseMapper.insert(systemUser);

        return result;
    }

    @Override
    public Result updateSystemUser(AddSystemUserRequest request) {
        Result result = new Result();

        if (StringUtils.isEmpty(String.valueOf(request.getId()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_ID);
        } else if (StringUtils.isEmpty(request.getAccount())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_ACCOUNT);
        } else if (StringUtils.isEmpty(request.getName())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_NAME);
        } else if (StringUtils.isEmpty(String.valueOf(request.getRoleId()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_ROLE_ID);
        } else if (StringUtils.isEmpty(String.valueOf(request.getDepartmentId()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_USER_DEPARTMENT_ID);
        }

        SystemUser systemUser = new SystemUser();
        systemUser.setId(request.getId());
        systemUser.setAccount(request.getAccount());
        systemUser.setName(request.getName());
        systemUser.setAvatar(request.getAvatar());
        systemUser.setRoleId(request.getRoleId());
        systemUser.setDepartmentId(request.getDepartmentId());

        baseMapper.updateById(systemUser);

        return result;
    }

    @Override
    public Result deleteSystemUser(DeleteSystemUserRequest request) {
        Result result = new Result();

        Map<String, Object> params = new HashedMap();
        params.put("ids", request.getIds());
        this.baseMapper.deleteSystemUserByIds(params);

        return result;
    }
}
