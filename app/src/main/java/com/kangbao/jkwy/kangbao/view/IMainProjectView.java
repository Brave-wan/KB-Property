package com.kangbao.jkwy.kangbao.view;

import com.kangbao.jkwy.kangbao.bean.BuildingListBean;
import com.kangbao.jkwy.kangbao.bean.HouseListBean;

import java.util.List;

public interface IMainProjectView {
    void onProjectName(String name);
    void onBuildList(List<BuildingListBean.DataBean.BuildListBean> buildList);

    void onHouseArrearsList(List<HouseListBean.DataBean.HouseArrearsListBean> houseArrearsList);

    void onTokenSuccess(String sessionId);
}
