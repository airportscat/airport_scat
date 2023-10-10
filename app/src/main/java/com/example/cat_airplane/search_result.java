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

public class search_result extends AppCompatActivity {
    EditText search;
    TextView search_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        search = findViewById(R.id.search);
        search_result = findViewById(R.id.search_result);
        Data d = new Data();

        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        String testData = "file.txt";
        String filePath = getFilesDir() + "/" + testData; // 내부 저장소의 파일 경로
        try{
            FileInputStream in = openFileInput(testData);
            byte[] line = new byte[30];
            in.read(line);
            in.close();
//            BufferedReader reader = new BufferedReader(new FileReader(testData));
//            StringBuilder content = new StringBuilder();
//            String line;
//            while((line=reader.readLine()) != null){
//                content.append(line).append("\n");
//            }
//            reader.close();
//
            String text = new String(line);
            search_result.setText(text);
            Toast.makeText(getApplicationContext(), "불러오기 성공", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "파일 없음", Toast.LENGTH_SHORT).show();
        }
    }
}