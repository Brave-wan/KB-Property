package com.kangbao.jkwy.kangbao.util;

import android.content.Context;

/**
 * Created by root on 18-5-30.
 */
public class AppKeyConfig {
    //巡更
    public static final String PatrolKey = "wGQt7hiz7MeSbQbdyBp1";
    //品质巡检
    public static final String QualityKey = "SE3Brc18CG0r44QTed1A";
    //设备巡检
    public static final String EquipmentKey = "0cuFfjWigFVevbGNb6Zw";
    //工单池
    public static final String WorkOrderPoolKey = "SE3Brc18CG0r44QTed1A";
    //报事保修
    public static final String ReportKey = "SE3Brc18CG0r44QTed1A";
    //接房
    public static final String InspectionRoomKey = "qF7jQxnUJRR9PtBk2Uig";
    public static final String HousingKey = "qF7jQxnUJRR9PtBk2Uig";
    //报事来源(122-巡检报事 123-巡更报事 124-设备报事 126-大社区报事  127-400报事 128-前台报事 148-公众号报事 153-云监控)
    public static final String INSPECTION_REPORT_KEY_122 = "122";//巡检报事
    public static final String PATROL_REPORT_KEY_123 = "123";//巡更报事
    public static final String Equipment_report_key_124 = "124";//设备报事
    public static final String COMMUNITY_REPORT_KEY_126 = "126";//大社区报事
    public static final String CUSTOMER_REPORT_KEY_400 = "400";//400报事
    public static final String FRONT_REPORT_KEY_128 = "128";//前台报事

    public static final String KB_SESSION_ID = "b8ec59b0ff6940d3b42eba145c20dd8c";


    /**
     * 获取接房的key
     *
     * @param mContext
     * @return
     */
    public static String getInspectionRoomKey(Context mContext) {
        return SharedPreferencesUtils.init(mContext).getString("housing_sessionId");
    }

    /**
     * 接房的key
     *
     * @param mContext
     * @param key
     */
    public static void putInspectionRoomKey(Context mContext, String key) {
        SharedPreferencesUtils.init(mContext).put("housing_sessionId", key);
    }


    /**
     * 品质巡检的key 保存
     *
     * @param mContext
     * @param key
     */
    public static void putQualityKey(Context mContext, String key) {
        SharedPreferencesUtils.init(mContext).put("quality_sessionId", key);
    }

    /**
     * 获取品质巡检的key
     *
     * @param mContext
     * @return
     */
    public static String getQualityKey(Context mContext) {
        return SharedPreferencesUtils.init(mContext).getString("quality_sessionId");
    }

    /**
     * 楼栋管家的key
     *
     * @param mContext
     * @param key
     */
    public static void putBuildingKey(Context mContext, String key) {
        SharedPreferencesUtils.init(mContext).put("building_sessionId", key);
    }

    /**
     * 获取楼栋管家的key
     *
     * @param mContext
     */
    public static String getBuildingKey(Context mContext) {
        return SharedPreferencesUtils.init(mContext).getString("building_sessionId");
    }

}
