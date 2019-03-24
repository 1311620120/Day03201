package com.example.day0320.presenter;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/20 08:48:32
 * @Description:
 */
public class BasePresenter<V> {

    private  V view;

    public void setView(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }
    public  void  detach(){
        this.view=null;
    }
}
