package com.bawei.dimensionsofthefilm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.model.Paiqi;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyPaiqiadapter extends RecyclerView.Adapter<MyPaiqiadapter.myViewHolder> {
     private ArrayList<Paiqi> list;
     private Context context;
    private View view;

    public MyPaiqiadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void addAll(List<Paiqi>paiqis){
        if (paiqis!=null){
            list.addAll(paiqis);
        }
    }


    @NonNull
    @Override
    public MyPaiqiadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.paiqi_layout,viewGroup,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPaiqiadapter.myViewHolder myViewHolder, int i) {
        Glide.with(context).load(list.get(i).trailerUrl).into(myViewHolder.imageView7);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{


        private final ImageView imageView7;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView7 = itemView.findViewById(R.id.image7);
        }
    }
}
