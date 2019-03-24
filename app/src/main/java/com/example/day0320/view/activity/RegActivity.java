package com.example.day0320.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.day0320.R;
import com.example.day0320.model.RegJson;
import com.example.day0320.presenter.RegPresenter;
import com.example.day0320.view.interfaces.IMainView;

public class RegActivity extends AppCompatActivity implements IMainView,View.OnClickListener {

    private EditText name;
    private EditText pwd;
    private RegPresenter regPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
        initData();
    }


    private void initData() {
        regPresenter = new RegPresenter(this);
        findViewById(R.id.login).setOnClickListener(this);
    }

    private void initView() {
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);


    }


    @Override
    public void onSuccess(Object o) {
        RegJson regJson = (RegJson) o;
        if (regJson.getStatus().equals("0000")) {
            Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(RegActivity.this, "注册错误", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    public void onFail(String err) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String nname = name.getText().toString().trim();
                String pass = pwd.getText().toString().trim();
                regPresenter.getRegData(nname, pass);
                regPresenter.setView(this);
                break;
        }
    }
}