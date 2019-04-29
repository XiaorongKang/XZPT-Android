package com.djylrz.xzpt.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.djylrz.xzpt.Activity.AddRecruitmentActivity;
import com.djylrz.xzpt.R;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class FragmentComHome extends Fragment {
    private Context mContext = getContext();
    private String[] mTitles = {"已发布岗位","已停招岗位"};
    private View mDecorView;
    private SegmentTabLayout mTabLayout;
    private ArrayList<Fragment> mFragments;
    private Toolbar toolbar;//导航栏
    private TextView textViewAdd;//导航栏发布按钮
    private static final String TAG = "FragmentComHome";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mFragments = new ArrayList<>();
        mDecorView = inflater.inflate(R.layout.fragment6_com_home,container,false);
        toolbar = mDecorView.findViewById(R.id.home_toolbar);
        toolbar.setTitle("");
        textViewAdd = mDecorView.findViewById(R.id.tv_toolbar_add);
        textViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddRecruitmentActivity.class);
                startActivity(intent);
            }
        });
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }

        mTabLayout = mDecorView.findViewById(R.id.tl);
        tl();
        return mDecorView;
    }
    private void tl() {
        final ViewPager vp = mDecorView.findViewById(R.id.vp);
        vp.setAdapter(new MyPagerAdapter(this.getActivity().getSupportFragmentManager()));
        mTabLayout.setTabData(mTitles);
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp.setCurrentItem(1);
    }
    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}