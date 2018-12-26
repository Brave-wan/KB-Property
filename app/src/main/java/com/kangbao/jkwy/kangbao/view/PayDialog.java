package com.kangbao.jkwy.kangbao.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.kangbao.jkwy.kangbao.R;

public class PayDialog extends Dialog {
    private String title;

    public PayDialog(Context context, String payType) {
        super(context, R.style.DialogTheme);
        this.title = payType;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pay);
    }


}
