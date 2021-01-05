package com.example.myhealth.food_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myhealth.R;

public class CalculatorActivity extends AppCompatActivity {

    Spinner spinnertext;
    RadioGroup rg1,rg2;
    TextView showcal,backTv;
    Button btn;
    int sex = 0;
    int height = 0,weight = 0, years = 0;
    double sport = 0,totalcal = 0;
    double[][] datas={{67,13.73,5,6.9},{661,9.6,1.72,4.7}};
    int[]spinnerid = {R.id.spinner1,R.id.spinner2,R.id.spinner3};
    int[] types = {R.array.height,R.array.weight,R.array.years};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        rg1 = (RadioGroup) findViewById(R.id.cal_rg1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb1) {
                    sex=1;
                    //Log.i("test", "rb1 被用户点击了 sex=男");
                }
                else if (checkedId == R.id.rb2){
                    sex=2;
                    //Log.i("test", "rb2 被用户点击了 sex=女");
                }
            }
        });
        backTv = findViewById(R.id.fooddesc_iv_back3);
        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rg2 = (RadioGroup) findViewById(R.id.cal_rg2);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb3) {
                    sport=1.2;
                   // Log.i("test", "rb3 被用户点击了 sport=1.2");
                }
                else if (checkedId == R.id.rb4){
                    sport=1.5;
                   // Log.i("test", "rb4 被用户点击了 sport=1.5");
                }
                else if (checkedId == R.id.rb5){
                    sport=1.8;
                   // Log.i("test", "rb5 被用户点击了 sport=1.8");
                }
            }
        });

        showcal = (TextView) findViewById(R.id.show_cal);
        btn = (Button) findViewById(R.id.cal_button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("test", "cal_button1 被用户点击了。");
                if (sex == 1) {
                    totalcal = (datas[0][0]+datas[0][1]*weight+datas[0][2]*height-datas[0][3]*years)*sport;
                }else if(sex ==2){
                    totalcal = (datas[1][0]+datas[1][1]*weight+datas[1][2]*height-datas[1][3]*years)*sport;
                }
                Log.i("calculate:", "totalcal="+totalcal);
                showcal.setText("计算结果："+String.format("%.2f",totalcal)+"卡路里");
            }
        });

        for (int i = 0; i <spinnerid.length; i++) {
            spinnertext = (Spinner) findViewById(spinnerid[i]);
            //为下拉列表定义一个适配器
            final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, types[i], android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //设置下拉列表下拉时的菜单样式
            spinnertext.setAdapter(adapter);//将适配器添加到下拉列表上
            final int finalI = i;
            //添加监听器，为下拉列表设置事件的响应
            spinnertext.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> argO, View argl, int arg2, long arg3) {
                    Log.i("test", "身体参数:" + adapter.getItem(arg2));
                    String a = adapter.getItem(arg2).toString();
                    String b = "";
                    for (int j = 0; j < a.length(); j++) {
                        if (a.charAt(j) >= 48 && a.charAt(j) <= 57) {
                            b += a.charAt(j);
                        }
                    }
                    int c;
                    c=Integer.parseInt(b);
                    Log.i("数据类型转换:", "CharSequence:"+adapter.getItem(arg2)+"  String:" + a + "  String(num):" + b + "  int:" + c);
                    if (finalI ==0) {
                        height= c;
                        Log.i("test", "身高=:" + height);
                    }
                    else if (finalI ==1){
                        weight = c;
                        Log.i("test", "体重=:" + weight);
                    }
                    else if (finalI ==2){
                        years = c;
                        Log.i("test", "年龄=:" + years);
                    }
                    argO.setVisibility(View.VISIBLE);
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    Log.i("test", "???");
                    arg0.setVisibility(View.VISIBLE);
                }
            });
        }
    }

}