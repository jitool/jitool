package com.dreamf.Arrays;

/**
 * @author 黄为正
 * 数组操作工具类
 */
public final class MyArrays {
    /**
     * @author 黄为正
     * 适用场景：元素最大值不得大于数组长度10倍，并且适合正整数和零,数组长度超过2000
     */
    public static void sort(int [] a) {
        //获取最大值，通过最大值创建数组
        int max=a[0];
        //获取最大值，从最小值开始遍历
        int min=max;
        int count = a.length/2;
        int max1=a[count];
        int min1=max1;
        //获取最小值

        for(int i=1;i<count;i++) {
            if(max<a[i])
                max=a[i];
            else if(min>a[i])
                min=a[i];
            if(max1<a[count+i])
                max1=a[count+i];
            else if(min1>a[count+i])
                min1=a[count+i];
        }
        if(max<max1)
            max=max1;
        if(max<a[a.length-1])
            max=a[a.length-1];
        else if(min>a[a.length-1])
            min=a[a.length-1];
        if(min>min1)
            min=min1;
        //创建临时数组
        int [] temp=new int[max+1];
        for(int i=0;i<a.length;i++) {
            temp[a[i]]=temp[a[i]]+1;
        }
        //将值的数据取出插入原数组
        for (int i=min,n=0; i<temp.length; i++) {
            for (int j = 0; j<temp[i]; j++) {
                a[n++]=i;
            }
        }
    }
}