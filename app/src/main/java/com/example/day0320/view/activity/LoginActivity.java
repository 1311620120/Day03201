package com.example.day0320.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.day0320.R;

import com.example.day0320.view.fragment.OneFragment;
import com.example.day0320.view.fragment.ThreeFragment;
import com.example.day0320.view.fragment.TwoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        BottomTabBar bar = findViewById(R.id.bar);

        bar.init(getSupportFragmentManager())
                .setTabPadding(30,10,2)
                .setFontSize(0)
                .setImgSize(50,50)
                .addTabItem("首页",R.drawable.tab_home_bottom_shouyes,R.drawable.tab_home_bottom_shouye,OneFragment.class)
                .addTabItem("购物车",R.drawable.tab_home_bottom_gouwuche,R.drawable.tab_home_bottom_gouwuche,TwoFragment.class)
                .addTabItem("我的",R.drawable.tab_home_bottom_wodes,R.drawable.tab_home_bottom_wode,ThreeFragment.class);

    }
}
