package com.kangbao.jkwy.kangbao.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kangbao.jkwy.kangbao.R;

import butterknife.BindView;

public class PayDialog extends Dialog {
    private String title;
    private ImageView image_pay_code;
    private Bitmap bitmap;
    private TextView tx_pay_type, tx_money;
    private String money;
    private Button btn_pay_ok;

    public PayDialog(Context context, String payType, Bitmap bitmap, String money) {
        super(context, R.style.DialogTheme);
        this.title = payType;
        this.bitmap = bitmap;
        this.money=money;
    }


    private OnPayDailogListener listener;

    public void setOnPayDailogListener(OnPayDailogListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pay);
        image_pay_code = findViewById(R.id.image_pay_code);
        tx_pay_type = findViewById(R.id.tx_pay_type);
        btn_pay_ok = findViewById(R.id.btn_pay_ok);

        tx_money = findViewById(R.id.tx_money);
        image_pay_code.setImageBitmap(bitmap);
        tx_pay_type.setText(title);
        tx_money.setText("支付:"+money);

        btn_pay_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onPayOK();
                }
            }
        });
    }


    public interface OnPayDailogListener {
        void onPayOK();
    }

}
