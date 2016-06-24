package com.example.jiawei.fadingactionbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import manuelpeinado.fadingactionbar.FadingActionBarHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        FadingActionBarHelper helper = new FadingActionBarHelper()
                .actionBarBackground(R.drawable.ab_background)
                .headerLayout(R.layout.header)
                .contentLayout(R.layout.activity_scrollview);
        setContentView(helper.createView(this));
        helper.initActionBar(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

}
