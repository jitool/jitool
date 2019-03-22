package com.dreamf.designpattern.strategy;


import com.dreamf.spring.SpringBeanUtils;

/**
 * @Auther: miaoguoxin
 * @Date: 2019/3/20 0020 11:49
 * @Description: 策略加载管理类
 */
public class StrategyLoader<T,R> {

    /**
     *
     * 功能描述:业务处理方法
     *
     * @param: [businessType:业务类型(对应bean名称) param:请求参数]
     * @return:
     * @auther: miaoguoxin
     * @date: 2019/3/20 0020 12:49
     */
    public R handle(String businessType,T param){
        //前置处理


        //业务处理
        BaseHandlerInft<T,R> bean = (BaseHandlerInft<T,R>)SpringBeanUtils.getBean(businessType, BaseHandlerInft.class);
        if (bean==null){
            throw new RuntimeException("处理类不存在");
        }
        return bean.handleBusiness(param);
    }
}
