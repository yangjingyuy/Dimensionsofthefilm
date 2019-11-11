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
import com.bawei.dimensionsofthefilm.model.Hot;

import java.util.ArrayList;
import java.util.List;

/*时间:2019/11/9
创建人:yang 
创建人:杨靖宇*/
public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.areaHolder> {
    private ArrayList<Area> list;
    private Context context;

    public AreaAdapter(Context context) {
        list=new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<Area> areas){
        if (areas!=null){
            list.addAll(areas);
        }
    }

    @NonNull
    @Override
    public areaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.area_layout, null, false);
        return new areaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull areaHolder areaHolder, final int i) {
            areaHolder.area_name.setText(list.get(i).regionName);
            areaHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onActi.onActi(list.get(i).regionId);
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class areaHolder extends RecyclerView.ViewHolder{

        private final TextView area_name;

        public areaHolder(@NonNull View itemView) {
            super(itemView);
            area_name = itemView.findViewById(R.id.area_name);
        }
    }

    public OnActi onActi;

    public void setOnActi(OnActi onActi) {
        this.onActi = onActi;
    }

    //定义接口
    public interface OnActi{
        void onActi(int i);
    }

}
