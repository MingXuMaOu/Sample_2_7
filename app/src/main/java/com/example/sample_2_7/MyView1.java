package com.example.sample_2_7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author: liuming
 * @date: 2022/2/17
 */
public class MyView1 extends View {

    private Bitmap mBitmap;
    private Paint mPaint;

    public MyView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initBitmap();
    }
    private void initBitmap(){
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.img);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(15);
        canvas.drawBitmap(mBitmap,10,10,mPaint);
        canvas.save();
        Matrix m1 = new Matrix();
        m1.setTranslate(500,10);
        Matrix m2 = new Matrix();
        m2.setRotate(15);
        Matrix m3 = new Matrix();
        m3.setConcat(m1,m2);
        m1.setScale(0.8f,0.8f);
        m2.setConcat(m3,m1);
        canvas.drawBitmap(mBitmap,m2,mPaint);
        canvas.restore();
        canvas.save();
        mPaint.setAlpha(180);
        m1.setTranslate(200,100);
        m2.setScale(1.3f,1.3f);
        m3.setConcat(m1,m2);
        canvas.drawBitmap(mBitmap,m3,mPaint);
        mPaint.reset();
        mPaint.setTextSize(40);
        mPaint.setColor(0xffFFFFFF);
        canvas.drawText("图片宽度：" + mBitmap.getWidth(),20,220,mPaint);
        canvas.drawText("图片高度：" + mBitmap.getHeight(),20,420,mPaint);
        mPaint.reset();
    }
}
