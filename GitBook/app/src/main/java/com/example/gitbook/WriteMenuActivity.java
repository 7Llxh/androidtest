package com.example.gitbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WriteMenuActivity extends Activity {

    private ListView listView;
    private int bookid=0;
    private String number="";
    private List<num> numList=new ArrayList<>();
    MenuAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_menu);

        listView = findViewById(R.id.lv_4);

        if (getIntent().hasExtra("bookid_w")) {
            bookid = getIntent().getIntExtra("bookid_w", 0);//拿bookid
        }

        //通过bookid来调用接口拿数据然后填充

        //临时填充
        num num1=new num("a001");
        num num2=new num("a002");
        num num3=new num("b001");
        numList.add(num1);
        numList.add(num2);
        numList.add(num3);

        adapter=new MenuAdapter(WriteMenuActivity.this,R.layout.menu_item,numList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 第二步：通过Intent跳转至新的页面
                number= numList.get(position).number;
                showListDialog(number);



            }
        });


    }

    private void showListDialog(String number){
        AlertDialog.Builder builder=new AlertDialog.Builder(WriteMenuActivity.this);
        builder.setTitle("选择添加方式");
        final String[] choice={"添加分支","修改","添加下一章"};
        //设置一个下拉的列表选择项
        builder.setItems(choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(WriteMenuActivity.this,"选择的选项为："+choice[which],Toast.LENGTH_SHORT).show();
                if (choice[which]=="添加分支"){

                    Intent intent1 = new Intent(WriteMenuActivity.this, WriteTextActivity.class);
                    intent1.putExtra("menu_way",1);
                    intent1.putExtra("menu_num-wm",number);
                    startActivity(intent1);

                }
                if (choice[which]=="修改"){
                    Intent intent2 = new Intent(WriteMenuActivity.this, WriteTextActivity.class);
                    intent2.putExtra("menu_way",2);
                    intent2.putExtra("menu_num-wm",number);
                    startActivity(intent2);

                }
                if (choice[which]=="添加下一章"){
                    Intent intent3 = new Intent(WriteMenuActivity.this, WriteTextActivity.class);
                    intent3.putExtra("menu_way",3);
                    intent3.putExtra("menu_num-wm",number);
                    startActivity(intent3);

                }
            }
        });
        builder.show();
    }

}
