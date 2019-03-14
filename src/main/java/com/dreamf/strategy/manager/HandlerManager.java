package com.dreamf.strategy.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dreamf.strategy.handler.Handler;

/**
 * the manager have all handlers
 * @author lmj
 *
 */
public class HandlerManager {
    /**
     * all handlers
     */
    private static Map<Integer, Handler> handlers=new ConcurrentHashMap<>();
    
    public static Map<Integer, Handler> getHandlers() {
        return handlers;
    }
    
    public static Object handle(Integer businessId,Object param) {
        Handler handler = handlers.get(businessId);
        if(null == handler)
            throw new NullPointerException("not find the handler,the businessId is "+businessId);
        return handler.handle(param);
    }
}
