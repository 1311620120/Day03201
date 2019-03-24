package com.example.day0320.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day0320.R;
import com.example.day0320.model.JsenBean;


import java.util.List;


public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder> {
    Context context;
    List<JsenBean.ResultBean.RxxpBean.CommodityListBean> jsonBean;
    public RxxpAdapter(Context context, List<JsenBean.ResultBean.RxxpBean.CommodityListBean> jsonBean) {
     this.context=context;
     this.jsonBean=jsonBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.lift, viewGroup, false);
        RxxpAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
          viewHolder.name.setText(jsonBean.get(i).getCommodityName());
        Glide.with(context)
                .load(jsonBean.get(i).getMasterPic())
                .into(viewHolder.img);
        viewHolder.pirce.setText(jsonBean.get(i).getPrice());

    }

    @Override
    public int getItemCount() {
        return jsonBean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView pirce;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=   itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            pirce = itemView.findViewById(R.id.pirce);
        }
    }
}
