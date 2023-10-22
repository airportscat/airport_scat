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
import java.io.InputStreamReader;

public class search_result extends AppCompatActivity {
    TextView search_result;
    Intent intent;
    int baggage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        search_result = findViewById(R.id.search_result);

        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        intent = getIntent();
        //메인에서 받아온 키 값으로 데이터 불러오기
        baggage = intent.getExtras().getInt("baggage");

        try {
            // 데이터 파일 불러오기
//            InputStream inputStream = getAssets().open(baggage+".txt");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//
//            //데이터 읽기
//            while ((line = reader.readLine()) != null) {
//                stringBuilder.append(line).append("\n");
//            }
//            reader.close();
            InputStream input = getResources().openRawResource(baggage);
            byte[] txt = new byte[input.available()];
            input.read(txt);
            input.close();

            Toast.makeText(getApplicationContext(), "불러오기 성공", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //화면에 텍스트 데이터 보이기
        search_result.setText(baggage);
    }
}