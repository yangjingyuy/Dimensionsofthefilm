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
import com.bawei.dimensionsofthefilm.model.Jijiangshangying;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Myrecyclview extends RecyclerView.Adapter<Myrecyclview.myViewHolder> {
    private ArrayList<Jijiangshangying> list ;
    private Context context;
    private View view;

    public Myrecyclview( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<Jijiangshangying> jijiangshangyings){
        if (jijiangshangyings!=null){
            list.addAll(jijiangshangyings);
        }
    }

    @NonNull
    @Override
    public Myrecyclview.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.jijiangshangshi_layout,viewGroup,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myrecyclview.myViewHolder myViewHolder, int i) {
        Glide.with(context).load(list.get(i).imageUrl)
                .skipMemoryCache(true)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(myViewHolder.imageView);

        myViewHolder.textView.setText(list.get(i).name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final ImageView imageView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_name);
            imageView = itemView.findViewById(R.id.imager);

        }
    }
}

