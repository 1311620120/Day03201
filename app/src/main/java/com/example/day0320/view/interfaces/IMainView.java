package com.example.day0320.view.interfaces;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/20 08:47:02
 * @Description:
 */
public interface IMainView<T> {
    void  onSuccess(T t);

    void  onFail(String err);
}
