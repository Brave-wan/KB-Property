package com.kangbao.jkwy.kangbao.util;

import android.content.Context;

import com.google.gson.Gson;
import com.kangbao.jkwy.kangbao.bean.PageInfo;
import com.kangbao.jkwy.kangbao.bean.UserInfo;



/**
 * Created by root on 5/01/17.
 */

public class CommonlyUtils {

    public static void saveUserInfo(Context mContext, UserInfo info) {
        SharedPreferencesUtils.init(mContext)
                .putString("userName", info.getUserName())
                .putString("pass", info.getPassWord())
                .putString("session", info.getSessionid())
                .putString("userId", info.getUserId())
                .putString("name", info.getName())
                .putString("organization", info.getOrganization())
                .putString("roles", info.getRoles())
                .putString("roleType", info.getRoleType())
                .putString("orgCode", info.getOrgCodel())
                .putString("type", info.getType())
                .putString("orgName", info.getOrgName())
                .putString("power", info.getPower())
                .putString("leftOrgId", info.getLeftOrgId())
                .putString("leftOrgName", info.getLeftOrgName())
                .putString("mobile", info.getMobile())
                .putString("fenCompany", info.getFenCompany())
                .putString("position", info.getPosition())
                .putString("deptName", info.getDeptName())
                .putString("sex", info.getSex())
                .putString("company", info.getCommpany())
        ;
    }

    public static UserInfo getUserInfo(Context mContext) {
        UserInfo info = new UserInfo();
        info.setUserName(SharedPreferencesUtils.init(mContext).getString("userName"));
        info.setPassWord(SharedPreferencesUtils.init(mContext).getString("pass"));
        info.setUserId(SharedPreferencesUtils.init(mContext).getString("userId"));
        info.setSessionid(SharedPreferencesUtils.init(mContext).getString("session"));
        info.setName(SharedPreferencesUtils.init(mContext).getString("name"));
        info.setOrganization(SharedPreferencesUtils.init(mContext).getString("organization"));
        info.setRoles(SharedPreferencesUtils.init(mContext).getString("roles"));
        info.setRoleType(SharedPreferencesUtils.init(mContext).getString("roleType"));
        info.setOrgCodel(SharedPreferencesUtils.init(mContext).getString("orgCode"));
        info.setType(SharedPreferencesUtils.init(mContext).getString("type"));
        info.setOrgName(SharedPreferencesUtils.init(mContext).getString("orgName"));
        info.setPower(SharedPreferencesUtils.init(mContext).getString("power"));
        info.setLeftOrgId(SharedPreferencesUtils.init(mContext).getString("leftOrgId"));
        info.setLeftOrgName(SharedPreferencesUtils.init(mContext).getString("leftOrgName"));
        info.setMobile(SharedPreferencesUtils.init(mContext).getString("mobile", ""));
        info.setFenCompany(SharedPreferencesUtils.init(mContext).getString("fenCompany"));
        info.setDeptName(SharedPreferencesUtils.init(mContext).getString("deptName"));
        info.setPosition(SharedPreferencesUtils.init(mContext).getString("position"));
        info.setSex(SharedPreferencesUtils.init(mContext).getString("sex"));
        info.setCommpany(SharedPreferencesUtils.init(mContext).getString("company"));

        return info;
    }
    public static String pageInfo(int page) {
        PageInfo info = new PageInfo();
        info.setCurrentPage(page);
        info.setOrder("asc");
        info.setPageSize(20);
        String pageStr = new Gson().toJson(info);
        return pageStr;
    }
    public static String pageInfo(int page,int pageSize) {
        PageInfo info = new PageInfo();
        info.setCurrentPage(page);
        info.setOrder("asc");
        info.setPageSize(pageSize);
        String pageStr = new Gson().toJson(info);
        return pageStr;
    }

}
