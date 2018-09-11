package com.zhelihenku.here.jwt;

import com.alibaba.fastjson.JSON;
import com.zhelihenku.here.core.util.MD5Util;
import com.zhelihenku.here.rest.common.SimpleObject;
import com.zhelihenku.here.rest.modular.auth.converter.BaseTransferEntity;
import com.zhelihenku.here.rest.modular.auth.security.impl.Base64SecurityAction;

/**
 * jwt测试
 *
 * @author PhilWang
 * @date 2017-08-21 16:34
 */
public class DecryptTest {

    public static void main(String[] args) {

        String salt = "0iqwhi";

        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setUser("PhilWang");
        simpleObject.setAge(12);
        simpleObject.setName("ffff");
        simpleObject.setTips("code");

        String jsonString = JSON.toJSONString(simpleObject);
        String encode = new Base64SecurityAction().doAction(jsonString);
        String md5 = MD5Util.encrypt(encode + salt);

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setObject(encode);
        baseTransferEntity.setSign(md5);

        System.out.println(JSON.toJSONString(baseTransferEntity));
    }
}
