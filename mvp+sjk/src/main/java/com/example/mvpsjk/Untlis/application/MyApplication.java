package com.example.mvpsjk.Untlis.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.mvpsjk.DaoMaster;
import com.example.mvpsjk.DaoSession;


/**
 * Created by Macbookpro on 2017/11/27.
 * Application 也是一个组件Android基础组件
 * 每一个项目里面只能有一个Application（就相当于是全局变量就是在这个app里面每个页面都能用到）
 * 他也有生命周期
 * 1：onCreate();
 * <p>
 * 如何写一个Application
 * 1：自己写一个类 继承Application 即可
 * 2：重写一个方法 onCreate
 * 注意事项？
 * 跟Activity一样？得注册。在AndroidManifest里面注册
 * <p>
 * 项目已开启是不是就执行了
 * 在这里面做提供数据库
 * green Dao 怎么用
 * <p>
 * 1：创建一个数据库
 * 2：用数据库框架包装 DaoMaster
 * 3：提供DaoSession
 * 4：提供一个TDao（里面封装数据库的增删改查）
 * 我们看一下数据库框架的一些类：
 * DaoMaster（提供数据库）
 * DaoSession（提供表）
 * StudentDao（做操作）
 * <p>
 * Application 构造不能私有化
 */

public class MyApplication extends Application {
    private static MyApplication application;

    private DaoSession mDaoSession;

    public static MyApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //完成Application的初始化
        application = this;
        createData();
    }
    //操作数据库
    public void createData() {
        //第一步创建一个数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(application, "ls.db");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        //第二步用数据库框架来包装数据库
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        //第三步生成Session对象
        mDaoSession = daoMaster.newSession();
    }


    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
