package com.example.jiawei.fragmenttabhost;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private LayoutInflater mInflater;
    private FragmentTabHost mTabHost;
    private final Class fragmentArray[] = {ConversationFragment.class, ContactFragment.class, SettingFragment.class};
    private String mTextviewArray[] = {"contact", "conversation", "setting"};
    private int mImageViewArray[] = {R.drawable.tab_conversation, R.drawable.tab_contact, R.drawable.tab_setting};
    private int mTitleArray[] = {R.string.home_conversation_tab, R.string.home_contact_tab, R.string.home_setting_tab};
    private ImageView msgUnread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //包括顶部的黑色系统条

        mInflater = LayoutInflater.from(this);

        initView();
    }

    private void initView() {

        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.contentPanel);
        int fragmentCount = fragmentArray.length;
        for (int i = 0; i < fragmentCount; ++i) {
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.getTabWidget().setDividerDrawable(null);
        }
    }
    private View getTabItemView(int index) {
        View view = mInflater.inflate(R.layout.home_tab, null);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        icon.setImageResource(mImageViewArray[index]);
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(mTitleArray[index]);
        if (index == 0){
            msgUnread = (ImageView) view.findViewById(R.id.tabUnread);
        }
        return view;
    }
}
