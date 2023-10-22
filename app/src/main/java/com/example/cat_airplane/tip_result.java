package com.example.cat_airplane;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class tip_result extends AppCompatActivity {
    Intent intent;
    String tipType;  //무슨팁
    TextView tipText;  //상단에 표시할 팁 이름
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_result);
        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        intent = getIntent();
        tipType = intent.getExtras().getString("tip");
        tipText = findViewById(R.id.tipText);
        
        //ArrayAdapter에 넣을 데이터 리스트
        List<String> dataList = new ArrayList<>();
        
        tipText.setText(tipType);  //팁 설정
        
        try {
            InputStream inputStream = getAssets().open(tipType+" 제목.txt");  //assets 폴더에서 텍스트 파일 열기
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String a = "";

            // "/"로 텍스트를 나누어 리스트에 추가
            while ((line = reader.readLine()) != null) {
                if(line.equals("/")) {
                    dataList.add(a);
                    a = "";  //초기화
                }else {
                    a += line;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 리스트뷰 초기화
        ListView listView = findViewById(R.id.listView);

        // ArrayAdapter를 사용하여 데이터를 리스트뷰에 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);

        // 리스트뷰에 어댑터 설정
        listView.setAdapter(adapter);

        // 리스트뷰 항목 클릭 리스너 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // 클릭한 항목을 가져옴
                String selectedItem = (String) adapterView.getItemAtPosition(position);

                // 다음 화면으로 전달할 정보를 담은 인텐트 생성
                Intent detailIntent = new Intent(tip_result.this, TipDetailActivity.class);
                detailIntent.putExtra("title", selectedItem);
                detailIntent.putExtra("tip", tipType);
                startActivity(detailIntent);
            }
        });
    }
}