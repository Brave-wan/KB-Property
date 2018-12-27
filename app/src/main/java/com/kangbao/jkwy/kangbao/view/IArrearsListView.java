package com.kangbao.jkwy.kangbao.view;

import com.kangbao.jkwy.kangbao.bean.ArrearsListBean;
import com.kangbao.jkwy.kangbao.bean.TwoCodePayBean;

import java.util.List;

public interface IArrearsListView {

    void onArrearsListBean(ArrearsListBean.DataBean detailList);

    void OnCodeUrl(TwoCodePayBean.DataBean code_url,String money);

    void onPayResult(boolean b);
}
