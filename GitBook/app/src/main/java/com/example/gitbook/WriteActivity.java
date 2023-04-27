package com.example.gitbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WriteActivity extends Activity {
    private ListView listView;

    private int bookid=0;
    private int userId=0;
    private String userName="";
    private List<Info> infoList=new ArrayList<>();
    InfoAdapter adapter;
    private Button btn_r,btn_m;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        btn_r = findViewById(R.id.btn_read_w);
        btn_m = findViewById(R.id.btn_mine_w);

        listView = findViewById(R.id.lv_2);
        Info info=new Info("书名:book2","作者:002","介绍:abcde",R.drawable.book2);
        infoList.add(info);
        adapter=new InfoAdapter(WriteActivity.this,R.layout.list_item,infoList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 第二步：通过Intent跳转至新的页面
                Intent intent3 = new Intent(WriteActivity.this, WriteMenuActivity.class);
                intent3.putExtra("bookid_w",bookid);
                startActivity(intent3);
            }
        });



        btn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                Toast.makeText(WriteActivity.this, "转入阅读界面", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(WriteActivity.this,ReadActivity.class);
                startActivity(intent1);
            }
        });



        btn_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v5) {
                Toast.makeText(WriteActivity.this, "转入个人界面", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(WriteActivity.this,MineActivity.class);
                startActivity(intent2);
            }
        });




    }

    //读数据
    private void read() {
        //TODO  1:得到SharedPreferences对象
        //参数一 xml文件的名字 参数二 模式 MODE_PRIVATE 指定该SharedPreferences数据只能被本应用程序读写
        SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        //TODO 2：直接读取
        //参数一 键  参数二 找不到的时候给默认值
        userName=preferences.getString("userName","");
        userId=preferences.getInt("userId",0);
    }
}
