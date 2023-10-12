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
    SQLiteDatabase sqlDB;
    Cursor result; //테이블에 저장된 행을 참조해 데이터의 값을 가져오는 것

    private ImageButton[] btn_sample = new ImageButton[6];
    private Integer[] btn_id = {R.id.drink, R.id.charger, R.id.food, R.id.cane, R.id.medicine, R.id.lighter, R.id.txt_ashes, R.id.spray};
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);

        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //버튼 객체 등록
        for (i = 0; i<btn_id.length; i++){
            btn_sample[i] = (ImageButton) findViewById(btn_id[i]);
        }
        //버튼 이벤트 넣기
        for (i = 0; i<btn_sample.length; i++){
            btn_sample[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(search_main.this, search_result.class);
                    startActivity(in);
                }
            });

        }

    }
}