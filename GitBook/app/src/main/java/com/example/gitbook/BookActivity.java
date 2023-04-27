package com.example.gitbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity { //书本id 用户id
    private Button btn_menu,btn_ask;

    private int userId=0;
    private String userName="";
    private int bookid=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        btn_menu=findViewById(R.id.btn_menu);
        btn_ask=findViewById(R.id.btn_ask);

        if (getIntent().hasExtra("bookid_r")) {
            bookid = getIntent().getIntExtra("bookid_r", 0);//拿bookid
        }

        //通过bookid来调用接口拿数据然后填充




        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vb2) {
                Toast.makeText(BookActivity.this, "转入目录界面", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(BookActivity.this,MenuActivity.class);
                intent1.putExtra("bookid_b",bookid);//传参
                startActivity(intent1);
            }
        });

        btn_ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vb3) {

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
