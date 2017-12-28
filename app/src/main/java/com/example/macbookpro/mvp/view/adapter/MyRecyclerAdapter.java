package com.example.macbookpro.mvp.view.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.macbookpro.mvp.R;
import com.example.macbookpro.mvp.view.bean.MyBean;

import java.util.List;

import butterknife.Bind;

import static android.R.id.list;

/**
 * Created by Macbookpro on 2017/12/28.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    List<MyBean.ResultBean.DataBean> data;
    Context mContext;
    private final static int ITEM_ONE = 1;
    private final static int ITEM_TWO = 2;

    public MyRecyclerAdapter(List<MyBean.ResultBean.DataBean> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view;
        RecyclerView.ViewHolder holder;
        if (viewType == ITEM_TWO) {
            view = inflater.inflate(R.layout.recycler_one_item, parent, false);
            holder = new HolderOne(view);
        } else {
            view = inflater.inflate(R.layout.recycler_two_item, parent, false);
            holder = new HolderTwo(view);
        }
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyBean.ResultBean.DataBean dataBean = data.get(position);
        if (holder instanceof HolderOne){
            ((HolderOne)holder).textView.setText(dataBean.getTitle()+"");
            Glide.with(mContext).load(dataBean.getThumbnail_pic_s()).into(((HolderOne)holder).imageView);
            ((HolderOne) holder).itemView.setTag(position);
        }else {
            ((HolderTwo)holder).textView1.setText(dataBean.getTitle()+"");
            Glide.with(mContext).load(dataBean.getThumbnail_pic_s02()).into(((HolderTwo)holder).imageView1);
            ((HolderTwo) holder).itemView.setTag(position);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return ITEM_ONE;
        } else {
            return ITEM_TWO;
        }
    }

    class HolderOne extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public HolderOne(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    class HolderTwo extends RecyclerView.ViewHolder {
        private ImageView imageView1;
        private TextView textView1;

        public HolderTwo(View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.imageView2);
            textView1 = itemView.findViewById(R.id.textView2);
        }
    }
    public interface OnItemClick {
        void setOnItem(View v, int position);
    }

    private OnItemClick onitem;

    @Override
    public void onClick(View v) {
        if (onitem != null) {
            onitem.setOnItem(v, (int) v.getTag());
        }
    }

    public void setItemListener(OnItemClick item) {
        this.onitem = item;
    }
}
