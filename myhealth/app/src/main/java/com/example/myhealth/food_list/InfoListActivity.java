package com.example.myhealth.food_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myhealth.R;
import com.example.myhealth.bean.FoodBean;
import com.example.myhealth.bean.FoodUtils;
import com.example.myhealth.food_grid.FoodDescActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoListActivity extends AppCompatActivity implements View.OnClickListener {
    EditText searchEt;
    TextView searchIv,flushIv,backTv;
    ListView showLv;
    //Listview内部数据源
    List<FoodBean>mDatas;
    List<FoodBean> allFoodLists;
    private InfolistAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);
//查找控件
        initView();
        //2.找到Listview对应得数据源
        mDatas = new ArrayList<>();
        allFoodLists = FoodUtils.getAllFoodList();
        mDatas.addAll(allFoodLists);
        //3.创建适配器 baseAdapter的子类
        adapter = new InfolistAdapter(this, mDatas);
        showLv.setAdapter(adapter);//设置适配器
        //设置单项点击监听
        setListener();
    }

    private void setListener() {
        showLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               FoodBean foodBean =  mDatas.get(position);
                Intent intent = new Intent(InfoListActivity.this, FoodDescActivity.class);
                intent.putExtra("food",foodBean);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        searchEt = findViewById(R.id.info_et_search);
        searchIv = findViewById(R.id.info_iv_search);
        flushIv = findViewById(R.id.info_iv_flush);
        showLv = findViewById(R.id.info_list_lv);
        searchIv.setOnClickListener(this);//添加点击事件的监听器
        flushIv.setOnClickListener(this);
        backTv = findViewById(R.id.fooddesc_iv_back4);
        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//销毁当前的Activity
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.info_iv_flush://刷新点击
                mDatas.clear();
                searchEt.setText("");
                mDatas.addAll(allFoodLists);
                adapter.notifyDataSetChanged();
                break;
            case R.id.info_iv_search://搜索点击
                String msg = searchEt.getText().toString().trim();//获取搜索框信息
                if(TextUtils.isEmpty(msg)){
                    Toast.makeText(this,"输入内容不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                //判断食物列表的标题是否包含输入内容，如果包含，就添加小集合中
                List<FoodBean>list = new ArrayList<>();
                for (int i = 0; i <allFoodLists.size(); i++) {
                    String title =  allFoodLists.get(i).getTitle();
                    if(title.contains(msg)){
                        list.add(allFoodLists.get(i));
                    }
                    mDatas.clear();//清空ListView适配器数据源内容
                    mDatas.addAll(list);//添加新的数据到数据源
                    adapter.notifyDataSetChanged();//提示适配器更新
                }
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}