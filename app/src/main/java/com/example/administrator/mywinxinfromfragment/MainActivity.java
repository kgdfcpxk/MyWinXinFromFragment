package com.example.administrator.mywinxinfromfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        FragmentWinXin winXin = new FragmentWinXin();
        setSelect(winXin);
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
                setSelect(new FragmentWinXin());
                break;
            case R.id.id_tab_friend:
                mImgTabFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                setSelect(new FragmentFriend());
                break;
            case R.id.id_tab_contact:
                mImgTabContact.setImageResource(R.drawable.tab_address_pressed);
                setSelect(new FragmentContact());
                break;
            case R.id.id_tab_settings:
                mImgTabSettings.setImageResource(R.drawable.tab_settings_pressed);
                setSelect(new FragmentSettings());
                break;
        }
    }
    private void setSelect(Fragment fragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.id_tab_frame_layout,fragment).commit();
    }

    private void resetImg() {
        mImgTabWinXin.setImageResource(R.drawable.tab_weixin_normal);
        mImgTabFriend.setImageResource(R.drawable.tab_find_frd_normal);
        mImgTabContact.setImageResource(R.drawable.tab_address_normal);
        mImgTabSettings.setImageResource(R.drawable.tab_settings_normal);
    }
}
