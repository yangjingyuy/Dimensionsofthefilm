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
import com.bawei.dimensionsofthefilm.model.MovieDirector;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/*时间:2019/11/9
创建人:yang 
创建人:杨靖宇*/
public class DayinAdapter extends RecyclerView.Adapter<DayinAdapter.dayinHolder> {
    private ArrayList<MovieDirector> list;
    private Context context;

    public DayinAdapter(Context context) {
        list=new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<MovieDirector> movieDirectors){
        if (movieDirectors!=null){
            list.addAll(movieDirectors);
        }
    }

    @NonNull
    @Override
    public dayinHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_daoyan, null, false);
        return new dayinHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dayinHolder dayinHolder, final int i) {
        Glide.with(context).load(list.get(i).photo).into(dayinHolder.item_iv_daoyan_photo);
        dayinHolder.item_tv_daoyan_score.setText(list.get(i).name);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class dayinHolder extends RecyclerView.ViewHolder{


        private final ImageView item_iv_daoyan_photo;
        private final TextView item_tv_daoyan_score;

        public dayinHolder(@NonNull View itemView) {
            super(itemView);
            item_iv_daoyan_photo = itemView.findViewById(R.id.item_iv_daoyan_photo);
            item_tv_daoyan_score = itemView.findViewById(R.id.item_tv_daoyan_score);
        }
    }



}
