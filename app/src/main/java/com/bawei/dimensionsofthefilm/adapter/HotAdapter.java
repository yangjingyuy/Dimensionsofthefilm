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
import com.bawei.dimensionsofthefilm.model.Hot;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/*时间:2019/11/7
创建人:yang 
创建人:杨靖宇
热门电影
*/
public class HotAdapter extends RecyclerView.Adapter<HotAdapter.HotHoder> {
    private ArrayList<Hot> list;
    private Context context;

    public HotAdapter( Context contextl) {
        list=new ArrayList<>();
        this.context = contextl;
    }
    public void addAll(List<Hot> hots){
        if (hots!=null){
            list.addAll(hots);
        }
    }
    @NonNull
    @Override
    public HotHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_layout, null, false);
        return new HotHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotHoder hotHoder, int i) {
        Hot hot = list.get(i);
        Glide.with(context).load(hot.imageUrl).into(hotHoder.hot_img);
        hotHoder.hot_name.setText(list.get(i).name);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class HotHoder extends RecyclerView.ViewHolder{

        private final ImageView hot_img;
        private final TextView hot_name;

        public HotHoder(@NonNull View itemView) {
            super(itemView);
            hot_img = itemView.findViewById(R.id.hot_img);
            hot_name = itemView.findViewById(R.id.hot_name);
        }
    }
}
