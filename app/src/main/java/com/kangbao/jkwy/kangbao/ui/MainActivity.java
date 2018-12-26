package com.kangbao.jkwy.kangbao.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kangbao.jkwy.kangbao.R;
import com.kangbao.jkwy.kangbao.bean.BuildingListBean;
import com.kangbao.jkwy.kangbao.bean.HouseListBean;
import com.kangbao.jkwy.kangbao.bean.UserInfo;
import com.kangbao.jkwy.kangbao.present.MainPresent;
import com.kangbao.jkwy.kangbao.view.IMainProjectView;

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

    private BaseQuickAdapter<BuildingListBean.DataBean.BuildListBean, BaseViewHolder> adapterBuild;
    private BaseQuickAdapter<HouseListBean.DataBean.HouseArrearsListBean, BaseViewHolder> adapterHouse;
    private MainPresent present;

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
        present = new MainPresent(this, this);
        initAdapter();
        present.getUserInfo();
    }

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

                buildListBeanList.get(position).setSelect(true);
                adapterBuild.notifyDataSetChanged();
                present.getFindOwnerByBuilding(buildListBeanList.get(position).getBuildId());

            }
        });

        adapterHouse.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HouseListBean.DataBean.HouseArrearsListBean bean = (HouseListBean.DataBean.HouseArrearsListBean) adapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, ArrearsListActivity.class);
                intent.putExtra("houseId", bean.getHouseId());
                intent.putExtra("projectName", tvProject.getText().toString().trim());
                startActivity(intent);
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
        buildListBeanList.clear();
        buildList.get(0).setSelect(true);
        buildListBeanList.addAll(buildList);
        adapterBuild.notifyDataSetChanged();
    }

    @Override
    public void onHouseArrearsList(List<HouseListBean.DataBean.HouseArrearsListBean> houseArrearsList) {
        houseArrearsListBeanList.clear();
        houseArrearsListBeanList.addAll(houseArrearsList);
        adapterHouse.notifyDataSetChanged();
    }
}








