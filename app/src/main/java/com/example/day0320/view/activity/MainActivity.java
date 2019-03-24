package com.example.day0320.view.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.day0320.R;
import com.example.day0320.view.interfaces.IMainView;

public class MainActivity extends AppCompatActivity {

    private MyView mview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mview = findViewById(R.id.view);


    }

    private void initData() {
        mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animatorx = ObjectAnimator.ofFloat(mview , "translationX" , 0 ,  450);
                ObjectAnimator animatory = ObjectAnimator.ofFloat(mview , "translationY" , 0 , 1000);
                ObjectAnimator Animator2 = ObjectAnimator.ofFloat(mview,"alpha",0,1,0,1);
                animatorx.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animatorx).with(animatory).with(Animator2);
                animatorSet.setDuration(3000);
                animatorSet.start();
            }
        });

    }


}
