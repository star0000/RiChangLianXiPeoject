package com.example.b.tablayoutfragmentdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp_view)
    ViewPager vpView;

    private String[] channels = {"推荐", "热点", "体育", "娱乐", "社会", "汽车", "教育", "财经", "科技", "游戏"};
    private String[] urlS = {
            "http://ic.snssdk.com/2/article/v25/stream/?count=20&min000",
            "http://ic.snssdk.com/2/article/v25/stre11111",
            "http://ic.snssdk.com/2/article/v25/stre22222",
            "http://ic.snssdk.com/2/article/v25/stre33333",
            "http://ic.snssdk.com/2/article/v25/stre44444",
            "http://ic.snssdk.com/2/article/v25/stre55555",
            "http://ic.snssdk.com/2/article/v25/stre66666",
            "http://ic.snssdk.com/2/article/v25/stre77777",
            "http://ic.snssdk.com/2/article/v25/stre88888",
            "http://ic.snssdk.com/2/article/v25/stre99999"
    };

    private List<ChannelFragment> mViewList = new ArrayList<>();
    private LayoutInflater mInflater;
    private ChannelFragment channerFragment;
    private MyFragmentPageAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mInflater = LayoutInflater.from(this);

        for (int i = 0; i < channels.length; i++) {
            channerFragment = new ChannelFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", channels[i]);
            bundle.putString("url", urlS[i]);
            channerFragment.setArguments(bundle);
            mViewList.add(channerFragment);
            tabs.addTab(tabs.newTab().setText(channels[i]));
        }

        FragmentManager fm = getSupportFragmentManager();
        myAdapter = new MyFragmentPageAdapter(fm, mViewList);
        vpView.setAdapter(myAdapter);
        tabs.setupWithViewPager(vpView);
        tabs.setTabsFromPagerAdapter(myAdapter);


    }

    private class MyFragmentPageAdapter extends FragmentPagerAdapter{

        private List<ChannelFragment> mViewList;

        public MyFragmentPageAdapter(FragmentManager fm , List<ChannelFragment> mViewList) {
            super(fm);
            this.mViewList = mViewList;
        }


        @Override
        public Fragment getItem(int position) {
            return mViewList.get(position);
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return channels[position];
        }
    }
}