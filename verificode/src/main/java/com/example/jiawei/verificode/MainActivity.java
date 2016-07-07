package com.example.jiawei.verificode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iamgeview = (ImageView) findViewById(R.id.imageView);
        CodeUtils instance = CodeUtils.getInstance();
        Bitmap bitmap = instance.createBitmap();
        iamgeview.setImageBitmap(bitmap);

        TextView textView= (TextView) findViewById(R.id.textView);
        textView.setText(instance.getCode());
    }
}
