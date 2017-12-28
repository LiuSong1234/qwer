package com.example.macbookpro.mvp.base;

/**
 * Created by Macbookpro on 2017/12/27.
 */

public interface BaseView<P> {

    /**
     * 设置p层
     */
    public void setPresenter(P presenter);

    /**
     * 展示错误信息
     */
    public void showError(String errorMessage);


    /**
     * 是否开启夜间模式
     */
    public void nightTherem(boolean bool);
}
