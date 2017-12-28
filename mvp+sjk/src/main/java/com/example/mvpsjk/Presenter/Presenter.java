package com.example.mvpsjk.Presenter;

import android.content.Context;

import com.example.mvpsjk.Modle.ModleInf;
import com.example.mvpsjk.Modle.modle.Modle;
import com.example.mvpsjk.Presenter.contrant.Contrant;

/**
 * Created by Macbookpro on 2017/12/28.
 */

public class Presenter implements Contrant.PresenterInf{
//        modelInf.getDataFromWhere(strings, new ModelInf.CallBackLister() {
//            @Override
//            public void sendMessage(String message) {
//                viewInf.updateUI(message);
//            }
//        });
    private ModleInf modleInf;
    private Contrant.ViewInf viewInf;

    public Presenter(Contrant.ViewInf viewInf) {
        this.modleInf = new Modle();
        this.viewInf = viewInf;
    }


    @Override
    public void getData(String[] strings) {
        modleInf.getDataFromWhere(strings,new ModleInf.CallBackLister(){
            @Override
            public void sendMessage(String message) {
                viewInf.updateUI(message);
            }
        });
    }
}
