package com.example.gitbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ChangeActivity extends Activity { //用户id
    private String text="";
    private String  password="";
    private Button btn1,btn2;

    private int userId=0;
    private String userName="";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        btn1 = findViewById(R.id.btn_sure_mine);
        btn2 =findViewById(R.id.btn_back_mine);
        read();





        EditText txt_mine = findViewById(R.id.text_mine);
        EditText txt_pwd = findViewById(R.id.password_mine);



        text=txt_mine.getText().toString();
        password= txt_pwd.getText().toString();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                //上传信息

                Toast.makeText(ChangeActivity.this, "上传成功", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(ChangeActivity.this,MineActivity.class);
                startActivity(intent1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Toast.makeText(ChangeActivity.this, "返回个人中心", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(ChangeActivity.this,MineActivity.class);
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
