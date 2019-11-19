package com.bawei.dimensionsofthefilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.model.Hot;
import com.bawei.dimensionsofthefilm.view.XzyingyuanActivity;
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
    public void onBindViewHolder(@NonNull HotHoder hotHoder, final int i) {
        final Hot hot = list.get(i);
        Glide.with(context).load(hot.imageUrl).into(hotHoder.hot_img);
        hotHoder.hot_name.setText(list.get(i).name);

        //setOnClickListener
        hotHoder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v,i);
            }
        });
        hotHoder.gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, XzyingyuanActivity.class);
                intent.putExtra("keyy",hot.movieId);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class HotHoder extends RecyclerView.ViewHolder{

        private final ImageView hot_img;
        private final TextView hot_name;
        private final Button gp;

        public HotHoder(@NonNull View itemView) {
            super(itemView);

            hot_img = itemView.findViewById(R.id.hot_img);
            hot_name = itemView.findViewById(R.id.hot_name);
            gp = itemView.findViewById(R.id.gp);
        }
    }
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    //定义接口
    public interface OnItemClickListener{
        void onClick(View view,int position);
    }
}
