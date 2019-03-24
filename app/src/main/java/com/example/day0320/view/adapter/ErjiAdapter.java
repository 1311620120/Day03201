package com.example.day0320.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.day0320.R;
import com.example.day0320.model.TwoBean;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/23 15:15:55
 * @Description:
 */
public class ErjiAdapter extends RecyclerView.Adapter <ErjiAdapter.ViewHolder>{
    Context context; TwoBean twoBean;
    public ErjiAdapter(Context context, TwoBean twoBean) {
    this.context=context;
    this.twoBean = twoBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rightname.setText(twoBean.getResult().get(position).getName());
    }


    @Override
    public int getItemCount() {
        return twoBean.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView rightname;

        public ViewHolder(View itemView) {
            super(itemView);

            rightname = itemView.findViewById(R.id.name);
        }
    }
}
