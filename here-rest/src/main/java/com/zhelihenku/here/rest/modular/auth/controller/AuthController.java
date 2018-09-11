package com.zhelihenku.here.rest.modular.auth.controller;

import com.zhelihenku.here.rest.common.util.Result;
import com.zhelihenku.here.rest.modular.auth.controller.dto.AuthRequest;
import com.zhelihenku.here.rest.modular.auth.controller.dto.AuthResponse;
import com.zhelihenku.here.rest.modular.auth.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "${jwt.auth-path}")
    public Object createAuthenticationToken(AuthRequest authRequest) {
        logger.info("createAuthenticationToken params is " + authRequest);

        final String randomKey = jwtTokenUtil.getRandomKey();
        final String token = jwtTokenUtil.generateToken(authRequest.getAppName(), randomKey);

        Result result = new Result();
        result.setData(new AuthResponse(token, randomKey));

        return result;
    }
}
