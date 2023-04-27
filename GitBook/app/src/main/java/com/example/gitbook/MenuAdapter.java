package com.example.gitbook;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<num> {

    private List<num> listnum;
    //用于将上下文、listview 子项布局的 id 和数据都传递过来
    public MenuAdapter(@NonNull Context context, int resource, @NonNull List<num> list) {
        super(context, resource, list);
    }
    //增加一个方法添加动态数据
    public void add(num num1){
        listnum.add(num1);
        notifyDataSetChanged();
    }
    //每个子项被滚动到屏幕内的时候会被调用
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        num nmu1 = getItem(position);//得到当前项的 num 实例
        //为每一个子项加载设定的布局
        View view;
        if(convertView==null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.menu_item,parent,
                    false);
        }else {
            view = convertView;
        }

        //分别获取子布局textview 的实例
        TextView menuNumber=view.findViewById(R.id.Number);

        // 设置要显示内容
        menuNumber.setText(nmu1.getNumber());


        return view;
    }
}

