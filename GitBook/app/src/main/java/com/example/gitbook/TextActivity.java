package com.example.gitbook;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextActivity extends AppCompatActivity { //书id 章节id
    private Button btn_last,btn_next;
    private String number="";
    private int bookid=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);


        btn_last=findViewById(R.id.btn_latter);
        btn_next=findViewById(R.id.btn_next);


        if (getIntent().hasExtra("bookid_m")) {
            bookid = getIntent().getIntExtra("bookid_m",0);//得到书本号
        }
        if (getIntent().hasExtra("menu_num_m")) {
            number = getIntent().getStringExtra("menu_num_m");//得到章节号
        }
        //通过书号和章节号请求文本




        ScrollView scrollView = findViewById(R.id.scrollview);
        TextView txt_info = findViewById(R.id.text);
        txt_info.setMovementMethod(ScrollingMovementMethod.getInstance());

        txt_info.append("这是最近美国俄亥俄州东巴勒斯坦城居民拍下的“灾难一幕”。\n" +
                "\n" +
                "滚滚浓烟直冲云霄，阴沉沉的天空飘散着大团大团的黑色云块，空气中弥漫着一股类似轮胎烧焦的刺鼻味道。\n" +
                "\n" +
                "“我们撤吧！我希望能离开这个鬼地方！”居民为何怒气冲冲拍下视频？为何怨声载道想要撤离？\n" +
                "\n" +
                "运载有毒化学品的列车脱轨，对有毒气体进行“受控释放”，记者被逮捕，动物出现中毒症状……对发生在美国的这一切，美国主流媒体似乎兴趣不大。\n" +
                "\n" +
                "为什么会这样？\n" +
                "\n" +
                "俄亥俄州究竟发生了什么？\n" +
                "\n" +
                "时间回到2月3日晚，一列火车行驶至俄亥俄州东巴勒斯坦城时脱轨起火。出事的是货运列车，约有50节车厢，其中10节车厢装载着有毒化学品。\n" +
                "\n" +
                "大火从3日晚间一直燃烧到4日早晨，幸好火势得到控制，没有造成人员伤亡。\n" +
                "\n" +
                "然而，事情远没有结束。\n" +
                "\n" +
                "随后，工作人员发现涉事列车5节装载压缩氯乙烯的车厢释压装置停止工作，其中一节车厢内出现“急剧温度变化”，有爆炸危险。\n" +
                "\n" +
                "为了避免灾难性后果，该列车所属的诺福克南方公司决定对这5节车厢进行装载物“受控释放”。\n" +
                "\n");//临时填充文本

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.smoothScrollTo(0, txt_info.getBottom());
            }
        });
    }
}
