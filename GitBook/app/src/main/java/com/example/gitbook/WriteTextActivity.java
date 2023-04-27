package com.example.gitbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class WriteTextActivity extends Activity {

    private String number="";
    private String text="";
    private Button btn1,btn2;
    private int way=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_text);

        btn1 = findViewById(R.id.btn_sure);
        btn2 =findViewById(R.id.btn_back_wt);

        if (getIntent().hasExtra("menu_num_wm")) {
            number = getIntent().getStringExtra("menu_num_wm");//得到章节号
        }
        if (getIntent().hasExtra("menu_way")) {
            way = getIntent().getIntExtra("menu_way",0);//得到方式
        }




        ScrollView scrollView =findViewById(R.id.scrollview_wt);
        EditText txt_wt = findViewById(R.id.text_wt);
        txt_wt.setMovementMethod(ScrollingMovementMethod.getInstance());

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.smoothScrollTo(0, txt_wt.getBottom());
            }
        });

        text=txt_wt.getText().toString();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Toast.makeText(WriteTextActivity.this, "已确定", Toast.LENGTH_SHORT).show();
                //将text上传

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Toast.makeText(WriteTextActivity.this, "返回目录界面", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(WriteTextActivity.this,WriteMenuActivity.class);
                startActivity(intent1);
            }
        });


    }
}

