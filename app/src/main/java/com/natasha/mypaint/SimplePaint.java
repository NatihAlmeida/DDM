package com.natasha.mypaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.hardware.lights.LightState;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimplePaint extends View {
    List<Paint> mPaintList;
    List<Path> mPathList;
    Paint currentPaint;
    Path currentPath;
    ColorDrawable currentColor;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaintList=new ArrayList<Paint>();
        mPathList=new ArrayList<Path>();
        currentColor=new ColorDrawable();
        currentColor.setColor(Color.BLACK);
        initlayerDraw();
    }
    public void initlayerDraw(){
        //configurando paint
        currentPaint=new Paint();
        currentPath=new Path();
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeWidth(20);
        currentPaint.setColor(currentColor.getColor());

    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(currentPath, currentPaint);
        for (int i=0; i<mPathList.size();i++){
            canvas.drawPath(mPathList.get(i), mPaintList.get(i));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ly, lx;
        lx = event.getX();
        ly = event.getY();

        switch (event.getAction()) {
            case (MotionEvent.ACTION_DOWN):
                currentPath.moveTo(lx, ly);
                currentPath.lineTo(lx, ly);
                break;
            case (MotionEvent.ACTION_MOVE):
                currentPath.lineTo(lx, ly);
                break;
            case (MotionEvent.ACTION_UP):
                currentPath.lineTo(lx, ly);
                mPaintList.add(currentPaint);
                mPathList.add(currentPath);
                currentPaint=new Paint();
                currentPath=new Path();
                initlayerDraw();
                break;
            default:
                break;
        }
        invalidate();
        return true;
    }

    public void setColor(int color) {
        currentColor.setColor(color);
        currentPaint.setColor(color);
    }
}

