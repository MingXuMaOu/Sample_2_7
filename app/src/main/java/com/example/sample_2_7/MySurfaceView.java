package com.example.sample_2_7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

/**
 * @author: liuming
 * @date: 2022/2/17
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private MainActivity mActivity;
    private Paint mPaint;
    private Path mPath;
    private Path mPath1;

    public MySurfaceView(Context context) {
        super(context);
        mActivity = (MainActivity) context;
        getHolder().addCallback(this);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mPath = new Path();
        mPath.moveTo(350,20);
        mPath.lineTo(520,20);
        mPath.lineTo(500,170);
        mPath.lineTo(330,170);
        mPath.lineTo(350,20);

        mPath1 = new Path();
        mPath1.moveTo(170, 50);
        mPath1.lineTo(260, 50);
        mPath1.lineTo(240, 120);
        mPath1.lineTo(150, 120);
        mPath1.lineTo(170, 50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(0,0,0,0);

        canvas.save();
        canvas.clipRect(30,20,280,250);
        canvas.drawColor(Color.WHITE);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(85,75,50,mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(170,150,260,240,mPaint);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mPath1,mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipPath(mPath);
        Bitmap bm = BitmapFactory.decodeResource(mActivity.getResources(),R.drawable.tubiao);
        canvas.drawBitmap(bm,10,20,mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipRect(30,300,180,450);
        canvas.clipRect(55,325,155,425,Region.Op.DIFFERENCE);
        canvas.drawBitmap(bm,33,130,mPaint);
        canvas.restore();

        canvas.save();
        mPath.reset();
        mPath.addCircle(470,479,240,Path.Direction.CCW);
        canvas.clipPath(mPath);
        canvas.drawBitmap(bm,130,150,mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipRect(80,790,600,960);
        canvas.clipRect(270,790,430,1200,Region.Op.INTERSECT);
        canvas.drawColor(Color.RED);
        canvas.drawBitmap(bm,110,450,mPaint);
        canvas.restore();
    }

    @SuppressLint("WrongCall")
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();
        try{
            synchronized (holder){
                onDraw(canvas);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(canvas != null){
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
