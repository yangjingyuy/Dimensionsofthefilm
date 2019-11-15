package com.bawei.dimensionsofthefilm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.model.Area;
import com.bawei.dimensionsofthefilm.model.Filmreview;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*时间:2019/11/9
创建人:yang 
创建人:杨靖宇*/
public class FilmreviewAdapter extends RecyclerView.Adapter<FilmreviewAdapter.filmreviewHolder> {
    private ArrayList<Filmreview> list;
    private Context context;

    public FilmreviewAdapter(Context context) {
        list=new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<Filmreview> filmreviews){
        if (filmreviews!=null){
            list.addAll(filmreviews);
        }
    }

    @NonNull
    @Override
    public filmreviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fillmreview_layout, null, false);
        return new filmreviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull filmreviewHolder filmreviewHolder, final int i) {
        Filmreview filmreview = list.get(i);


   /*     Glide.with(getContext()).load("http://www.qqzhi.com/uploadpic/2014-09-12/094013726.jpg").asBitmap().centerCrop().into(new BitmapImageViewTarget(iv_user_head) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                iv_user_head.setImageDrawable(circularBitmapDrawable);
            }

        } ;*/
        Glide.with(context).load(filmreview.commentHeadPic).into(filmreviewHolder.com_head);
        filmreviewHolder.com_name.setText(list.get(i).commentUserName);
        Date date = new Date(list.get(i).commentTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        filmreviewHolder.com_time.setText(format.format(date));
        filmreviewHolder.com_content.setText(list.get(i).commentContent);
        filmreviewHolder.com_reply.setText("等" + list.get(i).commentId + "人觉得很赞");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class filmreviewHolder extends RecyclerView.ViewHolder{


        ImageView com_head;
        TextView com_name, com_time, com_content, com_reply;

        public filmreviewHolder(@NonNull View itemView) {
            super(itemView);


            com_head = itemView.findViewById(R.id.com_head);
            com_name = itemView.findViewById(R.id.com_name);
            com_time = itemView.findViewById(R.id.com_time);
            com_content = itemView.findViewById(R.id.com_content);
            com_reply = itemView.findViewById(R.id.com_reply);


        }
    }


}
