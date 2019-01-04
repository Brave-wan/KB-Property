package com.kangbao.jkwy.kangbao.present;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import com.adtech.sys.util.Encrypt;
import com.adtech.sys.util.MD5Util;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.kangbao.jkwy.kangbao.bean.BuildingListBean;
import com.kangbao.jkwy.kangbao.bean.HouseListBean;
import com.kangbao.jkwy.kangbao.bean.LoginInfo;
import com.kangbao.jkwy.kangbao.bean.LoginInfoBean;
import com.kangbao.jkwy.kangbao.bean.OpenIdBean;
import com.kangbao.jkwy.kangbao.bean.SessionBean;
import com.kangbao.jkwy.kangbao.util.AppKeyConfig;
import com.kangbao.jkwy.kangbao.util.CommonlyUtils;
import com.kangbao.jkwy.kangbao.util.GsonUtils;
import com.kangbao.jkwy.kangbao.util.NetWorksUtils;
import com.kangbao.jkwy.kangbao.util.SharedPreferencesUtils;
import com.kangbao.jkwy.kangbao.util.StringDialogCallback;
import com.kangbao.jkwy.kangbao.util.UrlConfig;
import com.kangbao.jkwy.kangbao.view.IMainProjectView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import okhttp3.Call;
import okhttp3.Response;

public class MainPresent {
    private Activity mContext;
    private IMainProjectView mView;

    public MainPresent(Activity mContext, IMainProjectView mView) {
        this.mContext = mContext;
        this.mView = mView;
        ToastUtils.showLong(PhoneUtils.getIMEI());
        LogUtils.i("imei:" + PhoneUtils.getIMEI());
        String androidId = Settings.Secure.getString(mContext.getContentResolver(), Build.SERIAL);
        LogUtils.i("IMEI:"+android.os.Build.SERIAL);
        // IMEI:6450649207ba4455
    }


    public void getUserInfo() {
        OkGo.post(UrlConfig.getAppUrl() + "Appinterface/getKbUserInfo")
                .headers("signature", "")
                .params("kbMac", android.os.Build.SERIAL)
//                .params("kbMac", "1510000100000006")
                .params("PageInfoVo", CommonlyUtils.pageInfo(1))
                .params("token", AppKeyConfig.KB_SESSION_ID)
                .execute(new StringDialogCallback(mContext, "正在获取用户信息中") {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {
                            Log.e("getKbUserInfo", s);
                            LoginInfoBean sessionBean = GsonUtils.parseFromJson(s, LoginInfoBean.class);
                            if (sessionBean != null && sessionBean.getData() != null && sessionBean.getData().getKbUser() != null) {
                                if (sessionBean.getData().getKbUser().size() > 0) {
                                    LoginInfoBean.DataBean.KbUserBean kbUserBean = sessionBean.getData().getKbUser().get(0);
                                    SharedPreferencesUtils.init(mContext)
                                            .put("user_id", kbUserBean.getId() + "")
                                            .put("user_nick_name", kbUserBean.getNickName())
                                            .put("user_project_id", kbUserBean.getProjectId())
                                            .put("user_project_name", kbUserBean.getProjectName())
                                            .put("user_name", kbUserBean.getLoginAcct())
                                            .put("user_pwd", kbUserBean.getPassWord());
                                    mView.onProjectName(kbUserBean.getProjectName());
                                    login(sessionBean.getData().getKbUser().get(0).getLoginAcct(), sessionBean.getData().getKbUser().get(0).getPassWord());
                                } else {
                                    ToastUtils.showShort("暂无该用户信息");
                                }
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


    public void login(String name, String pwd) {
        SortedMap<String, String> map = new TreeMap<>();
        map.put("userName", name);
        map.put("passWord", pwd);
        OkGo.post(UrlConfig.getAppUrl() + "Appinterface/userLogin")
                .headers("signature", createSign2(map))
                .params("userName", name)
                .params("passWord", pwd)
                .execute(new StringDialogCallback(mContext, "正在获取用户信息中") {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {
                            Log.e("LoginInfo", s);
                            LoginInfo sessionBean = GsonUtils.parseFromJson(s, LoginInfo.class);
                            if (sessionBean != null && sessionBean.getData() != null) {
                                getAppOauth(sessionBean.getData().getSessionId());
                            } else {
                                ToastUtils.showShort("获取用户信息失败");
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


    private void getAppOauth(String sessionid_first) {
        if (NetWorksUtils.isConnected(mContext)) {
            SortedMap<String, String> map = new TreeMap<>();
            map.put("userId", SharedPreferencesUtils.init(mContext).getString("user_id"));
            map.put("sessionId", sessionid_first);
            map.put("appKey", "A7J9rTWXwJlcxniE7XHe");
            getMapPoint(map);
        } else {
            new AlertDialog.Builder(mContext).setTitle("提示")//设置对话框标题
                    .setMessage("网络请求失败，请检查网络再试")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
        }
    }


    public void getMapPoint(SortedMap<String, String> map) {
        OkGo.post(UrlConfig.getAppUrl() + "Appinterface/platformOauth")
                .headers("signature", createSign(map))
                .headers("uid", SharedPreferencesUtils.init(mContext).getString("user_id"))
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {
                            Log.e("getMapPoint", s);
                            OpenIdBean openIdBean = GsonUtils.parseFromJson(s, OpenIdBean.class);
                            if (openIdBean != null && openIdBean.getData() != null) {
                                String openid = openIdBean.getData().getOpenId();
                                getTokenData(openid);
                            } else {
                                ToastUtils.showShort("未获得授权");
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


    /**
     * 获取token值
     */
    private void getTokenData(String openid) {
        OkGo.post(UrlConfig.getBuilding() + "appController/getToken")
                .params("openId", openid)
                .params("projectId", SharedPreferencesUtils.init(mContext).getString("user_project_id"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {
                            Log.e("getTokenData", s);
                            SessionBean sessionBean = GsonUtils.parseFromJson(s, SessionBean.class);
                            if (sessionBean != null && sessionBean.getData() != null) {
                                AppKeyConfig.putBuildingKey(mContext, sessionBean.getData().getSessionId());
                                getBuilding(sessionBean.getData().getSessionId());
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


    public void getBuilding(String sessionid) {
        SortedMap<String, String> map = new TreeMap<>();
        map.put("projectId", SharedPreferencesUtils.init(mContext).getString("user_project_id"));
        map.put("PageInfoVo", CommonlyUtils.pageInfo(1));
        map.put("token", sessionid);
        OkGo.post(UrlConfig.getBuilding() + "BuildingOwner/findBuildingList")
                .headers("signature", createSign(map))
                .headers("uid", SharedPreferencesUtils.init(mContext).getString("user_id"))
                .params(map)
                .execute(new StringDialogCallback(mContext, "正在楼栋信息中") {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {
                            Log.e("findBuildingList", s);
                            BuildingListBean buildingListBean = GsonUtils.parseFromJson(s, BuildingListBean.class);
                            if (buildingListBean != null && buildingListBean.getData() != null && buildingListBean.getData().getBuildList() != null) {
                                mView.onBuildList(buildingListBean.getData().getBuildList());
                                getFindOwnerByBuilding(buildingListBean.getData().getBuildList().get(0).getBuildId());
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

    public void getFindOwnerByBuilding(String buildingNo) {
        SortedMap<String, String> map = new TreeMap<>();
        map.put("projectId", SharedPreferencesUtils.init(mContext).getString("user_project_id"));
        map.put("PageInfoVo", CommonlyUtils.pageInfo(1));
        map.put("token", AppKeyConfig.getBuildingKey(mContext));
        map.put("buildingNo", buildingNo);
        OkGo.post(UrlConfig.getBuilding() + "BuildingOwner/findArrearsByBuilding")
                .headers("signature", createSign(map))
                .headers("uid", SharedPreferencesUtils.init(mContext).getString("user_id"))
                .params(map)
                .execute(new StringDialogCallback(mContext, "正在查询欠费房屋列表") {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {
                            Log.e("findBuildingList", s);
                            HouseListBean houseListBean = GsonUtils.parseFromJson(s, HouseListBean.class);
                            if (houseListBean != null && houseListBean.getData() != null && houseListBean.getData().getHouseArrearsList() != null) {
                                mView.onHouseArrearsList(houseListBean.getData().getHouseArrearsList());
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
