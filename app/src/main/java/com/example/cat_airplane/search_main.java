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
    private ImageButton btn_spary, btn_ashes, btn_drink, btn_cane, btn_charger, btn_medicine, btn_food, btn_lighter;
    private int i;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);

        btn_spary = findViewById(R.id.spray);
        btn_ashes = findViewById(R.id.ashes);
        btn_drink = findViewById(R.id.drink);
        btn_cane = findViewById(R.id.cane);
        btn_charger = findViewById(R.id.charger);
        btn_medicine = findViewById(R.id.medicine);
        btn_food = findViewById(R.id.food);
        btn_lighter = findViewById(R.id.lighter);

        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //화면 넘기기위한 intent 객체 생성
        intent = new Intent(search_main.this, search_result.class);

        //버튼 객체 등록
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.spray:
                        //스프레이
                        intent.putExtra("baggage", R.raw.spray);
                        break;
                    case R.id.ashes:
                        //유골
                        intent.putExtra("baggage", R.raw.ashes); break;
                    case R.id.drink:
                        //음료수
                        intent.putExtra("baggage", R.raw.drink); break;
                    case R.id.cane:
                        //지팡이
                        intent.putExtra("baggage", R.raw.cane); break;
                    case R.id.charger:
                        //충전기
                        intent.putExtra("baggage", R.raw.charger); break;
                    case R.id.medicine:
                        //약
                        intent.putExtra("baggage", R.raw.medicine); break;
                    case R.id.food:
                        //음식
                        intent.putExtra("baggage", R.raw.food); break;
                    case R.id.lighter:
                        //라이터
                        intent.putExtra("baggage", R.raw.lighter); break;
                }
                startActivity(intent);
            }

        };
        btn_spary.setOnClickListener(clickListener);
        btn_ashes.setOnClickListener(clickListener);
        btn_drink.setOnClickListener(clickListener);
        btn_cane.setOnClickListener(clickListener);
        btn_charger.setOnClickListener(clickListener);
        btn_medicine.setOnClickListener(clickListener);
        btn_food.setOnClickListener(clickListener);
        btn_lighter.setOnClickListener(clickListener);
    }
}