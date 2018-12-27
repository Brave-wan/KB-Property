package com.kangbao.jkwy.kangbao.present;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;

import com.adtech.sys.util.Encrypt;
import com.adtech.sys.util.MD5Util;
import com.kangbao.jkwy.kangbao.bean.ArrearsListBean;
import com.kangbao.jkwy.kangbao.bean.BuildingListBean;
import com.kangbao.jkwy.kangbao.bean.FeeInfoBean;
import com.kangbao.jkwy.kangbao.bean.HousingResult;
import com.kangbao.jkwy.kangbao.bean.LackDetailBean;
import com.kangbao.jkwy.kangbao.bean.TwoCodePayBean;
import com.kangbao.jkwy.kangbao.util.AppKeyConfig;
import com.kangbao.jkwy.kangbao.util.CommonlyUtils;
import com.kangbao.jkwy.kangbao.util.GsonUtils;
import com.kangbao.jkwy.kangbao.util.SharedPreferencesUtils;
import com.kangbao.jkwy.kangbao.util.StringDialogCallback;
import com.kangbao.jkwy.kangbao.util.ToastUtils;
import com.kangbao.jkwy.kangbao.util.UrlConfig;
import com.kangbao.jkwy.kangbao.utils.ZXingUtils;
import com.kangbao.jkwy.kangbao.view.IArrearsListView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
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


    private List<FeeInfoBean> feeInfoBeanList = new ArrayList<>();

    /**
     * @param payType 1,WX_NATIVE,ALI_QRCODE
     * @param model
     */
    public void addRecordPre(final String payType, final ArrearsListBean.DataBean model) {

        List<ArrearsListBean.DataBean.DetailListBean> list = model.getDetailList();
        if (TextUtils.isEmpty(payType)) {
            ToastUtils.show(mContext, "请选择支付类型");
            return;
        }
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < list.get(j).getTypeList().size(); i++) {
                FeeInfoBean feeInfoBean = new FeeInfoBean();
                feeInfoBean.setProjectName(list.get(j).getTypeList().get(i).getChargeName());
                feeInfoBean.setTotalAmount(list.get(j).getTypeList().get(i).getTotalAmount());
                feeInfoBean.setThisAmount(list.get(j).getTypeList().get(i).getThisAmount());
                feeInfoBean.setChargeId(list.get(j).getTypeList().get(i).getChargeId());
                if (!TextUtils.isEmpty(list.get(j).getMouth())) {
                    if (list.get(j).getMouth().length() > 6) {
                        if (TextUtils.equals(list.get(j).getMouth().substring(5, 6), "0")) {
                            feeInfoBean.setMonth(list.get(j).getMouth().substring(6, 7));
                        } else {
                            feeInfoBean.setMonth(list.get(j).getMouth().substring(5, 7));
                        }
                    }
                }
                feeInfoBeanList.add(feeInfoBean);
            }
        }
        String feeInfo = GsonUtils.parseToJsons(feeInfoBeanList);
        //UrlConfig.getProperty()
        //(projectName,totalAmount,thisAmount,chargeId,month)
        //http://dev.tq-service.com/property/base/Api/addRecordPay
        Random random = new Random();

        OkGo.post(AppKeyConfig.addRecordPay + "Api/addRecordPay")
                .params("orderNum", "jkwy" + getDateToString(System.currentTimeMillis()) + random.nextInt(1000))
                .params("ucId", "111")
                .params("openid", "111")
                .params("reName", TextUtils.isEmpty(model.getOwnerName()) ? "" : model.getOwnerName())
                .params("rePhone", TextUtils.isEmpty(model.getOwnerPhone()) ? "" : model.getOwnerPhone())
                .params("ownerName", TextUtils.isEmpty(model.getOwnerName()) ? "" : model.getOwnerName())
                .params("ownerPhone", TextUtils.isEmpty(model.getOwnerPhone()) ? "" : model.getOwnerPhone())
                .params("houseType", TextUtils.isEmpty(model.getHouseType()) ? "" : model.getHouseType())
                .params("houseId", TextUtils.isEmpty(model.getHouseId()) ? "" : model.getHouseId())
                .params("houseNo", TextUtils.isEmpty(model.getHouseNo()) ? "" : model.getHouseNo())
                .params("projectId", TextUtils.isEmpty(model.getProjectId()) ? "" : model.getProjectId())
                .params("projectName", TextUtils.isEmpty(model.getProjectName()) ? "" : model.getProjectName())
                .params("address", TextUtils.isEmpty(model.getAdress()) ? "" : model.getAdress())
                .params("buildId", TextUtils.isEmpty(model.getBuildId()) ? "" : model.getBuildId())
                .params("buildName", TextUtils.isEmpty(model.getBuildName()) ? "" : model.getBuildName())
                .params("company", TextUtils.isEmpty(model.getCompany()) ? "" : model.getCompany())
                .params("totalMoney", TextUtils.isEmpty(model.getTotal()) ? "" : model.getTotal())
                .params("payType", payType)
                .params("operateTel", SharedPreferencesUtils.init(mContext).getString("user_name"))
                .params("operateName", SharedPreferencesUtils.init(mContext).getString("user_nick_name"))
                .params("feeInfo", feeInfo)
                .cacheKey("addRecordPay")
                .cacheMode(CacheMode.DEFAULT.NO_CACHE)
                .execute(new StringDialogCallback(mContext, "正在创建订单") {
                    @Override
                    public void onSuccess(String s, okhttp3.Call call, okhttp3.Response response) {
                        try {
                            Log.e("addRecordPay", s);
                            HousingResult housingResult = GsonUtils.parseFromJson(s, HousingResult.class);
                            if (housingResult != null && housingResult.getErrcode() == 200 && housingResult.getData() != null) {
                                String tradeNo = (String) housingResult.getData();
                                if (TextUtils.isEmpty(tradeNo)) {
                                    ToastUtils.show(mContext, "订单创建异常!");
                                    return;
                                }
                                String totalMoney = TextUtils.isEmpty(model.getTotal()) ? "" : model.getTotal();
                                String projectId = TextUtils.isEmpty(model.getProjectId()) ? "" : model.getProjectId();
                                String projectName = TextUtils.isEmpty(model.getProjectName()) ? "" : model.getProjectName();
                                float money = Float.valueOf(totalMoney) * 100;
                                directPay(payType, ((int) money) , projectId, projectName, tradeNo,totalMoney);
                            } else {
                                ToastUtils.show(mContext, "订单创建失败");
                            }
                        } catch (Exception e) {
                            Log.e("printStackTrace", "Exception: " + Log.getStackTraceString(e));
                        }
                    }

                    @Override
                    public void onError(okhttp3.Call call, okhttp3.Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.show(mContext, "网络错误");
                    }
                });
    }


    private void directPay(String payType, final int money, String projectId, String projectName, String tradeNo,final String totalMoney) {

        String channel;
        if (TextUtils.equals(payType, "1")) {
            channel = "WX_NATIVE";
        } else {
            channel = "ALI_QRCODE";
        }

        String curTime = getDateToString(System.currentTimeMillis());
        String sign = Encrypt.md5("channel=" + channel
                + "&money=" + money
                + "&nonceStr=" + "daguanjia" + curTime
                + "&notifyUrl=" + AppKeyConfig.addRecordPay + "Wx/huiPayNotify"
                + "&projectId=" + projectId
                + "&subject=" + (TextUtils.equals("WX_NATIVE", channel) ? projectName + "-大管家微支付" : projectName + "-大管家支付宝")
                + "&timestamp=" + curTime
                + "&tradeNo=" + tradeNo);
        /**
         * channel=WX_NATIVE&money=1&nonceStr=daguanjia20181015151340
         * &notifyUrl=http://www.tq-service.com/property/base/Wx/huiPayNotify&projectId=38e70023-9bb1-4874-855f-6f46ac61fff8
         * &subject=大管家扫码缴费&timestamp=20181015151340&tradeNo=jkwy2018101515133935

         */

        OkGo.post(AppKeyConfig.directPay + "Creditcard/nativePay")
                .params("channel", channel)
                .params("money", money)
                .params("nonceStr", "daguanjia" + curTime)
                .params("notifyUrl", AppKeyConfig.addRecordPay + "Wx/huiPayNotify")
                .params("projectId", projectId)
                .params("subject", TextUtils.equals("WX_NATIVE", channel) ? projectName + "-大管家微支付" : projectName + "-大管家支付宝")
                .params("timestamp", curTime)
                .params("tradeNo", tradeNo)
                .params("sign", sign.toUpperCase())
                .cacheMode(CacheMode.DEFAULT.NO_CACHE)
                .execute(new StringDialogCallback(mContext, "二维码生成中") {
                    @Override
                    public void onSuccess(String s, okhttp3.Call call, okhttp3.Response response) {
                        try {
                            Log.e("nativePay", s);
                            TwoCodePayBean model = GsonUtils.parseFromJson(s, TwoCodePayBean.class);
                            if (model != null) {
                                if (TextUtils.equals(model.getCode(), "200")) {
                                    if (model.getData() != null) {
                                        if (!TextUtils.isEmpty(model.getData().getCode_url())) {
                                            mView.OnCodeUrl(model.getData(), totalMoney);
                                        } else {
                                            ToastUtils.show(mContext, "未获取到二维码链接");
                                        }
                                    } else {
                                        ToastUtils.show(mContext, "未获取到二维码链接");
                                    }
                                } else {
                                    ToastUtils.show(mContext, "未获取到二维码链接");
                                }
                            } else {
                                ToastUtils.show(mContext, "未获取到二维码链接");
                            }
                        } catch (Exception e) {
                            Log.e("printStackTrace", "Exception: " + Log.getStackTraceString(e));
                        }
                    }


                    @Override
                    public void onError(okhttp3.Call call, okhttp3.Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.show(mContext, "网络错误");
                    }
                });
    }


    /**
     * @param out_trade_no
     * @param hy_bill_no
     * @param projectId
     * @param houseId
     */
    public void queryOrder(String out_trade_no, String hy_bill_no, String projectId, final String houseId) {
        OkGo.post(AppKeyConfig.directPay + "Creditcard/queryOrder")
                .params("tradeNo", out_trade_no)
                .params("hyBillNo", hy_bill_no)
                .params("projectId", projectId)
                .cacheMode(CacheMode.DEFAULT.NO_CACHE)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, okhttp3.Call call, okhttp3.Response response) {
                        try {
                            Log.e("queryOrder", s);
                            LackDetailBean model = GsonUtils.parseFromJson(s, LackDetailBean.class);
                            if (model != null && TextUtils.equals(model.getCode(), "200")) {
                                successPay(houseId);
                                if (!TextUtils.isEmpty(model.getMessage())) {
                                    ToastUtils.show(mContext, model.getMessage());
                                }
                            } else {
                                ToastUtils.show(mContext, "支付失败");
                                mView.onPayResult(false);
                            }
                        } catch (Exception e) {
                            Log.e("printStackTrace", "Exception: " + Log.getStackTraceString(e));
                        }
                    }

                    @Override
                    public void onError(okhttp3.Call call, okhttp3.Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.show(mContext, "网络错误");
                    }
                });
    }


    private void successPay(String houseId) {
        SortedMap<String, String> map = new TreeMap<>();
        map.put("houseId", houseId);
        map.put("token", AppKeyConfig.getBuildingKey(mContext));
        OkGo.post(UrlConfig.getBuilding() + "BuildingOwner/housePaying/")
                .headers("signature", createSign(map))
                .headers("uid", SharedPreferencesUtils.init(mContext).getString("user_id"))
                .params(map)
                .cacheMode(CacheMode.DEFAULT.NO_CACHE)
                .execute(new StringDialogCallback(mContext, "提交支付账单中") {
                    @Override
                    public void onSuccess(String s, okhttp3.Call call, okhttp3.Response response) {
                        try {
                            Log.e("housePaying", s);
                            HousingResult model = GsonUtils.parseFromJson(s, HousingResult.class);
                            if (model != null && model.getErrcode() == 200) {
                                ToastUtils.show(mContext, "提交支付账单成功!");
                                mView.onPayResult(true);
                            } else {
                                ToastUtils.show(mContext, "提交支付账单失败!");
                                mView.onPayResult(false);
                            }
                        } catch (Exception e) {
                            Log.e("printStackTrace", "Exception: " + Log.getStackTraceString(e));
                        }
                    }

                    @Override
                    public void onError(okhttp3.Call call, okhttp3.Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.show(mContext, "网络错误,请重试!");
                    }
                });
    }


    @SuppressLint("SimpleDateFormat")
    public SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");

    private String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
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