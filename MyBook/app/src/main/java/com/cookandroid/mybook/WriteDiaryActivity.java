package com.cookandroid.mybook;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class WriteDiaryActivity extends Activity {
    private DBManager dbmgr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writediary);
        //Button btn = findViewById(R.id.button_store);
        //btn.setOnClickListener(this);
    }
    public void saveData(View v){
        EditText et_name = findViewById(R.id.edit_name);
        String diary_date = et_name.getText().toString();

        EditText et_name2 = findViewById(R.id.edit_diary);
        String diary_content = et_name2.getText().toString();
        try{
            dbmgr = new DBManager(this);
            SQLiteDatabase sdb;
            sdb = dbmgr.getWritableDatabase();
            sdb.execSQL("insert into diaryTB values('" + diary_date + "','" + diary_content + "');");
            dbmgr.close();
        } catch (SQLiteException e){
        }
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }
}