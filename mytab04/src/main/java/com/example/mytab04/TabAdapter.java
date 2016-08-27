package com.example.mytab04;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/8/27 0027.
 */
public class TabAdapter extends FragmentPagerAdapter {
    public static String[] TITLES = new String[]
            { "课程", "问答", "求课", "学习", "计划" };
    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        FragFragment fragment = new FragFragment();
        Bundle bundle = new Bundle();
        bundle.putString("pos",String.valueOf(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
