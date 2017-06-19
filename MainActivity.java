package com.example.administrator.myworlk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.myworlk.Adapter.MyAdapter;
import com.example.administrator.myworlk.Bean.Bean;
import com.example.administrator.myworlk.persenter.MainPersenter;
import com.example.administrator.myworlk.view.IMain;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMain{

    private RecyclerView mRecycle;
    private MainPersenter mPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建MainPersenter对象
        mPersenter = new MainPersenter(this);
        mRecycle = (RecyclerView) findViewById(R.id.recycleview);
        mRecycle.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //调用mpersenter中的方法并给参数赋值；
        mPersenter.myView();

}

    @Override
    public void success(final List<Bean.TngouBean> tngou) {
         runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 mRecycle.setAdapter(new MyAdapter(tngou,MainActivity.this));
             }
         });
    }

    @Override
    public void failed() {

    }
}
