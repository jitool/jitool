package com.dreamf.constant;

/**
 * 注：
 *
 * @Author: ZhengGuiSheng
 * @Date: 2019/3/23 14:47
 */
public enum CharsetEnum {
    UTF_8("UTF-8");

    private String value;

    public String getValue() {
        return value;
    }

    CharsetEnum(String value) {
        this.value = value;
    }
}
