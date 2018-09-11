package com.zhelihenku.here.rest.modular.system.controller;

import com.zhelihenku.here.core.base.controller.BaseController;
import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.service.ISystemMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统菜单控制器
 *
 * @author fengshuonan
 * @Date 2018-08-31 14:30:34
 */
@RestController
@RequestMapping("/systemMenu")
public class SystemMenuController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SystemMenuController.class);

    @Autowired
    private ISystemMenuService systemMenuService;

    /**
     * 获取系统菜单分页列表
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public Object getSystemMenuPageList(@RequestBody SystemMenuPageListRequest request) {
        logger.info("getSystemMenuPageList params is " + request);
        Result result = systemMenuService.getSystemMenuPageList(request);
        logger.info("getSystemMenuPageList result is " + result);

        return result;
    }

    /**
     * 获取系统菜单列表
     */
    @RequestMapping(value = "/allList", method = RequestMethod.POST)
    public Object getSystemMenuAllList() {
        logger.info("getSystemMenuAllList params is ");
        Result result = systemMenuService.getSystemMenuAllList();
        logger.info("getSystemMenuAllList result is " + result);

        return result;
    }

    /**
     * 获取系统菜单树列表
     */
    @RequestMapping(value = "/treeList", method = RequestMethod.POST)
    public Object getSystemMenuTreeList(SystemMenuTreeRequest request) {
        logger.info("getSystemMenuTreeList params is " + request);
        Result result = systemMenuService.getSystemMenuTreeList(request);
        logger.info("getSystemMenuTreeList result is " + result);

        return result;
    }

    /**
     * 新增系统菜单
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addSystemMenu(@RequestBody AddSystemMenuRequest request) {
        logger.info("addSystemMenu params is " + request);
        Result result = systemMenuService.addSystemMenu(request);
        logger.info("addSystemMenu result is " + result);

        return result;
    }

    /**
     * 修改系统菜单
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateSystemMenu(@RequestBody AddSystemMenuRequest request) {
        logger.info("updateSystemMenu params is " + request);
        Result result = systemMenuService.updateSystemMenu(request);
        logger.info("updateSystemMenu result is " + result);

        return result;
    }

    /**
     * 删除系统菜单
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Object deleteSystemMenu(@RequestBody DeleteSystemMenuRequest request) {
        logger.info("deleteSystemMenu params is " + request);
        Result result = systemMenuService.deleteSystemMenu(request);
        logger.info("deleteSystemMenu result is " + result);

        return result;
    }

    /**
     * 系统菜单详情
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Object getSystemMenuDetail(@RequestBody SystemMenuDetailRequest request) {
        logger.info("getSystemMenuDetail params is " + request);
        Result result = systemMenuService.getSystemMenuDetail(request);
        logger.info("getSystemMenuDetail result is " + result);

        return result;
    }
}
