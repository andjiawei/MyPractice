package com.example.jiawei.ormlitedemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            DatabaseHelper helper = DatabaseHelper.getHelper(MainActivity.this);
            try {
                Dao dao = helper.getDao(category.class);
                category category= (category) dao.queryForId(1);
                Log.e("category", "handleMessage: "+category.getEng_name());
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String localMessage = MessageUtils.getLocalMessageDB(MainActivity.this);
                copyDb(localMessage);
                handler.sendEmptyMessage(1);
            }
        }).start();
    }

    public  void copyDb(String dbName) {
        try {
            InputStream inputStream = getAssets().open(dbName);

            File filesDir =getFilesDir();

            File addressDbFile = new File(filesDir, dbName);
            if (addressDbFile.exists() && addressDbFile.length() > 13000) {
                Log.d("....", "addressDbFile.exists");
            } else {

                FileOutputStream fout = new FileOutputStream(addressDbFile);
                int len = -1;
                byte[] buffer = new byte[1024];

                while ((len = inputStream.read(buffer)) != -1) {
                    fout.write(buffer, 0, len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
