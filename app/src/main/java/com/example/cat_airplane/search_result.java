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

public class search_result extends AppCompatActivity {
    Cursor cursor;
    SQLiteDatabase sqlDB;
    EditText search;
    TextView search_result;
    MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        search_result = findViewById(R.id.search_result);

        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        dbHelper = new MyDBHelper(this);

        //전달한 데이터 아이디 받기
        int dataId = getIntent().getIntExtra("dataId", -1);

        if (dataId != -1) {
            // 데이터 조회
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM Baggage WHERE mID = ?;", new String[]{String.valueOf(dataId)});
        }

        //텍스트화
        if(cursor.moveToFirst()){
            String name = cursor.getString(1); //name
            String result = cursor.getString(2); //result

            search_result.setText(name);
            //result textview 만들어서 텍스트 넣기

        }
    }
}