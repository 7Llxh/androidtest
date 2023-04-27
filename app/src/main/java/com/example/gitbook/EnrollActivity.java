package com.example.gitbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EnrollActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et1,et2;
    private Button btn1,btn2;
    private int userId=0;
    private String username="";
    private String password="";
    private OkHttpClient okHttpClient;
    private Boolean flag=false;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        okHttpClient =new OkHttpClient();

        btn1 = findViewById(R.id.btn_enroll2);
        btn2 =findViewById(R.id.btn_back);
        et1 =findViewById(R.id.enroll_userId);
        et2 =findViewById(R.id.enroll_password);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Toast.makeText(EnrollActivity.this, "转入登入界面", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EnrollActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });



    }


    @Override
    public void onClick(View view) {
        flag=false;
        username = et1.getText().toString();
        password = et2.getText().toString();
        //比较id和密码是否数据重复


        postEnroll();


        if(flag==true) {
            Toast.makeText(EnrollActivity.this, username+"注册成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(EnrollActivity.this, SignInActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(EnrollActivity.this, "发生错误", Toast.LENGTH_SHORT).show();
        }

    }


    public void postEnroll(){
        JSONObject json = new JSONObject();
        try {
            json.put("username", username);
            json.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("DATA",String.valueOf(json));//Log
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),json.toString());
        Request request =new Request.Builder()
                .url("http://129.211.15.118:9000/users/newuser")
                .post(requestBody)
                .build();
        Call call =okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.i("post","failed"+"err="+e.toString());
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    flag=true;
                    Log.i("post","Success!!");
                }
            }
        });
    }

}



