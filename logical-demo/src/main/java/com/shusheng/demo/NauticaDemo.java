package com.shusheng.demo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.RandomUtil;

import java.math.RoundingMode;

/**
 * @author 刘闯
 * @date 2022/7/26
 */
public class NauticaDemo {

    private static final double EARTH_RADIUS = 63.71000;

    private static final double DIS_RAIDUS = 1000;

    public static void main(String[] args) {

        TimeInterval timer = DateUtil.timer();
        timer.start();

        double rawLat = 121.618622;
        double rawLng = 38.91459;
        // 获得中心点向外1000m的最大最小经纬度
        Dict around = getAround(rawLat, rawLng, DIS_RAIDUS);

        for (int i = 0; i < 750000; i++) {

            double longitude = RandomUtil.randomDouble(around.getDouble("minLng"),
                    around.getDouble("maxLng"), 5, RoundingMode.HALF_UP);

            double latitude = RandomUtil.randomDouble(around.getDouble("minLat"),
                    around.getDouble("maxLat"), 5, RoundingMode.HALF_UP);
//            System.out.println("经度："+longitude+",维度："+latitude);
        }

//        for (int i = 0; i < 5000; i++) {
//            while (true){
//                double longitude = RandomUtil.randomDouble(around.getDouble("minLng"),
//                        around.getDouble("maxLng"), 5, RoundingMode.HALF_UP);
//
//                double latitude = RandomUtil.randomDouble(around.getDouble("minLat"),
//                        around.getDouble("maxLat"), 5, RoundingMode.HALF_UP);
//
//                // 获取与中心点的距离
//                double distance = getDistance(latitude, longitude, rawLat, rawLng);
//
//                if (distance < DIS_RAIDUS){
//                    System.out.println("经度："+longitude+",维度："+latitude);
//                    break;
//                }
//            }
//        }
        System.out.println("花费时间为：" + timer.intervalMs());
    }



    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算两个经纬度之间的距离
     * @param lon1 第一个经度
     * @param lat1 第一个维度
     * @param lon2 第二个经度
     * @param lat2 第二个维度
     * @return 距离
     */
    public static double getDistance(double lon1,double lat1,double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000)*1.0 / 10000;
        return s;
    }

    /**
     * 获取当前用户一定距离以内的经纬度值
     * 单位米 return minLat
     * 最小经度 minLng
     * 最小纬度 maxLat
     * 最大经度 maxLng
     * 最大纬度 minLat
     */
    public static Dict getAround(double longitude, double latitude, double raidusMile) {
        Dict dict = new Dict();

        double degree = (24901 * 1609) / 360.0; // 获取每度

        double mpdLng = Double.parseDouble((degree * Math.cos(latitude * (Math.PI / 180))+"").replace("-", ""));
        double dpmLng = 1 / mpdLng;
        double radiusLng = dpmLng * raidusMile;
        //获取最小经度
        double minLng = longitude - radiusLng;
        // 获取最大经度
        double maxLng = longitude + radiusLng;

        double dpmLat = 1 / degree;
        double radiusLat = dpmLat * raidusMile;
        // 获取最小纬度
        double minLat = latitude - radiusLat;
        // 获取最大纬度
        double maxLat = latitude + radiusLat;

        dict.set("minLng", minLng);
        dict.set("maxLng", maxLng);
        dict.set("minLat", minLat);
        dict.set("maxLat", maxLat);

        return dict;
    }
}
