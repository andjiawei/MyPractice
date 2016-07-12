package com.example.jiawei.testlocol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView testView = (TextView) findViewById(R.id.hello);
        Locale locale = getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        testView.setText(language);
    }
}
