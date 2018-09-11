package com.zhelihenku.here.rest.modular.system.controller;

import com.zhelihenku.here.core.base.controller.BaseController;
import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dto.AddSystemDepartmentRequest;
import com.zhelihenku.here.rest.modular.system.dto.DeleteSystemDepartmentRequest;
import com.zhelihenku.here.rest.modular.system.dto.SystemDepartmentDetailRequest;
import com.zhelihenku.here.rest.modular.system.dto.SystemDepartmentPageListRequest;
import com.zhelihenku.here.rest.modular.system.service.ISystemDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 部门机构控制器
 *
 * @author fengshuonan
 * @Date 2018-09-09 19:53:34
 */
@RestController
@RequestMapping("/systemDepartment")
public class SystemDepartmentController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SystemDepartmentController.class);

    @Autowired
    private ISystemDepartmentService systemDepartmentService;

    /**
     * 获取部门机构分页列表
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public Object getSystemDepartmentPageList(@RequestBody SystemDepartmentPageListRequest request) {
        logger.info("getSystemDepartmentPageList params is " + request);
        Result result = systemDepartmentService.getSystemDepartmentPageList(request);
        logger.info("getSystemDepartmentPageList result is " + result);

        return result;
    }

    /**
     * 获取部门机构树列表
     */
    @RequestMapping(value = "/treeList", method = RequestMethod.POST)
    public Object getSystemDepartmentTreeList() {
        logger.info("getSystemDepartmentTreeList params is ");
        Result result = systemDepartmentService.getSystemDepartmentTreeList();
        logger.info("getSystemDepartmentTreeList result is " + result);

        return result;
    }

    /**
     * 新增部门机构
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object addSystemDepartment(@RequestBody AddSystemDepartmentRequest request) {
        logger.info("addSystemDepartment params is " + request);
        Result result = systemDepartmentService.addSystemDepartment(request);
        logger.info("addSystemDepartment result is " + result);

        return result;
    }

    /**
     * 修改部门机构
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object updateSystemDepartment(@RequestBody AddSystemDepartmentRequest request) {
        logger.info("updateSystemDepartment params is " + request);
        Result result = systemDepartmentService.updateSystemDepartment(request);
        logger.info("updateSystemDepartment result is " + result);

        return result;
    }

    /**
     * 删除部门机构
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object deleteSystemDepartment(@RequestBody DeleteSystemDepartmentRequest request) {
        logger.info("deleteSystemDepartment params is " + request);
        Result result = systemDepartmentService.deleteSystemDepartment(request);
        logger.info("deleteSystemDepartment result is " + result);

        return result;
    }

    /**
     * 部门机构详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object getSystemDepartmentDetail(@RequestBody SystemDepartmentDetailRequest request) {
        logger.info("getSystemDepartmentDetail params is " + request);
        Result result = systemDepartmentService.getSystemDepartmentDetail(request);
        logger.info("getSystemDepartmentDetail result is " + result);

        return result;
    }
}
