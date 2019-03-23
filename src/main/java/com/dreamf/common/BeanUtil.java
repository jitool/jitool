package com.dreamf.common;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
/**
 * 
 * @author lmj
 *
 */
public class BeanUtil {
    
    /**
     * class 必须要有构造方法
     * 
     * @param orig 来源
     * @param dest 需要返回的class对象
     * @return class.newInstance
     */
    public static <T> T copy(Object orig, Class dest) {
        T t = null;
        try {
            t = (T) dest.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("the class : " + dest + " don`t have the default construst");
        }
        try {
            BeanUtils.copyProperties(t, orig);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // ignore
        }
        return t;
    }
    
    public static void copyProperties(Object dest, Object orig) {
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // ignore
        }
    }
}
