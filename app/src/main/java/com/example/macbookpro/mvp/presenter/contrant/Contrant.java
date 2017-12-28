package com.example.macbookpro.mvp.presenter.contrant;

import com.example.macbookpro.mvp.base.BasePresenter;
import com.example.macbookpro.mvp.base.BaseView;

/**
 * Created by Macbookpro on 2017/12/27.
 * 契约类 PV的接口.
 */

public interface Contrant {
    public interface PresenterInf extends BasePresenter {
        public void getData(String[] strings);
    }
    public interface ViewInf extends BaseView {
        public void updateUI(String string);
    }
}
