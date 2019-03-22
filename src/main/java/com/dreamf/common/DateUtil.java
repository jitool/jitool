package com.dreamf.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: miaoguoxin
 * @Date: 2019/3/22 0022 16:07
 * @Description: 时间操作
 */
public class DateUtil {
    // Classical style
    public static final String PATTERN_CLASSICAL = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_CLASSICAL_NORMAL = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_CLASSICAL_SIMPLE = "yyyy-MM-dd";
    public static final String PATTERN_CLASSICAL_HOUR = "yyyy-MM-dd HH";

    public static final String FULL_SPECIAL_FORMAT = "yyyyMMddHHmmss";

    public static final String TADAY_START_TIME = " 00:00:00";

    public static final String TADAY_END_TIME = " 23:59:59";

    /**
     *
     * 功能描述:获取当前格式化时间
     *
     * @param:
     * @return:
     * @auther: miaoguoxin
     * @date: 2019/3/22 0022 16:09
     */
    public static String getCurrentDate(String pattern) {
        return dateFormat(new Date(), pattern);
    }

    /**
     *
     * 功能描述:时间格式化
     *
     * @param: [date:时间 pattern:格式化参数]
     * @return:
     * @auther: miaoguoxin
     * @date: 2019/3/22 0022 16:08
     */
    public static String dateFormat(Date date, String pattern) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     *
     * 功能描述:判断时间是否正确
     *
     * @param:
     * @return:
     * @auther: miaoguoxin
     * @date: 2019/3/22 0022 16:10
     */
    public static boolean isValidDate(Long date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            format.setLenient(false);
            format.parse(date.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * 功能描述:获取两个时间的时间差(秒)
     *
     * @param:
     * @return:
     * @auther: miaoguoxin
     * @date: 2019/3/22 0022 16:12
     */
    public static int getOffsetSeconds(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / 1000);
    }

    public static int getOffsetMinutes(Date date1, Date date2) {
        return getOffsetSeconds(date1, date2) / 60;
    }

    public static int getOffsetHours(Date date1, Date date2) {
        return getOffsetMinutes(date1, date2) / 60;
    }

    public static int getOffsetDays(Date date1, Date date2) {
        return getOffsetHours(date1, date2) / 24;
    }

    public static int getOffsetWeeks(Date date1, Date date2) {
        return getOffsetDays(date1, date2) / 7;
    }
}


