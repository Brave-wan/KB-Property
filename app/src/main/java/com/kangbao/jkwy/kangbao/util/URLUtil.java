package com.kangbao.jkwy.kangbao.util;

import java.util.HashMap;
import java.util.Map;

/**
 * function: url
 * author: hank
 * date: 2017/9/29
 */

public class URLUtil {
    public final static String KNOWLEDGE = "http://api.tq-service.com";
    //    public final static String KNOWLEDGE = "http://dev-oa.tq-service.com";
    public static final String CSLIB_URL = "http://dev-oa-api.tq-service.com/";//公告正式


    /**
     * 正式环境1
     *
     * @return
     */
    public static Map<String, String> getRegularURL1() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("appUrl", "http://oa.tq-service.com/");
        stringMap.put("equipmentUrl", "http://api.tq-service.com/dian/");
        stringMap.put("patrolUrl", "http://api.tq-service.com/dian/");
        stringMap.put("reportUrl", "http://api.tq-service.com/oa/");
        stringMap.put("handoverRoomUrl", "http://dev-oa.tq-service.com/jiefang/");
        return stringMap;
    }

    /**
     * 正式环境1
     *
     * @return
     */
    public static Map<String, String> getHuMei() {

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("appUrl", "http://api.tq-service.com/cruise/");
        stringMap.put("equipmentUrl", "http://cruise-api.tq-service.com/device/");
        stringMap.put("patrolUrl", "http://cruise-api.tq-service.com/dian/");
        stringMap.put("reportUrl", "http://api.tq-service.com/repair/");
        stringMap.put("handoverRoomUrl", "http://dev-oa.tq-service.com/jiefang/");
        return stringMap;
    }

    /**
     * 正式环境2
     *
     * @return
     */
    public static Map<String, String> getRegularURL2() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("appUrl", "http://api.tq-service.com/cruise/");//大管家基础数据
        stringMap.put("equipmentUrl", "http://api.tq-service.com/device/");//设备巡检接口
        stringMap.put("patrolUrl", "http://api.tq-service.com/dian/");//巡更
        stringMap.put("reportUrl", "http://api.tq-service.com/repair/");//报事
        stringMap.put("handoverRoomUrl", "http://api.tq-service.com/jiefang/");//接房
        stringMap.put("housing", "http://api.tq-service.com/jiefang/");
        stringMap.put("building", "http://api.tq-service.com/building/");//通知公告
        return stringMap;
    }

    /**
     * 测试环境
     *
     * @return
     */
    public static Map<String, String> getDebugURL() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("appUrl", "http://dev-oa-api.tq-service.com/");
        stringMap.put("equipmentUrl", "http://dev-oa-api.tq-service.com/device/");
        stringMap.put("patrolUrl", "http://dev-oa-api.tq-service.com/dian/");
        stringMap.put("reportUrl", "http://dev-oa.tq-service.com/repair/");
        stringMap.put("handoverRoomUrl", "http://dev-oa-api.tq-service.com/jiefang/");
        stringMap.put("housing", "http://dev-oa.tq-service.com/jiefang/");
        stringMap.put("building", "http://dev-oa.tq-service.com/building/");//通知公告
        stringMap.put("property", "http://dev.tq-service.com/property/");//缴费
        return stringMap;
    }

    public static Map<String, String> getNativeURL() {
        //包强
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("appUrl", "http://10.15.208.115:8080/Cruiselch4/");//所有的基础信息
        stringMap.put("equipmentUrl", "http://10.15.208.115:8089/DeviceMvn/");//设备巡检
        stringMap.put("patrolUrl", "http://10.15.208.115:8080/tqPatrol/");//巡更
        stringMap.put("reportUrl", "http://10.15.208.115:8089/CruMaven/");//配置巡检/工单池
        stringMap.put("handoverRoomUrl", "http://10.15.208.115:8080/device/");//接房
        stringMap.put("housing", "http://10.15.208.115:8080/house/");
        stringMap.put("Cruiselch", "http://10.15.208.115:8089/Cruiselch/");//回访
        stringMap.put("building", "http://10.15.208.115:8089/building/");//通知公告
        return stringMap;
    }

//    public static Map<String, String> getNativeURL() {
//        //罗莉
//        Map<String, String> stringMap = new HashMap<>();
//        stringMap.put("appUrl", "http://10.15.209.194:8080/Cruiselch4/");//所有的基础信息
//        stringMap.put("equipmentUrl", "http://10.15.209.194:8080/DeviceMvn/");//设备巡检
//        stringMap.put("patrolUrl", "http://10.15.209.194:8080/tqPatrol/");//巡更
//        stringMap.put("reportUrl", "http://10.15.209.194:8080/CruMaven/");//配置巡检/工单池
//        stringMap.put("handoverRoomUrl", "http://10.15.209.194:8080/device/");//接房0
//        stringMap.put("housing", "http://10.15.209.194:8080/house/");
//        stringMap.put("Cruiselch", "http://10.15.209.194:8080/Cruiselch/");//回访
//        stringMap.put("building", "http://10.15.209.194:8080/building/");//通知公告
//        return stringMap;
//    }

//
    public static Map<String, String> getNewService() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("appUrl", "http://api-development.tq-service.com/cruise/");//大管家基础数据
        stringMap.put("equipmentUrl", "http://api-development.tq-service.com/device/");//设备巡检接口
        stringMap.put("patrolUrl", "http://api-development.tq-service.com/dian/");//巡更
        stringMap.put("reportUrl", "http://api-development.tq-service.com/repair/");//报事
        stringMap.put("handoverRoomUrl", "http://api.tq-service.com/jiefang/");//接房
        stringMap.put("housing", "http://api.tq-service.com/jiefang/");
        return stringMap;
    }
}

