package com.example.mvpsjk.Modle;

/**
 * Created by Macbookpro on 2017/12/28.
 */

public interface ModleInf {
    public void getDataFromWhere(String[] strings,CallBackLister callBackLister);

    public interface CallBackLister{
        public void sendMessage(String message);
    }
}
