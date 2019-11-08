package com.bawei.dimensionsofthefilm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.model.Fujin;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyFujinyingyuanadapter extends RecyclerView.Adapter<MyFujinyingyuanadapter.myViewHolder> {
    private ArrayList<Fujin> list;
    private Context context;
    private View view;

    public MyFujinyingyuanadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

     public void addAll(List<Fujin> fujins){
        if (fujins!=null){
            list.addAll(fujins);
        }
     }

    @NonNull
    @Override
    public MyFujinyingyuanadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.fujing_layout,viewGroup,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyFujinyingyuanadapter.myViewHolder myViewHolder, int i) {
        Glide.with(context).load(list.get(i).logo).into(myViewHolder.imageView5);
        myViewHolder.textView5.setText(list.get(i).address);
        myViewHolder.textView6.setText(list.get(i).name);
        myViewHolder.textView7.setText(list.get(i).followCinema);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView5;
        private final TextView textView5;
        private final TextView textView6;
        private final TextView textView7;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView5 = itemView.findViewById(R.id.imager5);
            textView5 = itemView.findViewById(R.id.text_name5);
            textView6 = itemView.findViewById(R.id.text_name6);
            textView7 = itemView.findViewById(R.id.text_name7);
        }
    }
}
