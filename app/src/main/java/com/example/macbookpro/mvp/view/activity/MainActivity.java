package com.example.macbookpro.mvp.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.macbookpro.mvp.R;
import com.example.macbookpro.mvp.base.BaseActivity;
import com.example.macbookpro.mvp.presenter.contrant.Contrant;
import com.example.macbookpro.mvp.presenter.presenter;
import com.example.macbookpro.mvp.view.adapter.MyRecyclerAdapter;
import com.example.macbookpro.mvp.view.bean.MyBean;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;

import static android.R.id.list;

public class MainActivity extends BaseActivity implements Contrant.ViewInf{

    Contrant.PresenterInf presenterInf;
    List<MyBean.ResultBean.DataBean> data;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void initData() {
        presenterInf = new presenter(this);
        presenterInf.getData(new String[]{});
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void updateUI(String string) {
        //这个地方是我们放listview的地方 可以把这个放到类别显示.
        Gson gson = new Gson();
        MyBean myBean = gson.fromJson(string, MyBean.class);
        data = myBean.getResult().getData();
        Log.e("TAG", "handleMessage:------------------------- " + data.size());

        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(data,this);
        recyclerView.setAdapter(myRecyclerAdapter);
        myRecyclerAdapter.setItemListener(new MyRecyclerAdapter.OnItemClick() {
            @Override
            public void setOnItem(View v, int position) {
                String thumbnail_pic_s = data.get(position).getUrl();
                String title = data.get(position).getTitle();
                Intent intent = new Intent(MainActivity.this, OneActivity.class);
                intent.putExtra("002",thumbnail_pic_s);
                intent.putExtra("001",title);
                startActivity(intent);
            }
        });

    }


    @Override
    public void setPresenter(Object presenter) {
        //设置P层.
    }

    @Override
    public void showError(String errorMessage) {
        //查看报错信息.
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nightTherem(boolean bool) {
        //设置夜间模式
    }
}
