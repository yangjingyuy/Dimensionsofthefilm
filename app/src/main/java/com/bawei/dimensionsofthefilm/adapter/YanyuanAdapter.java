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
import com.bawei.dimensionsofthefilm.model.Area;
import com.bawei.dimensionsofthefilm.model.MovieActor;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/*时间:2019/11/9
创建人:yang 
创建人:杨靖宇*/
public class YanyuanAdapter extends RecyclerView.Adapter<YanyuanAdapter.yanyuanHolder> {
    private ArrayList<MovieActor> list;
    private Context context;

    public YanyuanAdapter(Context context) {
        list=new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<MovieActor> movieActors){
        if (movieActors!=null){
            list.addAll(movieActors);
        }
    }

    @NonNull
    @Override
    public yanyuanHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_yanyuan, null, false);
        return new yanyuanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull yanyuanHolder yanyuanHolder, final int i) {
        Glide.with(context).load(list.get(i).photo).into(yanyuanHolder.item_iv_yanyuan_photo);
        yanyuanHolder.item_tv_yanyuan_score.setText(list.get(i).name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class yanyuanHolder extends RecyclerView.ViewHolder{


        private final ImageView item_iv_yanyuan_photo;
        private final TextView item_tv_yanyuan_score;

        public yanyuanHolder(@NonNull View itemView) {
            super(itemView);
            item_iv_yanyuan_photo = itemView.findViewById(R.id.item_iv_yanyuan_photo);
            item_tv_yanyuan_score = itemView.findViewById(R.id.item_tv_yanyuan_score);

        }
    }



}
