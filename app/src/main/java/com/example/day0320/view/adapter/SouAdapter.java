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
import com.example.day0320.model.DataBean;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/23 12:37:12
 * @Description:
 */
public class SouAdapter extends RecyclerView.Adapter<SouAdapter.ViewHolder> {
    Context context; List<DataBean.ResultBean> list;
    public SouAdapter(Context context, List<DataBean.ResultBean> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lift, parent, false);
        SouAdapter.ViewHolder viewHolder = new SouAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getCommodityName());
        Glide.with(context)
                .load(list.get(position).getMasterPic())
                .into(holder.img);
        holder.pirce.setText(list.get(position).getPrice());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView pirce;
        public ViewHolder(View itemView) {
            super(itemView);
            img=   itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            pirce = itemView.findViewById(R.id.pirce);
        }
    }
}
