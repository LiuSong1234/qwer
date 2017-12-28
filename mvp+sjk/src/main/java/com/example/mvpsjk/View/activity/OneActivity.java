package com.example.mvpsjk.View.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mvpsjk.Base.BaseActivity;
import com.example.mvpsjk.Presenter.contrant.Contrant;
import com.example.mvpsjk.R;
import com.example.mvpsjk.StudentDao;
import com.example.mvpsjk.Untlis.application.MyApplication;
import com.example.mvpsjk.View.adapter.MyListViewAdapter;
import com.example.mvpsjk.View.bean.Student;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class OneActivity extends BaseActivity implements Contrant.ViewInf{

    @Bind(R.id.listView)
    ListView listView;
    private StudentDao mstudentDao;
    private List<Student> mlist;
    private MyListViewAdapter myListViewAdapter;
    private Student student;

    @Override
    protected void initData() {

        mstudentDao = MyApplication.getApplication().getDaoSession().getStudentDao();
        mlist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            student = new Student();
            student.setName("张三"+i);
            student.setAge("1"+i);
            student.setSex("男");
            student.setBanji("H1705A");
            mlist.add(student);
        }

        mstudentDao.loadAll();
        initAdapter();
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_one;
    }

    @Override
    public void updateUI(String string) {

    }
    private void initAdapter() {
        myListViewAdapter = new MyListViewAdapter(mlist, OneActivity.this);
        listView.setAdapter(myListViewAdapter);
    }

}
