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
import com.bawei.dimensionsofthefilm.model.Recommend;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/*时间:2019/11/8
创建人:yang 
创建人:杨靖宇*/
public class RecommendAdapter extends RecyclerView.Adapter <RecommendAdapter.recomHolder>{
    private ArrayList<Recommend> list;
    private Context context;

    public RecommendAdapter( Context context) {
        list=new ArrayList<>();
        this.context = context;
    }
    public void addAll(List<Recommend> recommends){
        if (recommends!=null){
            list.addAll(recommends);
        }

    }
    @NonNull
    @Override
    public recomHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommed_layout, null, false);
        return new recomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recomHolder recomHolder, int i) {
        Recommend recommend = list.get(i);
        Glide.with(context).load(recommend.logo).into(recomHolder.recommed_img);
        recomHolder.recommed_name.setText(recommend.name);
        recomHolder.recommed_dz.setText(recommend.address);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class recomHolder extends RecyclerView.ViewHolder{

        private final ImageView recommed_img;
        private final TextView recommed_name;
        private final TextView recommed_dz;

        public recomHolder(@NonNull View itemView) {
            super(itemView);
            recommed_img = itemView.findViewById(R.id.recommed_img);
            recommed_name = itemView.findViewById(R.id.recommed_name);
            recommed_dz = itemView.findViewById(R.id.recommed_dz);
        }
    }
    }
