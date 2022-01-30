package com.cookandroid.mybook;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class AppHelpActivity extends Activity {

    Button btnKyobo,btnYes24,btnInterpark,btnAladin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TextView textview = new TextView(this);
//        textview.setTextSize(20);
//        textview.setText("나만의 독서록" + "\n" + "만든이 : 비스무리");
//        setContentView(textview);

        setContentView(R.layout.link);


        btnKyobo=findViewById(R.id.btnKyobo);
        btnYes24= findViewById(R.id.btnYes24);
        btnInterpark=findViewById(R.id.btnInterpark);
        btnAladin=findViewById(R.id.btnAladin);


        //교보버튼 클릭시
        btnKyobo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "교보문고로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kyobobook.co.kr/index.laf"));
                startActivity(mIntent);
            }
        });

        //Yes24 클릭시
        btnYes24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Yes24로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yes24.com/main/default.aspx"));
                startActivity(mIntent);
            }
        });

        //인터파크 클릭시
        btnInterpark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "인터파크로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://book.interpark.com/bookPark/html/book.html"));
                startActivity(mIntent);
            }
        });

        //알라딘 클릭시
        btnAladin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "알라딘으로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/home/welcome.aspx"));
                startActivity(mIntent);
            }
        });
    }
}