package com.kangbao.jkwy.kangbao.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kangbao.jkwy.kangbao.R;

public class PayResultDialog extends Dialog {
    private boolean payType;
    private TextView tx_pay_result, tx_pay_result_btn;
    private Context context;

    public PayResultDialog(Context context, boolean payType) {
        super(context, R.style.DialogTheme);
        this.payType = payType;
        this.context = context;
    }


    private OnPayResultListener listener;

    public void setOnPayResultListener(OnPayResultListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pay_result);
        tx_pay_result = findViewById(R.id.tx_pay_result);
        tx_pay_result_btn = findViewById(R.id.tx_pay_result_btn);
        int res = payType ? R.mipmap.icon_pay_success : R.mipmap.icon_pay_fail;

        drawableText(tx_pay_result, res);
        tx_pay_result.setText(payType ? "缴费成功" : "缴费未成功");
        tx_pay_result.setTextColor(context.getResources().getColor(payType ? R.color.house_list_text_black : R.color.house_list_text_red));
        tx_pay_result_btn.setText(payType ? "回到首页" : "继续缴费");
        tx_pay_result_btn.setBackground(context.getResources().getDrawable(payType ? R.drawable.shape_pay_result_success : R.drawable.shape_pay_result_faile));
        tx_pay_result_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onPayResultType(payType);
                }
            }
        });
    }


    public interface OnPayResultListener {
        void onPayResultType(boolean result);
    }

    public void drawableText(TextView textView, int res) {
        Drawable drawable = context.getResources().getDrawable(res);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
    }

}
