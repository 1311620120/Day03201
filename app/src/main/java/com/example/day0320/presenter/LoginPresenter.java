package com.example.day0320.presenter;


import com.example.day0320.model.Constant;
import com.example.day0320.model.HttpUitls;
import com.example.day0320.model.LoginJson;
import com.example.day0320.view.fragment.ThreeFragment;
import com.example.day0320.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/26 08:59:36
 * @Description:
 */
public class LoginPresenter extends  BasePresenter<IMainView<LoginJson>> {

    private  HttpUitls instance;

    public  LoginPresenter(ThreeFragment threeFragment){
       instance = HttpUitls.getInstance();

    }
      public  void LoginData(String name, String pwd){
          instance.setData(Constant.LOGIN, LoginJson.class, name, pwd, new HttpUitls.CallBackData() {
              @Override
              public void onResponse(Object o) {
                getView().onSuccess((LoginJson)o);
              }

              @Override
              public void onFail(String err) {

              }


        });
      }

}
