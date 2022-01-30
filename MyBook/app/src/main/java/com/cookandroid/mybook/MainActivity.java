package com.cookandroid.mybook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //첫 번째 탭
        TabHost tabhost = getTabHost();
        TabHost.TabSpec spec; //재사용할수있다.

        Intent intent = new Intent().setClass(this, ShowMyData.class);

        spec = tabhost.newTabSpec("show").setIndicator("독서목록").setContent(intent);
        tabhost.addTab(spec);

        //두 번째 탭
        intent = new Intent().setClass(this, WriteDiaryActivity.class);
        spec = tabhost.newTabSpec("write").setIndicator("독후감 작성").setContent(intent);
        tabhost.addTab(spec);

        //세 번째 탭
        intent = new Intent().setClass(this, AppHelpActivity.class);
        spec = tabhost.newTabSpec("help").setIndicator("도서 구매 링크").setContent(intent);
        tabhost.addTab(spec);

        //처음 앱 실행시 탭 활성화 지정하기
        tabhost.setCurrentTab(0);
    }
}