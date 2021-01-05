package com.example.myhealth.food_grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myhealth.R;
import com.example.myhealth.bean.FoodBean;

public class FoodDescActivity extends AppCompatActivity {
    TextView titleTv1,titleTv2,descTv,notTv,backIv;
    ImageView bigPicIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_desc);
        initView();
        //接受上一级页面传来的数据
        Intent intent = getIntent();
        FoodBean foodBean = (FoodBean) intent.getSerializableExtra("food");
        //依次设置显示控件
        titleTv1.setText(foodBean.getTitle());
        titleTv2.setText(foodBean.getTitle()+foodBean.getCalorie());
        descTv.setText(foodBean.getDesc());
        notTv.setText(foodBean.getNotmatch());
        bigPicIv.setImageResource(foodBean.getPicId());
    }

    private void initView() {
        titleTv1 = findViewById(R.id.fooddesc_tv_title1);
        titleTv2 = findViewById(R.id.fooddesc_tv_title2);
        descTv = findViewById(R.id.fooddesc_tv_desc);
        notTv = findViewById(R.id.fooddesc_tv_notmatch);
        backIv = findViewById(R.id.fooddesc_iv_back);
        bigPicIv = findViewById(R.id.fooddesc_iv_bigpic);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//销毁当前的Activity；
            }
        });
    }

}