package com.example.administrator.myworlk.model;

import com.example.administrator.myworlk.Bean.Bean;
import com.example.administrator.myworlk.utils.MyPath;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * date:2017/6/14 0014
 * authom:贾雪茹
 * function:
 */

public class getHttp implements IHttp{

    //网络请求的方法；
    @Override
    public void myHttp() {
        OkHttpClient http=new OkHttpClient();
        final Request request=new Request.Builder().url(MyPath.path).build();
        http.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
              lin.f();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson=new Gson();

                Bean bean = gson.fromJson(response.body().string(), Bean.class);
                List<Bean.TngouBean> tngou = bean.getTngou();
                   lin.s(tngou);
            }
        });
    }

  public  interface Lin{
        public void s(List<Bean.TngouBean> tngou);
        public void f();
    }

    private Lin lin;

    public getHttp(Lin lin) {
        this.lin = lin;
    }
}
