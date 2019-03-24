package com.example.day0320.view.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/23 08:45:05
 * @Description:
 */
public class MyView extends View {

    private Paint mpaint;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        mpaint = new Paint();
        mpaint.setColor(Color.RED);
        mpaint.setAntiAlias(true);
        mpaint.setStyle(Paint.Style.FILL);

    }

    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100,100,100,mpaint);
    }
}
