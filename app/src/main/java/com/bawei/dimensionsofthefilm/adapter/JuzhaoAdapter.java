package com.bawei.dimensionsofthefilm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.model.MovieActor;
import com.bawei.dimensionsofthefilm.model.Particulars;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/*时间:2019/11/9
创建人:yang 
创建人:杨靖宇*/
public class JuzhaoAdapter extends RecyclerView.Adapter<JuzhaoAdapter.juzhaoHolder> {
    private static final String TAG = "JuzhaoAdapter";
    private ArrayList<String> list;
    private Context context;

    public JuzhaoAdapter(Context context) {
        list=new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<String> strings){
        if (strings!=null){
            list.addAll(strings);
        }
    }

    @NonNull
    @Override
    public juzhaoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.juzhao_layout, null, false);
        return new juzhaoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull juzhaoHolder uzhaoHolder, final int i) {
        Glide.with(context).load(list.get(i)).into(uzhaoHolder.img_juzhao);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class juzhaoHolder extends RecyclerView.ViewHolder{


        private final ImageView img_juzhao;

        public juzhaoHolder(@NonNull View itemView) {
            super(itemView);
            img_juzhao = itemView.findViewById(R.id.img_juzhao);

        }
    }



}
