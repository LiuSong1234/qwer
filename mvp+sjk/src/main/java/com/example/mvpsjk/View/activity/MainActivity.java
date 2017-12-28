package com.example.mvpsjk.View.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvpsjk.Base.BaseActivity;
import com.example.mvpsjk.Presenter.Presenter;
import com.example.mvpsjk.Presenter.contrant.Contrant;
import com.example.mvpsjk.R;


import java.util.regex.Pattern;

import butterknife.Bind;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends BaseActivity implements Contrant.ViewInf {

    Contrant.PresenterInf presenterInf;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.editText1)
    EditText editText1;
    @Bind(R.id.editText2)
    EditText editText2;
    private boolean matches;
    private boolean matches1;

    @Override

    protected void initData() {
        presenterInf = new Presenter(this);
        presenterInf.getData(new String[]{});


        final String names = "[1][3,5,8,7][0-9]{9}";
        final String psws = "[a-zA-Z0-9]{4,16}";


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                String psw = editText2.getText().toString();
                matches = Pattern.matches(names, name);
                matches1 = Pattern.matches(psws, psw);
                if (matches && matches1) {
                    Intent in = new Intent(MainActivity.this, OneActivity.class);
                    startActivity(in);
                } else {
                    Toast.makeText(MainActivity.this, "你录入的信息有误,请重新输入.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_main;
    }

    @Override
    public void updateUI(String string) {

    }

}
