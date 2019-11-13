package com.bawei.dimensionsofthefilm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.model.Area;
import com.bawei.dimensionsofthefilm.model.AreaQuery;

import java.util.ArrayList;
import java.util.List;

/*时间:2019/11/9
创建人:yang 
创建人:杨靖宇*/
public class AreaQueryAdapter extends RecyclerView.Adapter<AreaQueryAdapter.areaqueryHolder> {
    private ArrayList<AreaQuery> list;
    private Context context;

    public AreaQueryAdapter(Context context) {
        list=new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<AreaQuery> areaQueries){
        if (areaQueries!=null){
            list.addAll(areaQueries);
        }
    }

    @NonNull
    @Override
    public areaqueryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.area_quer_layout, null, false);
        return new areaqueryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull areaqueryHolder areaHolder, final int i) {
            areaHolder.area_query_name.setText(list.get(i).name);

          areaHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     onActi.onActi(v,i);

                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    class areaqueryHolder extends RecyclerView.ViewHolder{

        private final TextView area_query_name;

        public areaqueryHolder(@NonNull View itemView) {
            super(itemView);
            area_query_name = itemView.findViewById(R.id.area_query_name);
        }
    }

    /**
     *
     */

private  OnActi onActi;

    public void setOnActi(OnActi onActi) {
        this.onActi = onActi;
    }

    //定义接口
    public interface OnActi{
        void onActi(View v,int i);
    }

}
