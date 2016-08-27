package com.example.mytab03;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLinearTabWinXin;
    private LinearLayout mLinearTabFriend;
    private LinearLayout mLinearTabContact;
    private LinearLayout mLinearTabSettings;
    private ImageView mImgTabWinXin;
    private ImageView mImgTabFriend;
    private ImageView mImgTabContact;
    private ImageView mImgTabSettings;
    private List<Fragment> mWinXinList = new ArrayList<>();
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initData();
        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mWinXinList.get(position);
            }

            @Override
            public int getCount() {
                return mWinXinList.size();
            }
        };
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetImg();
                switch (position) {
                    case 0:
                        mImgTabWinXin.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        mImgTabFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        mImgTabContact.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        mImgTabSettings.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                }
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        mWinXinList.add(new FragmentWinXin());
        mWinXinList.add(new FragmentContact());
        mWinXinList.add(new FragmentFriend());
        mWinXinList.add(new FragmentSettings());
    }

    private void initEvent() {
        mLinearTabWinXin.setOnClickListener(MainActivity.this);
        mLinearTabFriend.setOnClickListener(MainActivity.this);
        mLinearTabContact.setOnClickListener(MainActivity.this);
        mLinearTabSettings.setOnClickListener(MainActivity.this);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        // ViewPager
        mViewPager = (ViewPager) findViewById(R.id.id_tab_view_pager);
        // LinearLayout
        mLinearTabWinXin = (LinearLayout) findViewById(R.id.id_tab_winxin);
        mLinearTabFriend = (LinearLayout) findViewById(R.id.id_tab_friend);
        mLinearTabContact = (LinearLayout) findViewById(R.id.id_tab_contact);
        mLinearTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);
        // ImageView
        mImgTabWinXin = (ImageView) findViewById(R.id.id_tab_winxin_img);
        mImgTabFriend = (ImageView) findViewById(R.id.id_tab_friend_img);
        mImgTabContact = (ImageView) findViewById(R.id.id_tab_contact_img);
        mImgTabSettings = (ImageView) findViewById(R.id.id_tab_settings_img);
    }

    @Override
    public void onClick(View view) {
        resetImg();
        switch (view.getId()) {
            case R.id.id_tab_winxin:
                mImgTabWinXin.setImageResource(R.drawable.tab_weixin_pressed);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.id_tab_friend:
                mImgTabFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.id_tab_contact:
                mImgTabContact.setImageResource(R.drawable.tab_address_pressed);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.id_tab_settings:
                mImgTabSettings.setImageResource(R.drawable.tab_settings_pressed);
                mViewPager.setCurrentItem(3);
                break;
        }
    }

    private void resetImg() {
        mImgTabWinXin.setImageResource(R.drawable.tab_weixin_normal);
        mImgTabFriend.setImageResource(R.drawable.tab_find_frd_normal);
        mImgTabContact.setImageResource(R.drawable.tab_address_normal);
        mImgTabSettings.setImageResource(R.drawable.tab_settings_normal);
    }
}
