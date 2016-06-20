package com.example.jiawei.loginsoftinput;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements InputMethodRelativeLayout.OnSizeChangedListenner {

    private ImageView imageView;
    private InputMethodRelativeLayout layout;
    private ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.iv_portrait);
        layout = (InputMethodRelativeLayout) findViewById(R.id.loginpage) ;
        scroll = (ScrollView) findViewById(R.id.scrollView) ;
        layout.setOnSizeChangedListenner(this) ;

    }

    @Override
    public void onSizeChange(boolean flag, int w, int h) {
        if(flag){//键盘弹出时
            imageView.setVisibility(View.GONE) ;
//            scroll.scrollTo(0, -200);
        }else{ //键盘隐藏时
            imageView.setVisibility(View.VISIBLE) ;
//            scroll.scrollTo(0, 200);
        }
    }
}
