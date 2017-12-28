package com.example.macbookpro.mvp.model.http;

import com.example.macbookpro.mvp.model.model.ModelInf;
import com.example.macbookpro.mvp.untils.HttpUntils;

/**
 * Created by Macbookpro on 2017/12/27.
 */

public class HttpModel implements ModelInf {

    @Override
    public void getDataFromWhere(String[] strings, CallBackLister callBackLister) {
        HttpUntils.getDataByRe(callBackLister);
    }

}
