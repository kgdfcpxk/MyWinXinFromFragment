package com.example.mytab04;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Window;

import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private TabPageIndicator mTabPageIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTabPageIndicator = (TabPageIndicator) findViewById(R.id.id_indicator);
        mViewPager = (ViewPager) findViewById(R.id.id_vp_view_pager);
        mViewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        mTabPageIndicator.setViewPager(mViewPager);
    }
}
