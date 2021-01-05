package com.example.myhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myhealth.food_grid.FoodGridActivity;
import com.example.myhealth.food_list.CalculatorActivity;
import com.example.myhealth.food_list.InfoListActivity;

public class HomeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
    }

    public void onClick(View view) {
         Intent intent = new Intent();
        switch (view.getId()){
            case R.id.home_btn1:
                intent.setClass(HomeMenuActivity.this, InfoListActivity.class);
                break;
            case R.id.home_btn2:
                intent.setClass(HomeMenuActivity.this, FoodGridActivity.class);
                break;
            case R.id.home_btn3:
                intent.setClass(HomeMenuActivity.this, CalculatorActivity.class);
                break;
        }
        startActivity(intent);
    }


}