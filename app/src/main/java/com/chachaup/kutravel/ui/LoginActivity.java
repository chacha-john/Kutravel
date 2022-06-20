package com.chachaup.kutravel.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.chachaup.kutravel.R;
import com.chachaup.kutravel.adapters.LoginAdapter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.tabLayout) TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private LoginAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        TabLayout.Tab firstTab = mTabLayout.newTab();
        firstTab.setText("Login");
        mTabLayout.addTab(firstTab);

        TabLayout.Tab secondTab = mTabLayout.newTab();
        secondTab.setText("Create Account");
        mTabLayout.addTab(secondTab);

        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mAdapter = new LoginAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}