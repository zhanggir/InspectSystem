package com.example.administrator.inspectsystem;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.administrator.inspectsystem.base.BaseActivity;
import com.example.administrator.inspectsystem.model.login.assignment.AssignFragment;
import com.example.administrator.inspectsystem.model.login.map.MapFragment;
import com.example.administrator.inspectsystem.model.login.setting.SettingFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toobar_main)
    Toolbar mToolBar;
    @BindView(R.id.title_main)
    TextView mTxtTitle;
    @BindView(R.id.viewpager_main)
    ViewPager mPager;
    List<Fragment> fragmenLists;
    @BindView(R.id.bottombar_main)
    BottomBar mBottomBar;


    @Override
    protected void init(Bundle savedInstanceState) {
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initViewPager();
        createBottomBar(savedInstanceState);
    }

    private void createBottomBar(Bundle savedInstanceState) {
        mBottomBar.setItemsFromMenu(R.menu.buttom_bar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId){
                    case R.id.menu_assignment:
                        mPager.setCurrentItem(0);
                        mTxtTitle.setText("巡查系统");
                        break;
                    case R.id.menu_map:
                        mPager.setCurrentItem(1);
                        mTxtTitle.setText("地图");
                        break;
                    case R.id.menu_setting:
                        mPager.setCurrentItem(2);
                        mTxtTitle.setText("设置");
                        break;
                    default:
                        mPager.setCurrentItem(0);
                        mTxtTitle.setText("巡查系统");
                        break;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, 0xFF5D4037);
        mBottomBar.mapColorForTab(2, "#7B1FA2");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mBottomBar.onSaveInstanceState(outState);
    }

    private void initViewPager() {
        fragmenLists=new ArrayList<>();
        fragmenLists.add(new AssignFragment());
        fragmenLists.add(new MapFragment());
        fragmenLists.add(new SettingFragment());
        mPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmenLists.get(position);
            }

            @Override
            public int getCount() {
                return fragmenLists.size();
            }
        });
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
mBottomBar.selectTabAtPosition(position,true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
