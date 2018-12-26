package com.kangbao.jkwy.kangbao.present;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.adtech.sys.util.Encrypt;
import com.adtech.sys.util.MD5Util;
import com.kangbao.jkwy.kangbao.bean.ArrearsListBean;
import com.kangbao.jkwy.kangbao.bean.BuildingListBean;
import com.kangbao.jkwy.kangbao.util.AppKeyConfig;
import com.kangbao.jkwy.kangbao.util.CommonlyUtils;
import com.kangbao.jkwy.kangbao.util.GsonUtils;
import com.kangbao.jkwy.kangbao.util.SharedPreferencesUtils;
import com.kangbao.jkwy.kangbao.util.StringDialogCallback;
import com.kangbao.jkwy.kangbao.util.UrlConfig;
import com.kangbao.jkwy.kangbao.view.IArrearsListView;
import com.lzy.okgo.OkGo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import okhttp3.Call;
import okhttp3.Response;

public class ArrearsListPresent {

    private Activity mContext;
    private IArrearsListView mView;

    public ArrearsListPresent(Activity mContext, IArrearsListView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    public void getFindArrearsDetails(String houseId) {
        SortedMap<String, String> map = new TreeMap<>();
        map.put("houseId", houseId);
        map.put("token", AppKeyConfig.getBuildingKey(mContext));
        OkGo.post(UrlConfig.getBuilding() + "BuildingOwner/findArrearsDetailsByHouseId")
                .headers("signature", createSign(map))
                .headers("uid", SharedPreferencesUtils.init(mContext).getString("user_id"))
                .params(map)
                .execute(new StringDialogCallback(mContext, "正在楼栋信息中") {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {
                            Log.e("findBuildingList", s);
                            ArrearsListBean arrearsListBean = GsonUtils.parseFromJson(s, ArrearsListBean.class);
                            if (arrearsListBean != null && arrearsListBean.getData() != null && arrearsListBean.getData().getDetailList() != null) {
                          mView.onArrearsListBean(arrearsListBean.getData());
//
                            }
                        } catch (Exception e) {
                            Log.e("printStackTrace", "Exception: " + Log.getStackTraceString(e));
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });
    }


    public String createSign2(SortedMap<String, String> map) {
        String tokenCommonlyUtils;
        SortedMap<Object, Object> sortedMap = new TreeMap<>();
        Set es = map.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry sign = (Map.Entry) it.next();
            Object k = sign.getKey();
            Object v = sign.getValue();
            sortedMap.put(k, v);
        }

        String loginName = SharedPreferencesUtils.init(mContext).getString("user_name");
        String loginPwd = SharedPreferencesUtils.init(mContext).getString("user_pwd");
        //请求加密
        tokenCommonlyUtils = Encrypt.md5(loginName + Encrypt.md5(loginPwd) + "jkwycruise");
        return MD5Util.createSign(tokenCommonlyUtils, "UTF-8", sortedMap);
    }


    private String createSign(SortedMap<String, String> map) {
        String tokenCommonlyUtils;
        SortedMap<Object, Object> sortedMap = new TreeMap<>();
        Set es = map.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry sign = (Map.Entry) it.next();
            Object k = sign.getKey();
            Object v = sign.getValue();
            sortedMap.put(k, v);
        }
        String loginName = SharedPreferencesUtils.init(mContext).getString("user_name");
        String loginPwd = SharedPreferencesUtils.init(mContext).getString("user_pwd");
        tokenCommonlyUtils = Encrypt.md5(loginName + Encrypt.md5(loginPwd) + "jkwycruise");
        return MD5Util.createSign(tokenCommonlyUtils, "UTF-8", sortedMap);
    }
}
