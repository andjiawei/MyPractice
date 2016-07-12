package com.example.jiawei.mpchartdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.lineChart).setOnClickListener(this);
        findViewById(R.id.pieChart).setOnClickListener(this);
        findViewById(R.id.barChart).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.lineChart:
                startActivity(new Intent(this,LineActivity.class));
                break;
            case R.id.pieChart:
                startActivity(new Intent(this,PieActivity.class));
                break;
            case R.id.barChart:

                break;
        }

    }
}
