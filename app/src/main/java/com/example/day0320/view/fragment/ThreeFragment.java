package com.example.day0320.view.fragment;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.day0320.R;
import com.example.day0320.model.LoginJson;
import com.example.day0320.presenter.LoginPresenter;
import com.example.day0320.view.activity.RegActivity;
import com.example.day0320.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/23 09:18:52
 * @Description:
 */
public class ThreeFragment extends Fragment implements IMainView ,View.OnClickListener {
    private EditText name;
    private EditText pwd;
    private ImageView img;
    private LoginPresenter loginPresenter;
    private View view;
    private LinearLayout iview;
    private LinearLayout zzz;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.threefragment, container, false);
              initData();
              initView();

        return view;
    }
    private void initData() {
        loginPresenter = new LoginPresenter(this);

       view.findViewById(R.id.login).setOnClickListener(this);
        view.findViewById(R.id.reg).setOnClickListener(this);
    }
    private void initView() {
        name = view.findViewById(R.id.name);
        pwd = view.findViewById(R.id.pwd);
        img = view.findViewById(R.id.img);
        iview = view.findViewById(R.id.view);
        zzz = view.findViewById(R.id.zzz);

    }

    @Override
    public void onSuccess(Object o) {
        LoginJson loginJson =(LoginJson) o;
        if (loginJson.getStatus().equals("0000")){
            Toast.makeText(getActivity(),"登陆成功",Toast.LENGTH_SHORT).show();
         iview.setVisibility(View.VISIBLE);
            zzz.setVisibility(View.GONE);

            Glide.with(this).load("http://172.17.8.100/images/small/default/user.jpg").into(img);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ObjectAnimator rotation = ObjectAnimator.ofFloat(img, "rotation", 0, 360);
                    rotation.setDuration(3000);
                    rotation.start();
                }

            });
        }else {
            Toast.makeText(getActivity(),"密码错误",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFail(String err) {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.login:
                String nname = name.getText().toString().trim();
                String pass = pwd.getText().toString().trim();
                loginPresenter.LoginData(nname,pass);
                loginPresenter.setView(this);
                break;
            case  R.id.reg:
                Intent intent = new Intent(getActivity(), RegActivity.class);
                startActivity(intent);
        }
    }
}
