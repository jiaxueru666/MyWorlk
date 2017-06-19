package com.example.administrator.myworlk.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.myworlk.Bean.Bean;
import com.example.administrator.myworlk.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * date:2017/6/14 0014
 * authom:贾雪茹
 * function:
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder>{
    private List<Bean.TngouBean>datalist;
    private Context context;

    public MyAdapter(List<Bean.TngouBean> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.main2, parent, false);
        MyHolder holder=new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
       holder.titletext.setText(datalist.get(position).getTitle());
        holder.datatext.setText(datalist.get(position).getKeywords());
        Glide.with(context).load(datalist.get(position).getImg()).into(holder.imageview);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
}
 class MyHolder extends RecyclerView.ViewHolder{
       TextView titletext;
        TextView datatext;
     ImageView imageview;
     public MyHolder(View itemView) {
         super(itemView);
         titletext=itemView.findViewById(R.id.title);
         datatext=itemView.findViewById(R.id.data);
         imageview=itemView.findViewById(R.id.image);
     }
 }