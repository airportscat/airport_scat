package com.example.cat_airplane;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tip_main extends AppCompatActivity {
    ImageButton attraction_button, seat_button,airline_meal_button, airport_food_button,ticket_reservation_button,homeless_button,
            business_button,peak_season_button;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_main);
        //타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //findViewById
        attraction_button = findViewById(R.id.attraction);
        seat_button = findViewById(R.id.seat);
        airline_meal_button = findViewById(R.id.airline_meal);
        airport_food_button = findViewById(R.id.airport_food);
        ticket_reservation_button = findViewById(R.id.ticket_reservation);
        homeless_button = findViewById(R.id.homeless);
        business_button = findViewById(R.id.business);
        peak_season_button = findViewById(R.id.peak_season);

        //클릭 리스너
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.attraction: intent.putExtra("tip","attraction"); break;  //볼거리
                    case R.id.seat: intent.putExtra("tip","seat"); break;  //비행기 좌석
                    case R.id.airline_meal: intent.putExtra("tip","airline_meal"); break;  //기내식
                    case R.id.airportfood: intent.putExtra("tip","airport_food"); break;  //공항 음식
                    case R.id.ticket: intent.putExtra("tip","ticket_reservation"); break;  //항공권 예매
                    case R.id.business: intent.putExtra("tip","business"); break;  //비즈니스
                    case R.id.peak_season: intent.putExtra("tip","peak_seaon"); break;  //비수기 성수기
                }
                intent = new Intent(tip_main.this,tip_result.class);  //팁 결과 화면으로
                startActivity(intent);  //이동
            }
        };

        //모든 버튼에 동일한 클릭리스너 추가
        attraction_button.setOnClickListener(clickListener);
        seat_button.setOnClickListener(clickListener);
        airline_meal_button.setOnClickListener(clickListener);
        airport_food_button.setOnClickListener(clickListener);
        ticket_reservation_button.setOnClickListener(clickListener);
        homeless_button.setOnClickListener(clickListener);
        business_button.setOnClickListener(clickListener);
        peak_season_button.setOnClickListener(clickListener);

    }
}