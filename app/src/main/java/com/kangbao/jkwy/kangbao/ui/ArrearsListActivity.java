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
import com.kangbao.jkwy.kangbao.bean.ArrearsListBean;
import com.kangbao.jkwy.kangbao.present.ArrearsListPresent;
import com.kangbao.jkwy.kangbao.view.IArrearsListView;
import com.kangbao.jkwy.kangbao.view.PayDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ArrearsListActivity extends Activity implements IArrearsListView {

    @BindView(R.id.lv_arrears_list)
    RecyclerView lv_arrears_list;
    @BindView(R.id.tx_arrears_name)
    TextView tx_arrears_name;
    @BindView(R.id.tx_arrears_total_money)
    TextView tx_arrears_total_money;
    @BindView(R.id.tx_arrears_phone)
    TextView tx_arrears_phone;
    @BindView(R.id.tv_project)
    TextView tv_project;
    BaseQuickAdapter<ArrearsListBean.DataBean.DetailListBean, BaseViewHolder> adapter;
    List<String> list = new ArrayList<>();
    List<ArrearsListBean.DataBean.DetailListBean> arrearsList = new ArrayList<>();
    private String houseId;
    private ArrearsListPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrears_list);
        ButterKnife.bind(this);
        houseId = getIntent().getStringExtra("houseId");
        present = new ArrearsListPresent(this, this);
        tv_project.setText(getIntent().getStringExtra("projectName"));
        initView();
    }

    private void initView() {


        lv_arrears_list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BaseQuickAdapter<ArrearsListBean.DataBean.DetailListBean, BaseViewHolder>(R.layout.item_arrears_list, arrearsList) {
            @Override
            protected void convert(BaseViewHolder helper, ArrearsListBean.DataBean.DetailListBean item) {

                TextView tx_item_total = helper.itemView.findViewById(R.id.tx_item_total);
                final TextView tx_item_title = helper.itemView.findViewById(R.id.tx_item_title);
                RecyclerView lv_details = helper.itemView.findViewById(R.id.lv_details);
                tx_item_title.setText(item.getMouth());
                tx_item_total.setText("总计: ¥ " + item.getAmount());
                if (item.getTypeList() != null && item.getTypeList().size() > 0) {
                    lv_details.setLayoutManager(new LinearLayoutManager(ArrearsListActivity.this));
                    lv_details.setAdapter(new BaseQuickAdapter<ArrearsListBean.DataBean.DetailListBean.TypeListBean, BaseViewHolder>(R.layout.item_arrears_details, item.getTypeList()) {
                        @Override
                        protected void convert(BaseViewHolder helper, ArrearsListBean.DataBean.DetailListBean.TypeListBean item) {
                            TextView tx_arrears_title = helper.itemView.findViewById(R.id.tx_arrears_title);
                            TextView tx_arrears_money = helper.itemView.findViewById(R.id.tx_arrears_money);
                            tx_arrears_title.setText(item.getChargeName());
                            tx_arrears_money.setText("¥ " + item.getThisAmount());
                        }
                    });
                }
            }
        };
        lv_arrears_list.setAdapter(adapter);

        present.getFindArrearsDetails(houseId);
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

    @Override
    public void onArrearsListBean(ArrearsListBean.DataBean detailList) {
        arrearsList.clear();
        arrearsList.addAll(detailList.getDetailList());
        adapter.notifyDataSetChanged();
        tx_arrears_total_money.setText("¥ " + detailList.getTotal());
        tx_arrears_name.setText(detailList.getOwnerName());
        tx_arrears_phone.setText(detailList.getOwnerPhone());
    }
}
