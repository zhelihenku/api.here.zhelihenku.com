package com.zhelihenku.here.rest.modular.system.controller;

import com.zhelihenku.here.core.base.controller.BaseController;
import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.service.ISystemUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统用户控制器
 *
 * @author fengshuonan
 * @Date 2018-08-31 14:26:54
 */
@RestController
@RequestMapping("/systemUser")
public class SystemUserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SystemUserController.class);

    @Autowired
    private ISystemUserService systemUserService;

    /**
     * 系统登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object systemUserLogin(SystemUserLoginRequest request) {
        logger.info("memberPasswordLogin params is " + request);
        Result result = systemUserService.systemUserLogin(request);
        logger.info("memberPasswordLogin result is " + result);

        return result;
    }

    /**
     * 系统登出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Object systemUserLogout(@RequestBody SystemUserLogoutRequest request) {
        logger.info("systemUserLogout params is " + request);
        Result result = systemUserService.systemUserLogout(request);
        logger.info("systemUserLogout result is " + result);

        return result;
    }

    /**
     * 获取系统用户信息
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public Object getSystemUserInfo(HttpServletRequest request) {
        logger.info("getSystemUserInfo params is " + request);
        Result result = systemUserService.getSystemUserInfo(request);
        logger.info("getSystemUserInfo result is " + result);

        return result;
    }

    /**
     * 获取系统用户分页列表
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public Object getSystemUserPageList(@RequestBody SystemUserPageListRequest request) {
        logger.info("getSystemUserPageList params is " + request);
        Result result = systemUserService.getSystemUserPageList(request);
        logger.info("getSystemUserPageList result is " + result);

        return result;
    }

    /**
     * 新增系统用户
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object addSystemUser(@RequestBody AddSystemUserRequest request) {
        logger.info("addSystemUser params is " + request);
        Result result = systemUserService.addSystemUser(request);
        logger.info("addSystemUser result is " + result);

        return result;
    }

    /**
     * 修改系统用户
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object updateSystemUser(@RequestBody AddSystemUserRequest request) {
        logger.info("updateSystemUser params is " + request);
        Result result = systemUserService.updateSystemUser(request);
        logger.info("updateSystemUser result is " + result);

        return result;
    }

    /**
     * 删除系统用户
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object deleteSystemUser(@RequestBody DeleteSystemUserRequest request) {
        logger.info("deleteSystemUser params is " + request);
        Result result = systemUserService.deleteSystemUser(request);
        logger.info("deleteSystemUser result is " + result);

        return result;
    }
}
