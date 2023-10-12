package com.example.cat_airplane;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class search_result extends AppCompatActivity {
    TextView search_result;
    Intent intent;
    String baggage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        search_result = findViewById(R.id.search_result);

        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        intent = getIntent();
        baggage = intent.getExtras().getString("baggage"); //메인에서 받아온 키 값으로 데이터 불러오기

        try{
            InputStream input = getResources().openRawResource(baggage);  //아이디좀받아와주라...
            byte[] txt = new byte[input.available()];
            input.read(txt);
            String text = new String(txt);
            search_result.setText(text);
            input.close();

            Toast.makeText(getApplicationContext(), "불러오기 성공", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "파일 없음", Toast.LENGTH_SHORT).show();
        }
    }
}