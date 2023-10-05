package com.example.cat_airplane;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class search_main extends AppCompatActivity {
    ImageButton search_btn;
    MyDBHelper DB;
    SQLiteDatabase sqlDB;
    Cursor result; //테이블에 저장된 행을 참조해 데이터의 값을 가져오는 것
    MyDBHelper dbHelper;

    private ImageButton[] btn_sample = new ImageButton[6];
    private Integer[] btn_id = {R.id.drink, R.id.charger, R.id.food, R.id.cane, R.id.medicine, R.id.lighter};
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);
        DB = new MyDBHelper(this);
        sqlDB = DB.getReadableDatabase();

        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //검색 버튼
        search_btn = findViewById(R.id.search_btn);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = dbHelper.getReadableDatabase(); //db읽기
                result =sqlDB.rawQuery("SELECT * FROM Baggage;", null); //db검색
                if(result.getCount()>0){
                    Intent intent = new Intent(search_main.this, search_result.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "해당 정보는 확인할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //버튼 객체 등록
        for (i = 0; i<btn_id.length; i++){
            btn_sample[i] = (ImageButton) findViewById(btn_id[i]);
        }
        //버튼 이벤트 넣기
        for (i = 0; i<btn_sample.length; i++){
            btn_sample[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //db에서 아이디 일치하는 값 찾기
                    sqlDB = dbHelper.getReadableDatabase();
                    result = sqlDB.rawQuery("SELECT * FROM Baggage WHERE mID = ?;", new String[]{String.valueOf(i)}); // 해당 아이디 값과 일치하는 데이터 조회

                    if (result.moveToFirst()) {
                        // 데이터가 있을 경우 검색 결과 화면으로 이동하고 데이터를 전달
                        Intent intent = new Intent(search_main.this, search_result.class);
                        intent.putExtra("dataId", i); // 데이터 아이디를 전달
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "해당 정보는 확인할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}