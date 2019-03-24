package com.example.day0320.presenter;

import com.example.day0320.model.Constant;
import com.example.day0320.model.HttpUitls;
import com.example.day0320.model.YijiBean;
import com.example.day0320.view.fragment.TwoFragment;
import com.example.day0320.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/23 14:33:15
 * @Description:
 */
public class YijiPresenter extends  BasePresenter<IMainView<YijiBean>> {

    private final HttpUitls instance;

    public  YijiPresenter(TwoFragment twoFragment){
        instance = HttpUitls.getInstance();

     }
//     public  void ShouYiji(){
//           instance.getData(Constant.YIJI, YijiBean.class, new HttpUitls.CallBackData() {
//               @Override
//               public void onResponse(Object o) {
//                   getView().onSuccess((YijiBean) o);
//               }
//
//               @Override
//               public void onFail(String err) {
//
//               }
//           });
//     }
}
