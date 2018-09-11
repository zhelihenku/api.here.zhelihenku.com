package com.zhelihenku.here.rest.modular.system.controller;

import com.zhelihenku.here.core.base.controller.BaseController;
import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.service.ISystemRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统角色控制器
 *
 * @author fengshuonan
 * @Date 2018-08-31 14:30:16
 */
@RestController
@RequestMapping("/systemRole")
public class SystemRoleController extends BaseController {
    
    private static final Logger logger = LoggerFactory.getLogger(SystemRoleController.class);

    @Autowired
    private ISystemRoleService systemRoleService;

    /**
     * 获取系统角色分页列表
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public Object getSystemRolePageList(@RequestBody SystemRolePageListRequest request) {
        logger.info("getSystemRolePageList params is " + request);
        Result result = systemRoleService.getSystemRolePageList(request);
        logger.info("getSystemRolePageList result is " + result);

        return result;
    }

    /**
     * 获取系统角色列表
     */
    @RequestMapping(value = "/allList", method = RequestMethod.POST)
    public Object getSystemRoleAllList() {
        logger.info("getSystemRoleAllList params is ");
        Result result = systemRoleService.getSystemRoleAllList();
        logger.info("getSystemRoleAllList result is " + result);

        return result;
    }

    /**
     * 获取系统角色树列表
     */
    @RequestMapping(value = "/treeList", method = RequestMethod.POST)
    public Object getSystemRoleTreeList() {
        logger.info("getSystemRoleTreeList params is ");
        Result result = systemRoleService.getSystemRoleTreeList();
        logger.info("getSystemRoleTreeList result is " + result);

        return result;
    }

    /**
     * 新增系统角色
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addSystemRole(@RequestBody AddSystemRoleRequest request) {
        logger.info("addSystemRole params is " + request);
        Result result = systemRoleService.addSystemRole(request);
        logger.info("addSystemRole result is " + result);

        return result;
    }

    /**
     * 修改系统角色
     */
    @RequestMapping(value = "/updatePermissions", method = RequestMethod.POST)
    public Object updateSystemRolePermissions(@RequestBody SystemRolePermissionsRequest request) {
        logger.info("updateSystemRolePermissions params is " + request);
        Result result = systemRoleService.updateSystemRolePermissions(request);
        logger.info("updateSystemRolePermissions result is " + result);

        return result;
    }

    /**
     * 修改系统角色
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateSystemRole(@RequestBody AddSystemRoleRequest request) {
        logger.info("updateSystemRole params is " + request);
        Result result = systemRoleService.updateSystemRole(request);
        logger.info("updateSystemRole result is " + result);

        return result;
    }

    /**
     * 删除系统角色
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Object deleteSystemRole(@RequestBody DeleteSystemRoleRequest request) {
        logger.info("deleteSystemRole params is " + request);
        Result result = systemRoleService.deleteSystemRole(request);
        logger.info("deleteSystemRole result is " + result);

        return result;
    }

    /**
     * 系统角色详情
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Object getSystemRoleDetail(@RequestBody SystemRoleDetailRequest request) {
        logger.info("getSystemRoleDetail params is " + request);
        Result result = systemRoleService.getSystemRoleDetail(request);
        logger.info("getSystemRoleDetail result is " + result);

        return result;
    }
}
