package com.zhelihenku.here.rest.modular.system.dto;

/**
 * SystemUserLoginRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/8/31 14:43
 */
public class SystemUserLoginRequest {

    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SystemUserLoginRequest{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
