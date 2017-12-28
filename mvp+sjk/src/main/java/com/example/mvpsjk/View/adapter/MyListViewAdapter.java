package com.example.mvpsjk.View.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mvpsjk.R;
import com.example.mvpsjk.View.bean.Student;

import java.util.List;

/**
 * Created by Macbookpro on 2017/12/28.
 */

public class MyListViewAdapter extends BaseAdapter {
    private List<Student> list;
    private Context context;

    public MyListViewAdapter(List<Student> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
            holder.text1 = view.findViewById(R.id.text1);
            holder.text2 = view.findViewById(R.id.text2);
            holder.text3 = view.findViewById(R.id.text3);
            holder.text4 = view.findViewById(R.id.text4);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        holder.text1.setText(list.get(i).getName() + "");
        holder.text2.setText(list.get(i).getSex() + "");
        holder.text3.setText(list.get(i).getAge() + "");
        holder.text4.setText(list.get(i).getBanji() + "");
        return view;
    }

    class Holder {
        private TextView text1;
        private TextView text2;
        private TextView text3;
        private TextView text4;
    }
}
