package com.dreamf.constant;

/**
 * 注：
 *
 * @Author: ZhengGuiSheng
 * @Date: 2019/3/23 15:16
 */
public enum SignMethodEnum {
    /***/
    RSA("RSA"),
    SHA_256("SHA256"),
    SM_3("SM3");

    private String value;

    public String getValue() {
        return value;
    }

    SignMethodEnum(String value) {
        this.value = value;
    }
}
