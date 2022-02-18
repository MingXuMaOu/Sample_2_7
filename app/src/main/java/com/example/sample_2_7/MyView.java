package com.example.sample_2_7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author: liuming
 * @date: 2022/2/17
 */
public class MyView extends View {
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawRect(10,10,330,330,paint);
        paint.setTextSize(50);
        canvas.drawText("这是字符串",10,450,paint);
        RectF rf1 = new RectF(10,530,210,730);
        canvas.drawArc(rf1,0,45,true,paint);
        canvas.drawLine(350,10,550,210,paint);
        RectF rf2 = new RectF(450,550,650,750);
        canvas.drawOval(rf2,paint);
    }
}
