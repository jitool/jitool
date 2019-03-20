package com.dreamf.designpattern.strategy;

/**
 * @Auther: miaoguoxin
 * @Date: 2019/3/20 0020 11:46
 * @Description: 业务处理基类，需要实现该接口
 */
public interface BaseHandlerInft<T,R> {
    /**
     * 业务处理
     * @param param
     * @return
     */
    R handleBusiness(T param);
}
