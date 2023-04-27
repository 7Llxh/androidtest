package com.example.gitbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et1,et2;
    private String username ="";

    Boolean flag=true;
    private String password ="";
    private Button btn1,btn2;

    private int userId=0;
    private OkHttpClient okHttpClient;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        okHttpClient =new OkHttpClient();

        btn1 = findViewById(R.id.btn_sign);
        btn2 =findViewById(R.id.btn_enroll);
        et1= findViewById(R.id.edit_userId);
        et2= findViewById(R.id.edit_password);




        btn1.setOnClickListener(this);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Toast.makeText(SignInActivity.this, "转入注册界面", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignInActivity.this,EnrollActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onClick(View view) {
        username = et1.getText().toString();
        password = et2.getText().toString();

        //get请求比较是否正确
        getsignin(username, password);

        if (userId!=000){flag=true;}
        else {flag=false;}



        if(flag==true) {
            Toast.makeText(SignInActivity.this, "欢迎"+ username, Toast.LENGTH_SHORT).show();
            write();
            Intent intent1 = new Intent(SignInActivity.this, ReadActivity.class);
            startActivity(intent1);
        }
        else {
            Toast.makeText(SignInActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            et1.setText("");
            et2.setText("");
        }

    }

    private void write() {
        //TODO  1:得到SharedPreferences对象
        //参数一 xml文件的名字 参数二 模式 MODE_PRIVATE 指定该SharedPreferences数据只能被本应用程序读写
        SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        //TODO 2:获得编辑对象
        SharedPreferences.Editor editor = preferences.edit();
        //TODO 3:写数据(类似于键值对)
        editor.putString("username", username);//string型
        editor.putInt("userId",userId);//int型
        //TODO 4:提交数据
        editor.commit();//最后一步
    }

    public void getsignin(String userName,String userpassword){


        FormBody formBody=new FormBody.Builder()
                .add("username",userName)
                .add("password",userpassword)
                .build();
        JSONObject json = new JSONObject();
        try {
            json.put("username", username);
            json.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonStr = json.toString();
        Log.i("DATA",jsonStr);//Log
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        String url= null;
        url = "http://129.211.15.118:9000/users/login";
        url=url+"?username="+username+"&password="+password;
        Request request =new Request.Builder()
                .url(url)
                .addHeader("User-Agent", "Apifox/1.0.0 (https://www.apifox.cn)")
                .addHeader("Content-Type", "application/json")
                .build();
        Call call =okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String data=response.body().string();
                    JSONObject jsonObject= null;
                    try {
                        jsonObject = new JSONObject(data);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    userId=jsonObject.optInt("userid",000);
                    Log.i("get","success");

                }

            }
        });

    }





}



