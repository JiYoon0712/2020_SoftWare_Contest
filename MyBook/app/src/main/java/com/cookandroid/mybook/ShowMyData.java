package com.cookandroid.mybook;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ShowMyData extends Activity {

    int nowData = 0;
    Cursor cursor;
    TextView date,t1;
    String diary_content, diary_date;
    int numburOfData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        date = (TextView) findViewById(R.id.date);
        t1 = (TextView) findViewById(R.id.t1);

        try{
            DBManager dbmgr = new DBManager(this);

            SQLiteDatabase sdb = dbmgr.getReadableDatabase();

            cursor = sdb.query("diaryTB", null, null, null, null, null, null);

            numburOfData = cursor.getCount();
            cursor.moveToFirst();

            if(numburOfData == 0) nowData = 0;
            else nowData =1;

            if(cursor.getCount() > 0) {
                diary_content = cursor.getString(0);
                diary_date = cursor.getString(1);
            }

            cursor.close();
            dbmgr.close();

        } catch (SQLException e) {
        }

        date.setText(diary_content);
        t1.setText(diary_date);

    }

    //다음버튼 클릭시
    public void nextData(View v) {

        try{
            DBManager dbmgr = new DBManager(this);

            SQLiteDatabase sdb = dbmgr.getReadableDatabase();

            cursor = sdb.query("diaryTB", null, null, null, null, null, null);

            if (numburOfData == 0) nowData = 0;

            if (cursor.getCount() > 0 && nowData <= numburOfData) {

                nowData += 1;

                if (nowData >= numburOfData) nowData = numburOfData;

                cursor.moveToPosition(nowData -1);

                diary_content = cursor.getString(0);
                diary_date = cursor.getString(1);
            }

            cursor.close();
            dbmgr.close();
        } catch (SQLException e){
        }

        date.setText(diary_content);
        t1.setText(diary_date);
    }

    //이전버튼 클릭시
    public void previousData(View v) {

        try{
            DBManager dbmgr = new DBManager(this);

            SQLiteDatabase sdb = dbmgr.getReadableDatabase();

            cursor = sdb.query("diaryTB", null, null, null, null, null, null);

            if (numburOfData == 0) nowData = 0;

            if (cursor.getCount() > 0 && nowData > 1) {

                nowData -= 1;

                if (nowData <= 1) nowData = 1;

                cursor.moveToPosition(nowData -1);

                diary_content = cursor.getString(0);
                diary_date = cursor.getString(1);
            }

            cursor.close();
            dbmgr.close();
        } catch (SQLException e){
        }

        date.setText(diary_content);
        t1.setText(diary_date);
    }

    //삭제버튼 클릭시
    public void deleteData(View v) {
        if(numburOfData >= 1)

            try{
                DBManager dbmgr = new DBManager(this);

                SQLiteDatabase sdb;

                sdb = dbmgr.getWritableDatabase();
                cursor = sdb.query("diaryTB", null, null, null, null, null, null);
                cursor.moveToPosition(nowData - 1);
                diary_content = cursor.getString(0);
                nowData -= 1;
                String sql = String.format("DELETE FROM diaryTB WHERE data1 = '%s'", diary_content);

                sdb.execSQL(sql);

                cursor.close();
                dbmgr.close();
                Toast.makeText(this, "삭제가 완료되었습니다.", Toast.LENGTH_SHORT).show();
            } catch (SQLException e){
            }

    }

    //수정버튼 클릭시
    public void modifyData(View v) {
        Intent it = new Intent();
        it = new Intent(this, ModifyMyData.class);
        String msg = nowData + "";
        it.putExtra("it_name", msg);

        startActivity(it);
        finish();
    }

}
