package com.zhelihenku.here.rest.common.util;

import com.zhelihenku.here.core.exception.ServiceExceptionEnum;

public enum RestScrviceExceptionEunm implements ServiceExceptionEnum {

    // 1000-1099 系统错误码
    PRARMS_NULL_SYSTEM_DEPARTMENT_ID(1001, "系统部门ID不能为空"),
    PRARMS_NULL_SYSTEM_DEPARTMENT_NAME(1002, "系统部门名称不能为空"),
    PRARMS_NULL_SYSTEM_DEPARTMENT_PID(1003, "系统部门上级部门不能为空"),

    PRARMS_NULL_SYSTEM_ROLE_ID(1004, "系统角色ID不能为空"),
    PRARMS_NULL_SYSTEM_ROLE_NAME(1005, "系统角色名称不能为空"),
    PRARMS_NULL_SYSTEM_ROLE_PID(1006, "系统角色上级角色ID不能为空"),
    PRARMS_NULL_SYSTEM_ROLE_DEPARTMENT_ID(1007, "系统角色部门不能为空"),

    PRARMS_NULL_SYSTEM_MENU_ID(1008, "系统菜单ID不能为空"),
    PRARMS_NULL_SYSTEM_MENU_NAME(1009, "系统菜单名称不能为空"),
    PRARMS_NULL_SYSTEM_MENU_PID(1010, "系统菜单上级菜不能为空"),
    PRARMS_NULL_SYSTEM_MENU_URL(1011, "系统菜单路由地址不能为空"),
    PRARMS_NULL_SYSTEM_MENU_ISMENU(1012, "系统菜单-是不是菜单-不能为空"),

    PRARMS_NULL_SYSTEM_USER_ID(1013, "系统用户ID不能为空"),
    PRARMS_NULL_SYSTEM_USER_ACCOUNT(1014, "系统用户账号不能为空"),
    PRARMS_NULL_SYSTEM_USER_PASSWORD(1015, "系统用户密码不能为空"),
    PRARMS_NULL_SYSTEM_USER_NAME(1016, "系统用户名称不能为空"),
    PRARMS_NULL_SYSTEM_USER_ROLE_ID(1017, "系统用户角色不能为空"),
    PRARMS_NULL_SYSTEM_USER_DEPARTMENT_ID(1018, "系统用户部门不能为空"),


    ERROR_NON_EXISTENT_SYSTEM_USER(1019, "系统用户不存在"),
    ERROR_SYSTEM_USER_LOGIN_PASSWORD(1020, "系统用户登录密码错误"),
    ERROR_SYSTEM_USER_DISENABLE(1021, "当前系统用户账号已停用，请联系管理员"),
    ERROR_SYSTEM_USER_FROZEN(1022, "当前系统用户账号已冻结，请稍后重试"),

    ERROR_UPLOAD_IMAGE(1099, "上传图片错误"),


    // 1100-1999 用户中心错误码
    PRARMS_NULL_LOGIN_PHONE(1101, "登录手机号不能为空"),
    PRARMS_NULL_LOGIN_SMSCODE(1102, "登录验证码不能为空"),
    PRARMS_NULL_LOGIN_SMSCODE_TYPE(1103, "验证码类型不能为空"),
    PRARMS_NULL_LOGIN_PASSWORD(1104, "登录密码不能为空"),


    ERROR_FORMAT_LOGIN_PHONE(1201, "登录手机号格式错误"),
    ERROR_FORMAT_LOGIN_SMSCODE(1202, "登录验证码格式错误"),
    ERROR_LOGIN_SMSCODE(1203, "登录验证码错误"),
    ERROR_EXISTED_MEMBER(1204, "用户已存在"),
    ERROR_NON_EXISTENT_MEMBER(1205, "用户不存在"),
    ERROR_LOGIN_PASSWORD(1206, "登录密码错误"),


    // 2000-2999 视频中心错误码
    ERROR_PRARMS_NULL_ONLINEVIDEO_TITLE(2001, "在线视频标题不能为空"),
    ERROR_PRARMS_NULL_ONLINEVIDEO_IMAGE(2002, "在线视频配图不能为空"),
    ERROR_PRARMS_NULL_ONLINEVIDEO_URL(2003, "在线视频地址不能为空"),
    ERROR_PRARMS_NULL_ONLINEVIDEO_ID(2004, "在线视频ID不能为空"),
    ERROR_PRARMS_NULL_ONLINEVIDEO_STATUS(2005, "在线视频状态不能为空"),

    ERROR_PRARMS_NULL_ONLINEVIDEOGROUP_TITLE(2006, "在线视频组标题不能为空"),
    ERROR_PRARMS_NULL_ONLINEVIDEOGROUP_IMAGE(2007, "在线视频组配图不能为空"),
    ERROR_PRARMS_NULL_ONLINEVIDEOGROUP_AUTHOR(2008, "在线视频组作者不能为空"),
    ERROR_PRARMS_NULL_ONLINEVIDEOGROUP_CATEGORY_ID(2009, "在线视频分类ID不能为空"),
    ERROR_PRARMS_NULL_ONLINEVIDEOGROUP_ID(2010, "在线视频组ID不能为空"),
    ERROR_PRARMS_NULL_ONLINEVIDEOGROUP_STATUS(2011, "在线视频组状态不能为空"),

    ERROR_ONLINEVIDEO_NON_EXISTENT(2101, "在线视频不存在"),



    // 3000-3999 课程中心错误码
    ERROR_PRARMS_NULL_APPOINTMENTVIEW_ID(3001, "课程预约页面ID不能为空"),
    ERROR_PRARMS_NULL_APPOINTMENTVIEW_TITLE(3002, "课程预约页面标题不能为空"),
    ERROR_PRARMS_NULL_APPOINTMENTVIEW_CONTENT(3003, "课程预约页面内容不能为空"),


    ERROR_PRARMS_NULL_APPOINTMENT_NAME(3004, "课程预约姓名不能为空"),
    ERROR_PRARMS_NULL_APPOINTMENT_PHONE(3005, "课程预约手机号不能为空"),
    ERROR_PRARMS_NULL_APPOINTMENT_CHILENAME(3006, "课程预约孩子姓名不能为空"),
    ERROR_PRARMS_NULL_APPOINTMENT_CHILEAGE(3007, "课程预约孩子年龄不能为空"),
    ERROR_PRARMS_NULL_APPOINTMENT_COURES(3008, "课程预约课程不能为空"),
    ERROR_PRARMS_NULL_APPOINTMENT_CAMPUS(3009, "课程预约校区不能为空"),

    ERROR_UNKNOWN(-10000, "未知异常");

    RestScrviceExceptionEunm(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
