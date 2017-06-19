package com.example.administrator.myworlk.persenter;

import android.support.v7.widget.RecyclerView;

import com.example.administrator.myworlk.Bean.Bean;
import com.example.administrator.myworlk.model.IHttp;
import com.example.administrator.myworlk.model.getHttp;
import com.example.administrator.myworlk.view.IMain;

import java.util.List;

/**
 * date:2017/6/14 0014
 * authom:贾雪茹
 * function:
 */

public class MainPersenter implements getHttp.Lin{

    private IMain main;
    private getHttp http;
    public MainPersenter(IMain main) {
        this.main = main;
        this.http=new getHttp(this);
    }

    public void myView(){
      http.myHttp();
    }

    @Override
    public void s(List<Bean.TngouBean> tngou) {
        main.success(tngou);
    }

    @Override
    public void f() {
      main.failed();
    }
}
