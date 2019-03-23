package com.dreamf.encrypt;

import com.dreamf.constant.SignMethodEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * TODO：该模块为数据签名层，为双方通信增加双向签名方式保护业务的可靠性，目前待优化
 *
 * @Author: ZhengGuiSheng
 * @Date: 2019/3/23 13:18
 */
public class SignatureUtils {
    private static final Logger log = LoggerFactory.getLogger(SignatureUtils.class);

    public static Map<String, Object> sign(Map<String,Object> data) {
        return signature(data,"RSA");
    }

    public static Map<String,Object> signature(Map<String,Object> data,String method) {
        Map<String,Object> result = null;
        if(SignMethodEnum.RSA.getValue().equals(method)) {

        }
        if(SignMethodEnum.SHA_256.getValue().equals(method)) {

        }
        if(SignMethodEnum.SM_3.getValue().equals(method)) {

        }
        return result;
    }

}
