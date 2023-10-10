package com.example.cat_airplane;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Data extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("SearchData", Context.MODE_PRIVATE);
        editor = sp.edit();

        //검색어 저장
        String search = "검색 데이터";
        editor.putString("test", search); //key값, 데이터 내용
        
        //변경 내용 저장
        editor.apply();
    }
}
