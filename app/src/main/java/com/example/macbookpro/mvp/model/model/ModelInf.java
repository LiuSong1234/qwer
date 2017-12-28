package com.example.macbookpro.mvp.model.model;

/**
 * Created by Macbookpro on 2017/12/27.
 */

public interface ModelInf {

    public void getDataFromWhere(String[] strings,CallBackLister callBackLister);

    public interface CallBackLister{
        public void sendMessage(String message);
    }
}
