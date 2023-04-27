package com.example.gitbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends Activity {

    private ListView listView;

    private int bookid=0;
    private String number="";
    private List<num> numList=new ArrayList<>();

    MenuAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listView = findViewById(R.id.lv_3);

        if (getIntent().hasExtra("bookid_b")) {
            bookid = getIntent().getIntExtra("bookid_b", 0);//拿bookid
        }

        //通过bookid来调用接口拿数据然后填充


        //输入数据
        num num1=new num("a001");
        num num2=new num("a002");
        num num3=new num("b001");
        numList.add(num1);
        numList.add(num2);
        numList.add(num3);





        adapter=new MenuAdapter(MenuActivity.this,R.layout.menu_item,numList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 第二步：通过Intent跳转至新的页面
                number= numList.get(position).number;
                Intent intent1 = new Intent(MenuActivity.this, TextActivity.class);
                intent1.putExtra("menu_num_m",number);
                intent1.putExtra("bookid_m",bookid);
                startActivity(intent1);
            }
        });


    }


}
