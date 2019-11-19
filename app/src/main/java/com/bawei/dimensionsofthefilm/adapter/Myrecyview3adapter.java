package com.bawei.dimensionsofthefilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.model.Zhengzaishangying;
import com.bawei.dimensionsofthefilm.view.XzyingyuanActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Myrecyview3adapter extends RecyclerView.Adapter<Myrecyview3adapter.myViewHolder> {

    private ArrayList<Zhengzaishangying> list ;
    private Context context;
    private View view;
    private Zhengzaishangying zhengzaishangying;

    public Myrecyview3adapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void addAll(List<Zhengzaishangying>zhengzaishangyings){
        if (zhengzaishangyings!=null){
            list.addAll(zhengzaishangyings);
        }
    }

    @NonNull
    @Override
    public Myrecyview3adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.zhengzaishangshi_layout,viewGroup,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myrecyview3adapter.myViewHolder myViewHolder, final int i) {
        zhengzaishangying = list.get(i);
        Glide.with(context).load(list.get(i).imageUrl).into(myViewHolder.imageView4);
        myViewHolder.textView4.setText(list.get(i).director);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerhotmy.onClick(v,i);
            }
        });
        myViewHolder.rm_gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, XzyingyuanActivity.class);
                intent.putExtra("keyy", zhengzaishangying.movieId);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView4;
        private final ImageView imageView4;
        private final Button rm_gp;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView4 = itemView.findViewById(R.id.text_name4);
            imageView4 = itemView.findViewById(R.id.image4);
            rm_gp = itemView.findViewById(R.id.rm_gp);

        }
    }
    private  OnItemClickListener listenerhotmy;

    public void setListenerhotmy(OnItemClickListener listenerhotmy) {
        this.listenerhotmy = listenerhotmy;
    }

    //定义接口
    public interface OnItemClickListener{
        void onClick(View view,int position);
    }
}
