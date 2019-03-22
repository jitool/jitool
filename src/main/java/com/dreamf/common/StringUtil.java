package com.dreamf.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: miaoguoxin
 * @Date: 2019/3/22 0022 15:53
 * @Description:
 */
public class StringUtil {

    /**
     * 判断字符串对象是不是NULL或空，如果是，返回true，不是false
     * @param _string
     * @return
     */
    public static boolean isEmpty(final Object _string) {
        return ((_string == null) || (_string.toString().trim().length() == 0));
    }



    /**
     * 判定非空
     *
     * @param _string
     * @return
     */
    public static boolean isNotEmpty(Object _string) {
        return (!isEmpty(_string));
    }

    /**
     *
     * 功能描述: 替换掉特殊字符（换行、制表符等）
     *
     * @param:
     * @return:
     * @auther: miaoguoxin
     * @date: 2019/3/12 0012 18:29
     */
    public static String replaceSpecialChar(String str) {

        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 功能描述:获取随机字符串
     *
     * @param: [length:随机长度 randSeedStr:随机字符串因子]
     * @return:
     * @auther: miaoguoxin
     * @date: 2019/2/25 0025 17:34
     */
    public static String getRandomString(int length, String randSeedStr) {
        if (length <= 0 || isEmpty(randSeedStr)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int len = randSeedStr.length();
        for (int i = 0; i < length; i++) {
            int round = (int) Math.round(Math.random() * (len - 1));
            sb.append(randSeedStr.charAt(round));
        }
        return sb.toString();
    }

    /**
     *
     * 功能描述: 获取指定url中的某个参数
     *
     * @param: [url:地址 param:需要获取的参数名称]
     * @return:
     * @auther: miaoguoxin
     * @date: 2019/3/22 0022 16:00
     */
    public static String getParamByUrl(String url, String paramName) {
        url += "&";
        String pattern = "(\\?|&){1}#{0,1}" + paramName + "=[a-zA-Z0-9]*(&{1})";

        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(url);
        if (m.find()) {
            return m.group(0).split("=")[1].replace("&", "");
        } else {
            return null;
        }
    }

    /**
     * 获取int
     *
     * @param _strSrc
     * @return
     */
    public static int getInt(Object _strSrc) {
        if (isEmpty(_strSrc)) {
            return 0;
        }
        try {
            return Integer.parseInt(_strSrc.toString().trim());
        } catch (Exception e) {
            return 0;
        }
    }

    public static long getLong(Object _strSrc) {
        if (isEmpty(_strSrc)) {
            return 0;
        }
        try {
            return Long.parseLong(_strSrc.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获取double
     *
     * @param _strSrc
     * @return
     */
    public static double getDouble(Object _strSrc) {
        if (isEmpty(_strSrc)) {
            return 0;
        }
        try {
            return Double.parseDouble(_strSrc.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     *
     * 功能描述:array数组转字符串
     *
     * @param: [array:字符串数组 suffix:分割字符串]
     * @return:
     * @auther: miaoguoxin
     * @date: 2019/3/22 0022 16:05
     */
    public static String array2String(final String[] array,final String suffix){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<array.length;i++){
            if(i==array.length-1){
                builder.append(array[i]);
            }
            else {
                builder.append(array[i]).append(suffix);
            }
        }
        return builder.toString();
    }
}
