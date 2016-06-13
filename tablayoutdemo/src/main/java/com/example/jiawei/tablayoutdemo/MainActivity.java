package com.example.jiawei.tablayoutdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * tablayout 和 viewpager 一个 adapter 就这样
 */
public class MainActivity extends AppCompatActivity {

    TabLayout tablayout;
    ViewPager viewpager;
    private static final String[] DATA = {"AigeStudio", "Aige", "Studio", "Android", "Java", "Design"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablayout = (TabLayout) findViewById(R.id.tl_tab);
        viewpager = (ViewPager) findViewById(R.id.vp_tab);

        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        TabPagerAdapter adapter = new TabPagerAdapter();
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }

    private class TabPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return DATA.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tvContent = new TextView(MainActivity.this);
            tvContent.setText(DATA[position]);
            tvContent.setGravity(Gravity.CENTER);
            container.addView(tvContent, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
            return tvContent;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return DATA[position];
        }
    }
}
