package com.example.day0320.presenter;

import com.example.day0320.model.Constant;
import com.example.day0320.model.HttpUitls;
import com.example.day0320.model.JsenBean;
import com.example.day0320.view.fragment.OneFragment;
import com.example.day0320.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/20 08:49:50
 * @Description:
 */
public class MainPresenter extends BasePresenter <IMainView<JsenBean> >{

     private final HttpUitls instance;

     public MainPresenter(OneFragment oneFragment){
          instance = HttpUitls.getInstance();
     }

     public  void  getShowData(){
          instance.getData(Constant.BASE_URL, JsenBean.class, new HttpUitls.CallBackData() {
               @Override
               public void onResponse(Object o) {
                  getView().onSuccess((JsenBean)o);
               }

               @Override
               public void onFail(String err) {

               }
          });

     }
}
