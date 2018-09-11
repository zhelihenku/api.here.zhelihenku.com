package com.zhelihenku.here.rest.modular.auth.controller.dto;

/**
 * 认证的请求dto
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:00
 */
public class AuthRequest {

    private String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "appName='" + appName + '\'' +
                '}';
    }
}
