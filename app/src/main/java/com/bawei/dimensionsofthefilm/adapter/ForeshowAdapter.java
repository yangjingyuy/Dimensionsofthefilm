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
import com.bawei.dimensionsofthefilm.model.Filmreview;
import com.bawei.dimensionsofthefilm.model.ShortFilmList;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/*时间:2019/11/9
创建人:yang 
创建人:杨靖宇*/
public class ForeshowAdapter extends RecyclerView.Adapter<ForeshowAdapter.foreshowHolder> {
    private ArrayList<ShortFilmList> list;
    private Context context;

    public ForeshowAdapter(Context context) {
        list=new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<ShortFilmList> shortFilmLists){
        if (shortFilmLists!=null){
            list.addAll(shortFilmLists);
        }
    }

    @NonNull
    @Override
    public foreshowHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.foreshow_im_layout, null, false);
        return new foreshowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull foreshowHolder foreshowHolder, final int i) {
        ShortFilmList shortFilmList = list.get(i);
        foreshowHolder.tr.setUp(shortFilmList.videoUrl,null);
        Glide.with(context).load(shortFilmList.imageUrl).into(foreshowHolder.tr.ivThumb);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class foreshowHolder extends RecyclerView.ViewHolder{

        JCVideoPlayer tr;

        public foreshowHolder(@NonNull View itemView) {
            super(itemView);
            tr = itemView.findViewById(R.id.trailer_movie);
        }
    }


}
