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
import com.bawei.dimensionsofthefilm.model.Guanzhu;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Myguanzhuadapter extends RecyclerView.Adapter<Myguanzhuadapter.myViewHolder> {

      private ArrayList<Guanzhu> list;
      private Context context;
    private View view;

    public Myguanzhuadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
     public void addAll(List<Guanzhu> guanzhus){
        if (guanzhus!=null){
            list.addAll(guanzhus);
        }
     }


    @NonNull
    @Override
    public Myguanzhuadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.text1_layout,viewGroup,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myguanzhuadapter.myViewHolder myViewHolder, int i) {
        Glide.with(context).load(list.get(i).imageUrl).into(myViewHolder.imageView6);

         myViewHolder.textView6.setText(list.get(i).director);
         myViewHolder.textView7.setText(list.get(i).starring);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView6;
        private final TextView textView6;
        private final TextView textView7;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView6 = itemView.findViewById(R.id.imager6);
            textView7 = itemView.findViewById(R.id.text_name7);
            textView6 = itemView.findViewById(R.id.text_name6);
        }
    }
}
