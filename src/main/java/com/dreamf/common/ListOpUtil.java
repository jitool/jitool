package com.dreamf.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: miaoguoxin
 * @Date: 2019/3/22 0022 16:03
 * @Description: 集合操作
 */
public class ListOpUtil {
    /**
     * 功能描述:切分子集合
     *
     * @param: [startIndex:起始下标，capacity:需要切分的子集合大小，targetList：被切分的集合]
     * @return:
     * @auther: miaoguoxin
     * @date: 2018/11/29 0029 13:40
     */
    public static <T> List<T> subList(int startIndex, int capacity, List<T> targetList) {
        if (startIndex < 0 || capacity <= 0) {
            throw new RuntimeException("startIndex or capacity error");
        }
        if (targetList == null) {
            throw new RuntimeException("targetList is not allow empty");
        }
        if (targetList.isEmpty()) {
            return new ArrayList<>();
        }
        if (startIndex > targetList.size()) {
            return new ArrayList<>();
        }
        int length = targetList.size();
        int endIndex = startIndex + capacity;
        if (endIndex >= length) {
            endIndex = length;
        }
        return targetList.subList(startIndex, endIndex);
    }
}
