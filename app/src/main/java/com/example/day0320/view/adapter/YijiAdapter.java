package com.example.day0320.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.day0320.R;
import com.example.day0320.model.YijiBean;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/23 15:15:08
 * @Description:
 */
public class YijiAdapter extends RecyclerView.Adapter<YijiAdapter.ViewHolder> {
    Context context;
    YijiBean yijiBean;
    public YijiAdapter(Context context, YijiBean yijiBean) {
      this.context=context;
      this.yijiBean=yijiBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.left, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.leftname.setText(yijiBean.getResult().get(position).getName());
//        final List<YijiBean.ResultBean> list = yijiBean.getResult();
//        holder.leftname.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.CallBack(position,list);
//            }
//        });

    }



    @Override
    public int getItemCount() {
        return yijiBean.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView leftname;

        public ViewHolder(View itemView) {
            super(itemView);
            leftname = itemView.findViewById(R.id.name);

        }
    }
//public interface ClickListener{
//    void CallBack(int position, List<YijiBean.ResultBean> fenLeiBean);
//}
//    ClickListener listener;
//    public void ClickListener(ClickListener listener)
//    {
//        this.listener =listener;
//    }
}
