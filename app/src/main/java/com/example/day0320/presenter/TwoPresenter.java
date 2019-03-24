package com.example.day0320.presenter;

import com.example.day0320.model.Constant;
import com.example.day0320.model.TwoBean;
import com.example.day0320.model.HttpUitls;
import com.example.day0320.view.fragment.TwoFragment;
import com.example.day0320.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/23 16:21:57
 * @Description:
 */
public class TwoPresenter extends BasePresenter<IMainView<TwoBean>> {

    private final HttpUitls instance;

    public  TwoPresenter(TwoFragment twoFragment){
        instance = HttpUitls.getInstance();

    }

    public  void ShowTwo(int firstCategoryId){
        instance.getData(Constant.ERJI+"?"+"firstCategoryId="+firstCategoryId, TwoBean.class, new HttpUitls.CallBackData<TwoBean>() {


            @Override
            public void onResponse(TwoBean twoBean) {
                getView().onSuccess(twoBean);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }
}
