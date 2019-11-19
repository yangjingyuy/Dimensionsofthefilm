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
import com.bawei.dimensionsofthefilm.model.Inquiree;
import com.bawei.dimensionsofthefilm.model.Jijiangshangying;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class SeekAdapter extends RecyclerView.Adapter<SeekAdapter.seekHolder> {
    private ArrayList<Inquiree> list ;
    private Context context;
    private View view;

    public SeekAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<Inquiree> inquirees){
        if (inquirees!=null){
            list.addAll(inquirees);
        }
    }

    @NonNull
    @Override
    public SeekAdapter.seekHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.seek_layout,viewGroup,false);
        return new seekHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull seekHolder seekHolder, final int i) {
        Inquiree inquiree = list.get(i);
        Glide.with(context).load(inquiree.imageUrl) .into(seekHolder.seek_imager);
        seekHolder.seek_name.setText(inquiree.name);
        seekHolder.seek_director.setText(inquiree.director);
        seekHolder.seek_starring.setText(inquiree.starring);
        seekHolder.seek_score.setText("评分: "+inquiree.score+"分");
        /*seek_starring*/

    /*    Glide.with(context).load(list.get(i).imageUrl)
                .skipMemoryCache(true)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)


        myViewHolder.textView.setText(list.get(i).name);
        Date date = new Date(list.get(i).releaseTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        myViewHolder.text_time.setText(simpleDateFormat.format(date)+"上映");
        myViewHolder.text_guankan.setText(list.get(i).wantSeeNum+"人想看");*/
        //setOnClickListener
   /*     myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerSying.onClick(v,i);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class seekHolder extends RecyclerView.ViewHolder{

        private final TextView seek_name,seek_director,seek_starring,seek_score;
        private final ImageView seek_imager;


        public seekHolder(@NonNull View itemView) {
            super(itemView);
            seek_name = itemView.findViewById(R.id.seek_name);
            seek_imager = itemView.findViewById(R.id.seek_imager);
            seek_director = itemView.findViewById(R.id.seek_director);
            seek_starring = itemView.findViewById(R.id.seek_starring);
            seek_score = itemView.findViewById(R.id.seek_score);
        }
    }

 /*   private OnItemClickListener listenerSying;

    public void setListenerSying(OnItemClickListener listenerSying) {
        this.listenerSying = listenerSying;
    }

    //定义接口
    public interface OnItemClickListener{
        void onClick(View view, int position);
    }*/
}

