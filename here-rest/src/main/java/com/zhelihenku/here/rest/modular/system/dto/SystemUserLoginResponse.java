package com.zhelihenku.here.rest.modular.system.dto;

/**
 * SystemUserLoginResponse
 *
 * @Auther: PhilWang
 * @Date: 2018/9/4 16:14
 */
public class SystemUserLoginResponse {

    private String token;

    private String randomKey;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRandomKey() {
        return randomKey;
    }

    public void setRandomKey(String randomKey) {
        this.randomKey = randomKey;
    }

    @Override
    public String toString() {
        return "SystemUserLoginResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
