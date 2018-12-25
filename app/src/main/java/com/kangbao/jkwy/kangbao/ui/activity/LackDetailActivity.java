package com.kangbao.jkwy.kangbao.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kangbao.jkwy.kangbao.R;

public class LackDetailActivity extends AppCompatActivity {

    private String sessionid,houseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lack_detail);
        initView();
    }

    private void initView() {
        sessionid = getIntent().getStringExtra("sessionid");
        houseId = getIntent().getStringExtra("houseId");
    }
}
