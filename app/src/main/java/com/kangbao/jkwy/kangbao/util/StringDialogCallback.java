package com.kangbao.jkwy.kangbao.util;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.Window;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;

/**
 * Created by Administrator on 2018/10/9.
 */

public abstract class StringDialogCallback extends StringCallback {

    private android.app.ProgressDialog dialog;

    public StringDialogCallback(Activity activity, String msg) {
        dialog = new android.app.ProgressDialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(android.app.ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(msg);
    }

    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        //网络请求前显示对话框
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onAfter(@Nullable String s, @Nullable Exception e) {
        super.onAfter(s, e);
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
