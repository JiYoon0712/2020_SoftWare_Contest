package com.cookandroid.mybook;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context) {

        super(context, "csc", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table diaryTB (data1 text, data2 text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}