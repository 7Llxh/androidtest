package com.example.gitbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MineActivity extends AppCompatActivity {


    private Button btn_r,btn_w,btn_ask,btn_change_text,btn_change_image;
    private int userId=0;
    private String userName="";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        btn_w =findViewById(R.id.btn_write_m);
        btn_r = findViewById(R.id.btn_read_m);
        btn_ask=findViewById(R.id.btn_ask_mine);
        btn_change_text=findViewById(R.id.btn_change_text);
        btn_change_image=findViewById(R.id.btn_change_image);

        read();//拿id和name

        btn_w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v7) {
                Toast.makeText(MineActivity.this, "转入写作界面", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MineActivity.this,WriteActivity.class);
                startActivity(intent1);
            }
        });

        btn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v8) {
                Toast.makeText(MineActivity.this, "转入阅读界面", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MineActivity.this,ReadActivity.class);
                startActivity(intent2);
            }
        });

        btn_ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v9) {
                Toast.makeText(MineActivity.this, "转入请求界面", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(MineActivity.this,AskActivity.class);
                startActivity(intent3);
            }
        });

        btn_change_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v10) {
                Toast.makeText(MineActivity.this, "转入修改界面", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(MineActivity.this,ChangeActivity.class);
                startActivity(intent4);
            }
        });

        btn_change_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v11) {

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
