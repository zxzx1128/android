package com.example.myhealth.food_grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myhealth.R;
import com.example.myhealth.bean.FoodBean;
import com.example.myhealth.bean.FoodUtils;

import java.util.List;


public class FoodGridActivity extends AppCompatActivity {
    GridView gv;
    List<FoodBean>mDatas;
    private FoodGridAdapter adapter;
    TextView backIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_grid);
        gv = findViewById(R.id.food_grid_gv);
        //数据源
        mDatas  = FoodUtils.getAllFoodList();
        //创建适配器
        adapter = new FoodGridAdapter(this, mDatas);
        gv.setAdapter(adapter);
        setListener();
        initView();
    }

    private void initView() {
        backIV = findViewById(R.id.fooddesc_iv_back2);
        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//销毁当前的Activity；
            }
        });
    }

    private void setListener() {
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodBean foodBean =  mDatas.get(position);
                Intent intent = new Intent(FoodGridActivity.this, FoodDescActivity.class);
                intent.putExtra("food",foodBean);
                startActivity(intent);
            }
        });
    }
}