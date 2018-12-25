package com.kangbao.jkwy.kangbao.util;

import com.google.gson.Gson;
import com.kangbao.jkwy.kangbao.bean.PageInfo;



public class CommonConfig {
    public static String pageInfo(int page) {
        PageInfo info = new PageInfo();
        info.setCurrentPage(page);
        info.setOrder("asc");
        info.setPageSize(20);
        String pageStr = new Gson().toJson(info);
        return pageStr;
    }



}
