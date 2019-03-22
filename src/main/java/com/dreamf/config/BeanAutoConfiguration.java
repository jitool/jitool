package com.dreamf.config;

import com.dreamf.designpattern.strategy.StrategyLoader;
import com.dreamf.spring.SpringBeanUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: miaoguoxin
 * @Date: 2019/3/20 0020 11:11
 * @Description: 用于自动装配spring相关资源
 */
@Configuration
public class BeanAutoConfiguration {
    private static final

    @Bean
    @ConditionalOnMissingBean(SpringBeanUtils.class)
    SpringBeanUtils springBeanUtils(){
         return new SpringBeanUtils();
     }

     @Bean
     @ConditionalOnMissingBean(StrategyLoader.class)
     StrategyLoader strategyLoader(){
        return new StrategyLoader();
     }
}
