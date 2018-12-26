package com.kangbao.jkwy.kangbao.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kangbao.jkwy.kangbao.R;
import com.kangbao.jkwy.kangbao.view.PayDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ArrearsListActivity extends Activity {

    @BindView(R.id.lv_arrears_list)
    RecyclerView lv_arrears_list;
    BaseQuickAdapter<String, BaseViewHolder> adapter;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrears_list);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        lv_arrears_list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_arrears_list, list) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {

                TextView tx_item_total = helper.itemView.findViewById(R.id.tx_item_total);
                TextView tx_item_title = helper.itemView.findViewById(R.id.tx_item_title);
                RecyclerView lv_details = helper.itemView.findViewById(R.id.lv_details);
                List<String> details = new ArrayList<>();
                details.add("");
                details.add("");
                details.add("");
                details.add("");
                details.add("");
                lv_details.setLayoutManager(new LinearLayoutManager(ArrearsListActivity.this));
                lv_details.setAdapter(new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_arrears_details, details) {
                    @Override
                    protected void convert(BaseViewHolder helper, String item) {

                    }
                });
            }
        };
        lv_arrears_list.setAdapter(adapter);
    }


    @OnClick({R.id.img_arrears_we_pay, R.id.img_arrears_ali_pay, R.id.img_arrears_back})
    public void OnClick(View view) {
        PayDialog dialog = null;
        switch (view.getId()) {
            case R.id.img_arrears_we_pay:
                dialog = new PayDialog(this, "微信");
                dialog.show();
                break;
            case R.id.img_arrears_ali_pay:
                dialog = new PayDialog(this, "支付宝");
                dialog.show();
                break;

            case R.id.img_arrears_back:
                finish();
                break;
        }

    }
}
