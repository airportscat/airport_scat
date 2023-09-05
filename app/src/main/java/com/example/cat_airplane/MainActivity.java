package com.example.cat_airplane;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Button btnstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

      btnstart = findViewById(R.id.start_btn);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //choose로 화면전환
                Intent intent = new Intent(MainActivity.this,choose.class);
                startActivity(intent);
            }
        });
    }
}