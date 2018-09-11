package com.zhelihenku.here.rest.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhelihenku.here.rest.common.util.CommonConstant;
import com.zhelihenku.here.rest.common.util.RestScrviceExceptionEunm;
import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.system.dao.SystemMenuMapper;
import com.zhelihenku.here.rest.modular.system.dto.*;
import com.zhelihenku.here.rest.modular.system.model.SystemMenu;
import com.zhelihenku.here.rest.modular.system.service.ISystemMenuService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-31
 */
@Service
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu> implements ISystemMenuService {

    @Override
    public Result getSystemMenuPageList(SystemMenuPageListRequest request) {
        Result result = new Result();

        Page page = new Page<>(request.getIndex(), request.getPageSize());
        List<SystemMenu> systemMenuList = this.baseMapper.selectPage(page, new EntityWrapper<SystemMenu>()
                .eq("is_delete", CommonConstant.DELETE_STATUS_UNDELETE)
                .orderBy("create_time", false));
        List<SystemMenuListModel> listModels = new ArrayList<>();
        for (SystemMenu systemMenu : systemMenuList) {
            SystemMenuListModel systemMenuListModel = this.getSystemMenuListModelBySystemMenu(systemMenu);
            listModels.add(systemMenuListModel);
        }

        page.setRecords(listModels);
        result.setData(page);

        return result;
    }

    public SystemMenuListModel getSystemMenuListModelBySystemMenu(SystemMenu systemMenu) {
        SystemMenuListModel model = new SystemMenuListModel();
        model.setId(systemMenu.getId());
        model.setPid(systemMenu.getPid());
        model.setName(systemMenu.getName());
        model.setUrl(systemMenu.getUrl());
        model.setIcon(systemMenu.getIcon());
        model.setLevels(systemMenu.getLevels());
        model.setIsMenu(systemMenu.getIsMenu());
        model.setIsOpen(systemMenu.getIsOpen());
        model.setDesc(systemMenu.getDesc());
        model.setStatus(systemMenu.getStatus());
        model.setCreateTime(systemMenu.getCreateTime());

        List<SystemMenu> tempSyetemMenuList = new ArrayList<>();
        tempSyetemMenuList.add(systemMenu);

        List<SystemMenu> parentSystemMenuList= this.getParentSystemMenu(systemMenu.getPid(), tempSyetemMenuList);
        List<String> pids = new ArrayList<>();
        List<String> pNames = new ArrayList<>();
        for (SystemMenu SystemMenu : parentSystemMenuList) {
            pids.add(0, String.valueOf(SystemMenu.getId()));
            pNames.add(0, SystemMenu.getName());
        }
        model.setPids(String.join(",", pids));
        model.setFullName(String.join("-", pNames));

        return model;
    }

    public List<SystemMenu> getParentSystemMenu(Integer pid, List<SystemMenu> SystemMenus) {

        if (pid == 0) {
            return SystemMenus;
        } else {
            SystemMenu SystemMenu = this.baseMapper.selectById(pid);
            if (null != SystemMenu) {
                SystemMenus.add(SystemMenu);
                if (SystemMenu.getPid() != 0) {
                    this.getParentSystemMenu(SystemMenu.getPid(), SystemMenus);
                }
            }
        }

        return SystemMenus;
    }

    @Override
    public Result getSystemMenuAllList() {
        Result result = new Result();

        List<SystemMenu> systemMenuList = this.getSystemMenuAlls();
        result.setData(systemMenuList);

        return result;
    }

    @Override
    public List<SystemMenu> getSystemMenuAlls() {

        List<SystemMenu> systemMenuList = this.baseMapper.selectList(new EntityWrapper<SystemMenu>()
                .eq("is_delete", CommonConstant.DELETE_STATUS_UNDELETE)
                .orderBy("create_time", false));

        return systemMenuList;
    }

    @Override
    public Result getSystemMenuTreeList(SystemMenuTreeRequest request) {
        Result result = new Result();

        List<SystemMenu> SystemMenuList = this.getSystemMenuAlls();

        // 最后的结果
        List<SystemMenuTreeModel> SystemMenuTreeList = new ArrayList<>();

        List<SystemMenu> tempSystemMenuList = new ArrayList<>();

        // 先找到所有的一级菜单
        for (SystemMenu SystemMenu : SystemMenuList) {
            // 一级菜单没有parentId
            if (SystemMenu.getPid() == 0) {
                SystemMenuTreeModel systemMenuTreeModel = new SystemMenuTreeModel();
                systemMenuTreeModel.setId(SystemMenu.getId());
                systemMenuTreeModel.setPid(SystemMenu.getPid());
                systemMenuTreeModel.setName(SystemMenu.getName());

                SystemMenuTreeList.add(systemMenuTreeModel);
            } else {
                tempSystemMenuList.add(SystemMenu);
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SystemMenuTreeModel systemMenuTreeModel : SystemMenuTreeList) {
            Map<String,Object> data = getChild(systemMenuTreeModel.getId(), tempSystemMenuList);
            if (null != data) {
                systemMenuTreeModel.setChildMenus((List<SystemMenuTreeModel>) data.get("childList"));
                tempSystemMenuList = (List<SystemMenu>) data.get("oldList");
            }
        }

        result.setData(SystemMenuTreeList);

        return result;
    }

    private Map<String,Object> getChild(Integer id, List<SystemMenu> deptList) {

        List<SystemMenu> tempSystemMenuList = new ArrayList<>();
        List<Integer> tempIds = new ArrayList<>();

        // 子菜单
        List<SystemMenuTreeModel> childList = new ArrayList<>();
        for (SystemMenu SystemMenu : deptList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(String.valueOf(SystemMenu.getPid()))) {
                if (SystemMenu.getPid().equals(id)) {
                    SystemMenuTreeModel systemMenuTreeModel = new SystemMenuTreeModel();
                    systemMenuTreeModel.setId(SystemMenu.getId());
                    systemMenuTreeModel.setPid(SystemMenu.getPid());
                    systemMenuTreeModel.setName(SystemMenu.getName());
                    childList.add(systemMenuTreeModel);
                } else {
                    tempSystemMenuList.add(SystemMenu);
                    tempIds.add(SystemMenu.getId());
                }
            }
        }

        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SystemMenuTreeModel systemMenuTreeModel : childList) {
            Map<String,Object> data = getChild(systemMenuTreeModel.getId(), tempSystemMenuList);
            if (null != data) {
                systemMenuTreeModel.setChildMenus((List<SystemMenuTreeModel>) data.get("childList"));
                tempSystemMenuList = (List<SystemMenu>) data.get("oldList");
            }
        }

        if (childList.size() == 0) {
            return null;
        }

        Map<String,Object> data = new HashMap<>();
        data.put("childList", childList);
        data.put("oldList", tempSystemMenuList);

        return data;
    }

    @Override
    public Result addSystemMenu(AddSystemMenuRequest request) {
        Result result = new Result();

        if (StringUtils.isEmpty(request.getName())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_MENU_NAME);
        } else if (StringUtils.isEmpty(String.valueOf(request.getPid()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_MENU_PID);
        } else if (StringUtils.isEmpty(request.getUrl())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_MENU_URL);
        } else if (StringUtils.isEmpty(String.valueOf(request.getIsMenu()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_MENU_ISMENU);
        }

        SystemMenu systemMenu = new SystemMenu();
        systemMenu.setName(request.getName());
        systemMenu.setPid(request.getPid());
        systemMenu.setIcon(request.getIcon());
        systemMenu.setUrl(request.getUrl());
        systemMenu.setLevels(request.getLevels());
        systemMenu.setIsMenu(request.getIsMenu());
        systemMenu.setDesc(request.getDesc());

        baseMapper.insert(systemMenu);

        return result;
    }

    @Override
    public Result updateSystemMenu(AddSystemMenuRequest request) {
        Result result = new Result();

        if (StringUtils.isEmpty(String.valueOf(String.valueOf(request.getId())))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_MENU_ID);
        } else if (StringUtils.isEmpty(request.getName())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_MENU_NAME);
        } else if (StringUtils.isEmpty(String.valueOf(request.getPid()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_MENU_PID);
        } else if (StringUtils.isEmpty(request.getUrl())) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_MENU_URL);
        } else if (StringUtils.isEmpty(String.valueOf(request.getIsMenu()))) {
            return Result.getResult(RestScrviceExceptionEunm.PRARMS_NULL_SYSTEM_MENU_ISMENU);
        }

        SystemMenu systemMenu = new SystemMenu();
        systemMenu.setId(request.getId());
        systemMenu.setName(request.getName());
        systemMenu.setPid(request.getPid());
        systemMenu.setIcon(request.getIcon());
        systemMenu.setUrl(request.getUrl());
        systemMenu.setLevels(request.getLevels());
        systemMenu.setIsMenu(request.getIsMenu());
        systemMenu.setDesc(request.getDesc());

        baseMapper.updateById(systemMenu);

        return result;
    }

    @Override
    public Result deleteSystemMenu(DeleteSystemMenuRequest request) {
        Result result = new Result();


        Map<String, Object> params = new HashedMap();
        params.put("ids", request.getIds());
        this.baseMapper.deleteSystemMenuByIds(params);

        return result;
    }

    @Override
    public Result getSystemMenuDetail(SystemMenuDetailRequest request) {
        Result result = new Result();

        SystemMenu systemMenu = this.baseMapper.selectById(request.getMenuId());
        result.setData(systemMenu);

        return result;
    }

    @Override
    public List<SystemMenu> getSystemMenuListByRoleId(Integer roleId) {
        List<SystemMenu> systemMenuList = this.baseMapper.selectSystemMenuListByRoleId(roleId);
        return systemMenuList;
    }

    @Override
    public List<SystemRouterModel> getSystemMenuRouterList() {

        List<SystemMenu> SystemMenuList = this.getSystemMenuAlls();

        // 最后的结果
        List<SystemRouterModel> systemRouterModelList = new ArrayList<>();

        List<SystemMenu> tempSystemMenuList = new ArrayList<>();
        // 先找到所有的一级菜单
        for (SystemMenu systemMenu : SystemMenuList) {
            // 一级菜单没有parentId
            if (systemMenu.getPid() == 0) {

                SystemRouterMetaModel metaModel = new SystemRouterMetaModel();
                metaModel.setTitle(systemMenu.getName());
                metaModel.setIcon(systemMenu.getIcon());

                SystemRouterModel systemRouterModel = new SystemRouterModel();
                systemRouterModel.setId(systemMenu.getId());
                systemRouterModel.setPid(systemMenu.getPid());
                systemRouterModel.setPath("/" + systemMenu.getUrl());
                systemRouterModel.setComponent("Layout");
                systemRouterModel.setName("System");
                systemRouterModel.setRedirect("/system/user");
                systemRouterModel.setMeta(metaModel);

                systemRouterModelList.add(systemRouterModel);
            } else {
                tempSystemMenuList.add(systemMenu);
            }
        }

        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SystemRouterModel systemRouterModel : systemRouterModelList) {
            Map<String,Object> data = getChildRouter(systemRouterModel.getId(), tempSystemMenuList);
            if (null != data) {
                systemRouterModel.setChildren((List<SystemRouterModel>) data.get("childList"));
                tempSystemMenuList = (List<SystemMenu>) data.get("oldList");
            }
        }

        SystemRouterModel systemRouterModel = new SystemRouterModel();
        systemRouterModel.setPath("*");
        systemRouterModel.setRedirect("/404");

        systemRouterModelList.add(systemRouterModel);

        return systemRouterModelList;
    }

    private Map<String,Object> getChildRouter(Integer id, List<SystemMenu> deptList) {

        List<SystemMenu> tempSystemMenuList = new ArrayList<>();

        // 子路由
        List<SystemRouterModel> childList = new ArrayList<>();
        for (SystemMenu systemMenu : deptList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(String.valueOf(systemMenu.getPid()))) {
                if (systemMenu.getPid().equals(id)) {
                    SystemRouterMetaModel metaModel = new SystemRouterMetaModel();
                    metaModel.setTitle(systemMenu.getName());
                    metaModel.setIcon(systemMenu.getIcon());

                    SystemRouterModel systemRouterModel = new SystemRouterModel();
                    systemRouterModel.setId(systemMenu.getId());
                    systemRouterModel.setPid(systemMenu.getPid());
                    systemRouterModel.setPath(systemMenu.getUrl());
                    systemRouterModel.setComponent("User");
                    systemRouterModel.setName(systemMenu.getName());
                    systemRouterModel.setRedirect(systemMenu.getUrl());
                    systemRouterModel.setMeta(metaModel);

                    childList.add(systemRouterModel);
                } else {
                    tempSystemMenuList.add(systemMenu);
                }
            }
        }

        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SystemRouterModel systemRouterModel : childList) {
            Map<String,Object> data = getChildRouter(systemRouterModel.getId(), tempSystemMenuList);
            if (null != data) {
                systemRouterModel.setChildren((List<SystemRouterModel>) data.get("childList"));
                tempSystemMenuList = (List<SystemMenu>) data.get("oldList");
            }
        }

        if (childList.size() == 0) {
            return null;
        }

        Map<String,Object> data = new HashMap<>();
        data.put("childList", childList);
        data.put("oldList", tempSystemMenuList);

        return data;
    }
}
