package com.example.day0320.presenter;


import com.example.day0320.model.Constant;
import com.example.day0320.model.HttpUitls;
import com.example.day0320.model.RegJson;
import com.example.day0320.view.activity.RegActivity;
import com.example.day0320.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/26 08:54:20
 * @Description:
 */
public class RegPresenter extends BasePresenter<IMainView<RegJson>> {

    private final HttpUitls intanstance;

    public  RegPresenter(RegActivity regActivity){
        intanstance = HttpUitls.getInstance();

    }
    public  void getRegData(String name, String pwd){
        intanstance.setData(Constant.REG, RegJson.class, name, pwd, new HttpUitls.CallBackData() {
            @Override
            public void onResponse(Object o) {
                getView().onSuccess((RegJson)o);
            }

            @Override
            public void onFail(String err) {

            }


        });
    }
}
