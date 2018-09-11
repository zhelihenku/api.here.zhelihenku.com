package com.zhelihenku.here.rest.modular.auth.util;

import com.alibaba.fastjson.JSON;
import com.zhelihenku.here.rest.config.properties.JwtProperties;
import com.zhelihenku.here.rest.modular.system.dto.SystemUserInfoModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * UserInfoUtil
 *
 * @Auther: PhilWang
 * @Date: 2018/9/11 16:22
 */
@Component
public class UserInfoUtil {
    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    public SystemUserInfoModel getUserInfo(HttpServletRequest request){
        String requestHeader = request.getHeader(jwtProperties.getHeader());
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            String authToken = requestHeader.substring(7);
            String userInfo = jwtTokenUtil.getUserInfoFromToken(authToken);
            if(StringUtils.isNotBlank(userInfo)){
                SystemUserInfoModel systemUser = JSON.parseObject(userInfo, SystemUserInfoModel.class);
                return systemUser;
            }
        }
        return null;
    }
}
