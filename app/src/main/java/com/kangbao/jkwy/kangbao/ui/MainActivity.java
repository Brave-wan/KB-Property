package com.kangbao.jkwy.kangbao.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kangbao.jkwy.kangbao.R;
import com.kangbao.jkwy.kangbao.bean.BuildingListBean;
import com.kangbao.jkwy.kangbao.bean.HouseListBean;
import com.kangbao.jkwy.kangbao.bean.UserInfo;
import com.kangbao.jkwy.kangbao.present.MainPresent;
import com.kangbao.jkwy.kangbao.util.AppKeyConfig;
import com.kangbao.jkwy.kangbao.view.IMainProjectView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainProjectView {

    @BindView(R.id.tv_project)
    TextView tvProject;
    @BindView(R.id.recyclerView_building)
    RecyclerView recyclerViewBuilding;
    @BindView(R.id.recyclerView_house)
    RecyclerView recyclerViewHouse;
    @BindView(R.id.smart_house)
    SmartRefreshLayout smart_house;
    @BindView(R.id.smart_lou)
    SmartRefreshLayout smart_lou;
    @BindView(R.id.img_back)
    ImageView img_back;

    private BaseQuickAdapter<BuildingListBean.DataBean.BuildListBean, BaseViewHolder> adapterBuild;
    private BaseQuickAdapter<HouseListBean.DataBean.HouseArrearsListBean, BaseViewHolder> adapterHouse;
    private MainPresent present;

    @Override
    public void onResume() {
        super.onResume();
        present.getUserInfo();
        buildListBeanList.clear();
        houseArrearsListBeanList.clear();
    }

    /**
     * am start -n com.kangbao.jkwy.kangbao/.ui.MainActivity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        present = new MainPresent(this, this);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initAdapter();
    }


    private String LouNum = null;

    private void initAdapter() {
        adapterBuild = new BaseQuickAdapter<BuildingListBean.DataBean.BuildListBean, BaseViewHolder>(R.layout.item_lack_list, buildListBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, BuildingListBean.DataBean.BuildListBean item) {
                TextView textView = helper.itemView.findViewById(R.id.tv_name);
                textView.setText(item.getBuildName());
                textView.setBackgroundColor(getResources().getColor(item.isSelect() ? R.color.house_list_bg : R.color.ip_text_primary_inverted));
            }
        };

        adapterHouse = new BaseQuickAdapter<HouseListBean.DataBean.HouseArrearsListBean, BaseViewHolder>(R.layout.item_lack_list, houseArrearsListBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, HouseListBean.DataBean.HouseArrearsListBean item) {
                TextView textView = helper.itemView.findViewById(R.id.tv_name);
                textView.setText(item.getHouseName());
            }
        };
        recyclerViewBuilding.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHouse.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewBuilding.setAdapter(adapterBuild);
        recyclerViewHouse.setAdapter(adapterHouse);
        adapterBuild.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                for (BuildingListBean.DataBean.BuildListBean item : buildListBeanList) {
                    item.setSelect(false);
                }
                houseArrearsListBeanList.clear();
                buildListBeanList.get(position).setSelect(true);
                adapterBuild.notifyDataSetChanged();
                housePage = 1;
                LouNum = buildListBeanList.get(position).getBuildId();
                present.getFindOwnerByBuilding(LouNum, housePage);

            }
        });

        adapterHouse.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HouseListBean.DataBean.HouseArrearsListBean bean = (HouseListBean.DataBean.HouseArrearsListBean) adapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, ArrearsListActivity.class);
                intent.putExtra("houseId", bean.getHouseId());
                intent.putExtra("projectName", tvProject.getText().toString().trim());
                intent.putExtra("title", bean.getHouseName());
                startActivity(intent);
            }
        });
        initLouSmart();
    }

    private void initLouSmart() {
        smart_lou.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                String sessionId = AppKeyConfig.getBuildingKey(MainActivity.this);
                buildListBeanList.clear();
                page = 1;
                LogUtils.i("page:" + page);
                present.getBuilding(sessionId, page);
                smart_lou.finishRefresh(2000);
            }
        });
        smart_lou.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                String sessionId = AppKeyConfig.getBuildingKey(MainActivity.this);
                page++;
                LogUtils.i("page:" + page);
                present.getBuilding(sessionId, page);
                smart_lou.finishLoadmore(2000);
            }
        });

        smart_house.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                houseArrearsListBeanList.clear();
                housePage = 1;
                present.getFindOwnerByBuilding(LouNum, housePage);
                smart_house.finishRefresh(2000);
            }
        });
        smart_house.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                housePage++;
                present.getFindOwnerByBuilding(LouNum, housePage);
                smart_house.finishLoadmore(2000);
            }
        });
    }

    private List<BuildingListBean.DataBean.BuildListBean> buildListBeanList = new ArrayList<>();
    private List<HouseListBean.DataBean.HouseArrearsListBean> houseArrearsListBeanList = new ArrayList<>();

    @Override
    public void onProjectName(String name) {
        tvProject.setText(name);
    }

    @Override
    public void onBuildList(List<BuildingListBean.DataBean.BuildListBean> buildList) {
        buildListBeanList.addAll(buildList);
        buildListBeanList.get(0).setSelect(true);
        adapterBuild.notifyDataSetChanged();
    }

    @Override
    public void onHouseArrearsList(List<HouseListBean.DataBean.HouseArrearsListBean> houseArrearsList) {

        houseArrearsListBeanList.addAll(houseArrearsList);
        adapterHouse.notifyDataSetChanged();
    }

    private int page = 1;
    private int housePage = 1;

    @Override
    public void onTokenSuccess(String sessionId) {
        present.getBuilding(sessionId, page);
    }
}








