package com.example.mvpsjk.Presenter.contrant;

import com.example.mvpsjk.Base.BasePresenter;
import com.example.mvpsjk.Base.BaseView;

/**
 * Created by Macbookpro on 2017/12/28.
 */

public interface Contrant {
    public interface PresenterInf extends BasePresenter {
        public void getData(String[] strings);
    }
    public interface ViewInf extends BaseView {
        public void updateUI(String string);
    }
}
