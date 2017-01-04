package com.example.jiawei.ormlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by zhang on 2016/7/13.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    public final String DATABASE_PATH =context.getFilesDir() + "/xxxxxx.db";
    private static DatabaseHelper instance;
    private static Context context;

    //暂时写死
    public DatabaseHelper(Context context) {
        super(context, null, null, 1);
    }

    public static synchronized DatabaseHelper getHelper(Context context) {
        DatabaseHelper.context = context;
        if (instance == null) {
            synchronized (DatabaseHelper.class) {
                if (instance == null)
                    instance = new DatabaseHelper(context);
            }
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    @Override
    public synchronized SQLiteDatabase getWritableDatabase() {
        return SQLiteDatabase.openDatabase(DATABASE_PATH, null,
                SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized SQLiteDatabase getReadableDatabase() {
        return SQLiteDatabase.openDatabase(DATABASE_PATH, null,
                SQLiteDatabase.OPEN_READONLY);
    }
}
