package com.dreamf.strategy.handler;

import javax.annotation.PostConstruct;

import com.dreamf.strategy.manager.HandlerManager;

/**
 * the handler base
 * @author lmj
 */
public interface Handler {

    /**
     * when you put your impl into the beanFactory.
     * the method will be execute
     */
    @PostConstruct
    default void init() {
        Handler oldHandler = HandlerManager.getHandlers().put(getKey(),this);
        if(null != oldHandler)
            throw new RuntimeException("your key have been repeated,the class is "+ this.getClass());
    }
    /**
     * @return the Business type
     */
    Integer getKey();
    
    /**
     * your real handle
     * @return result
     */
    Object handle(Object param);
}
