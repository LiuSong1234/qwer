package com.example.macbookpro.mvp.presenter;

import com.example.macbookpro.mvp.model.model.ModelInf;
import com.example.macbookpro.mvp.presenter.contrant.Contrant;

/**
 * Created by Macbookpro on 2017/12/27.
 */

public class presenter implements Contrant.PresenterInf {
    private ModelInf modelInf;
    private Contrant.ViewInf viewInf;

    public presenter(Contrant.ViewInf viewInf) {
        this.modelInf = new com.example.macbookpro.mvp.model.http.HttpModel();
        this.viewInf = viewInf;
    }

    @Override
    public void getData(String[] strings) {
        modelInf.getDataFromWhere(strings, new ModelInf.CallBackLister() {
            @Override
            public void sendMessage(String message) {
                viewInf.updateUI(message);
            }
        });
    }
}
