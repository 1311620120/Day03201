package com.example.day0320.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day0320.R;
import com.example.day0320.model.TwoBean;
import com.example.day0320.model.YijiBean;

import com.example.day0320.presenter.TwoPresenter;
import com.example.day0320.presenter.YijiPresenter;
import com.example.day0320.view.adapter.ErjiAdapter;
import com.example.day0320.view.adapter.YijiAdapter;
import com.example.day0320.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/23 09:18:52
 * @Description:
 */
public class TwoFragment extends Fragment implements IMainView {

    private View view;
    private RecyclerView fen1;
    private RecyclerView fen2;
    private YijiPresenter yijiPresenter;
    private TwoPresenter twoPresenter;
    int firstCategoryId =1001005;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.twofragment, container, false);

 initView();

 initData();

        return this.view;
    }

    private void initView() {
        //左侧布局
        fen1 = view.findViewById(R.id.fen1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        fen1.setLayoutManager(linearLayoutManager);


        //右侧布局
        fen2 = view.findViewById(R.id.fen2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        fen2.setLayoutManager(gridLayoutManager);
    }

    private void initData() {
//        yijiPresenter = new YijiPresenter(this);
//        yijiPresenter.ShouYiji();
//        yijiPresenter.setView(this);

        twoPresenter = new TwoPresenter(this);
        twoPresenter.ShowTwo(firstCategoryId);
        twoPresenter.setView(this);

    }

    @Override
    public void onSuccess(Object o) {
//        if(o instanceof YijiBean)
//        {
//            final YijiBean yijiBean =(YijiBean)o;
//            YijiAdapter yijiAdapter = new YijiAdapter(getActivity(),yijiBean);
//
//            fen1.setAdapter(yijiAdapter);
//        }
//        if(o instanceof TwoBean)
//        {
            final TwoBean twoBean =(TwoBean)o;
            ErjiAdapter erjiAdapter = new ErjiAdapter(getActivity(), twoBean);
            fen2.setAdapter(erjiAdapter);
      //  }



//        yijiAdapter.ClickListener(new YijiAdapter.ClickListener() {
//            @Override
//            public void CallBack(int position, List<YijiBean.ResultBean> fenLeiBean) {


//        }
//        });
        }

    @Override
    public void onFail(String err) {

    }
}
