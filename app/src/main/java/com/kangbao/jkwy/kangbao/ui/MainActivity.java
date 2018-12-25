package com.kangbao.jkwy.kangbao.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adtech.sys.util.Encrypt;
import com.adtech.sys.util.MD5Util;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kangbao.jkwy.kangbao.R;
import com.kangbao.jkwy.kangbao.bean.BuildingListBean;
import com.kangbao.jkwy.kangbao.bean.HouseListBean;
import com.kangbao.jkwy.kangbao.bean.LoginInfo;
import com.kangbao.jkwy.kangbao.bean.LoginInfoBean;
import com.kangbao.jkwy.kangbao.bean.OpenIdBean;
import com.kangbao.jkwy.kangbao.bean.SessionBean;
import com.kangbao.jkwy.kangbao.bean.UserInfo;
import com.kangbao.jkwy.kangbao.present.MainPresent;
import com.kangbao.jkwy.kangbao.ui.activity.LackDetailActivity;
import com.kangbao.jkwy.kangbao.util.AppKeyConfig;
import com.kangbao.jkwy.kangbao.util.CommonlyUtils;
import com.kangbao.jkwy.kangbao.util.GsonUtils;
import com.kangbao.jkwy.kangbao.util.NetWorksUtils;
import com.kangbao.jkwy.kangbao.util.StringDialogCallback;
import com.kangbao.jkwy.kangbao.util.ToastUtils;
import com.kangbao.jkwy.kangbao.util.UrlConfig;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_project)
    TextView tvProject;
    @BindView(R.id.recyclerView_building)
    RecyclerView recyclerViewBuilding;
    @BindView(R.id.recyclerView_house)
    RecyclerView recyclerViewHouse;

    private BaseQuickAdapter<BuildingListBean.DataBean.BuildListBean, BaseViewHolder> adapterBuild;
    private BaseQuickAdapter<HouseListBean.DataBean.HouseArrearsListBean, BaseViewHolder> adapterHouse;
    private UserInfo userInfo = new UserInfo();
    MainPresent present;
    private String projectId = "209", sessionid = "b8ec59b0ff6940d3b42eba145c20dd8c", projectName;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        buildListBeanList.clear();
        houseArrearsListBeanList.clear();
        buildListBeanList.add(new BuildingListBean.DataBean.BuildListBean());
        buildListBeanList.add(new BuildingListBean.DataBean.BuildListBean());
        buildListBeanList.add(new BuildingListBean.DataBean.BuildListBean());
        buildListBeanList.add(new BuildingListBean.DataBean.BuildListBean());
        buildListBeanList.add(new BuildingListBean.DataBean.BuildListBean());
        houseArrearsListBeanList.add(new HouseListBean.DataBean.HouseArrearsListBean());
        houseArrearsListBeanList.add(new HouseListBean.DataBean.HouseArrearsListBean());
        houseArrearsListBeanList.add(new HouseListBean.DataBean.HouseArrearsListBean());
        houseArrearsListBeanList.add(new HouseListBean.DataBean.HouseArrearsListBean());
        houseArrearsListBeanList.add(new HouseListBean.DataBean.HouseArrearsListBean());
        houseArrearsListBeanList.add(new HouseListBean.DataBean.HouseArrearsListBean());
        houseArrearsListBeanList.add(new HouseListBean.DataBean.HouseArrearsListBean());
        houseArrearsListBeanList.add(new HouseListBean.DataBean.HouseArrearsListBean());
        houseArrearsListBeanList.add(new HouseListBean.DataBean.HouseArrearsListBean());

        present = new MainPresent(this);

        initAdapter();

        present.getUserInfo();
    }

    private void initAdapter() {

        adapterBuild = new BaseQuickAdapter<BuildingListBean.DataBean.BuildListBean, BaseViewHolder>(R.layout.item_lack_list, buildListBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, BuildingListBean.DataBean.BuildListBean item) {
                TextView textView = helper.itemView.findViewById(R.id.tv_name);
                textView.setText("hello word");

            }

        };
        adapterHouse = new BaseQuickAdapter<HouseListBean.DataBean.HouseArrearsListBean, BaseViewHolder>(R.layout.item_lack_list, houseArrearsListBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, HouseListBean.DataBean.HouseArrearsListBean item) {
                TextView textView = helper.itemView.findViewById(R.id.tv_name);
                textView.setText("hello word");
            }
        };
        recyclerViewBuilding.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHouse.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewBuilding.setAdapter(adapterBuild);
        recyclerViewHouse.setAdapter(adapterHouse);

        adapterBuild.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(MainActivity.this,ArrearsListActivity.class));
            }
        });

        adapterHouse.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(MainActivity.this,ArrearsListActivity.class));

            }
        });
    }

    private List<BuildingListBean.DataBean.BuildListBean> buildListBeanList = new ArrayList<>();
    private List<HouseListBean.DataBean.HouseArrearsListBean> houseArrearsListBeanList = new ArrayList<>();

}








