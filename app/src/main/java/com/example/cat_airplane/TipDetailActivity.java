package com.example.cat_airplane;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TipDetailActivity extends AppCompatActivity {
    Intent intent;
    TextView titleText, detailText;
    String tipType, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_detail);
        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        titleText = findViewById(R.id.titleText);
        detailText = findViewById(R.id.detailText);
        intent = getIntent();
        title = intent.getExtras().getString("title");
        tipType = intent.getExtras().getString("tip");  //팁
        titleText.setText(title);  //제목 설정

        String text = "";

        try {
            InputStream inputStream = getAssets().open(tipType+".txt");  //assets 폴더에서 텍스트 파일 열기
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            boolean foundTitle = false;
            // "/"로 텍스트를 나누어 리스트에 추가
            while ((line = reader.readLine()) != null) {
                Log.d("씨발아 타이틀", ": "+title);
                if(title.equals(line)) {
                    foundTitle = true;
                    continue;
                }
                if(foundTitle) {
                    if(line.equals("/")) break;
                    text += line + "\n";
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        detailText.setText(text);
    }
}