package com.dreamf.number;

import java.util.Random;

/**
 * @Auther: miaoguoxin
 * @Date: 2019/3/20 0020 11:39
 * @Description: 具体计算工具
 */
public class DistanceUtil {
    private static final double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double getDistanceNumber(double lngme, double latme, double long2, double lat2){
        double a, b, d, sa2, sb2;
        latme = rad(latme);
        lat2 = rad(lat2);
        a = latme - lat2;
        b = rad(lngme - long2);

        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2 * EARTH_RADIUS * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(latme) * Math.cos(lat2) * sb2 * sb2));
        return d;
    }

    /**
     *
     * 功能描述:获取随机经纬度
     *
     * @param: [lng:中心经度 lat:中心纬度 range:随机范围（直径，单位：米）]
     * @return:
     * @auther: miaoguoxin
     * @date: 2019/3/14 0014 11:02
     */
    public static double[] getRandomLngLat(double lng,double lat,double range){
        if(lng<0||lng>180){
            throw new RuntimeException("illegal lng");
        }
        if(lat<-90||lat>90){
            throw new RuntimeException("illegal lat");
        }
        if(range>EARTH_RADIUS){
            throw new RuntimeException("illegal range");
        }
        Random random = new Random();
        double circleR = range/1000/1000/2;

        double r = Math.sqrt(Math.random()) * circleR;
        double theta = random.nextInt(3600000) * 0.0001;

        double x = r * Math.sin(theta);//纬度
        double y = r * Math.cos(theta);//经度

        return new double[]{lng+y,lat+x};
    }
}
