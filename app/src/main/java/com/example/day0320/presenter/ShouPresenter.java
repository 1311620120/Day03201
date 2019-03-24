package com.example.day0320.presenter;

import android.util.Log;

import com.example.day0320.model.Constant;
import com.example.day0320.model.DataBean;
import com.example.day0320.model.HttpUitls;

import com.example.day0320.view.activity.LoginActivity;
import com.example.day0320.view.fragment.OneFragment;
import com.example.day0320.view.interfaces.IMainView;


public class ShouPresenter extends BasePresenter<IMainView<DataBean>> {

    private final HttpUitls instance;

    public ShouPresenter(OneFragment oneFragment){
        instance = HttpUitls.getInstance();


    }

    public  void ShowData(String keyword,int page,int count){
        instance.getData(Constant.SHOU + "?" + "keyword=" + keyword + "&" + "page=" + page + "&" + "count=" + count, DataBean.class, new HttpUitls.CallBackData() {
            @Override
            public void onResponse(Object o) {
                getView().onSuccess((DataBean)o);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }
}
