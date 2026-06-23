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
    public int botaoSelecionado;
    List<Paint> mPaintList;
    List<Path> mPathList;
    Paint currentPaint;
    Path currentPath;
    ColorDrawable currentColor;

    float startX, startY;

    public void setup(){
        mPaintList=new ArrayList<Paint>();
        mPathList=new ArrayList<Path>();
        currentColor=new ColorDrawable();
        currentColor.setColor(Color.BLACK);
        initlayerDraw();
    }

    public SimplePaint(Context context) {
        super(context);
        setup();
    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();

    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();

    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();

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
        canvas.drawPath(currentPath, currentPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ly, lx;
        lx = event.getX();
        ly = event.getY();

        switch (botaoSelecionado) {

            case 1:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        currentPath.moveTo(lx, ly);
                        startX = lx;
                        startY = ly;
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        currentPath.reset();
                        currentPath.moveTo(startX, startY);
                        currentPath.lineTo(lx, ly);
                        break;

                    case MotionEvent.ACTION_UP:
                        mPaintList.add(currentPaint);
                        mPathList.add(currentPath);
                        initLayerDraw();
                        break;
                }
                break;

            case 2:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = lx;
                        startY = ly;
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        float radiusMove = (float) Math.sqrt(
                                Math.pow(lx - startX, 2) +
                                        Math.pow(ly - startY, 2)
                        );
                        currentPath.reset();
                        currentPath.addCircle(startX, startY, radiusMove, Path.Direction.CW);
                        break;

                    case MotionEvent.ACTION_UP:
                        float radiusEnd = (float) Math.sqrt(
                                Math.pow(lx - startX, 2) +
                                        Math.pow(ly - startY, 2)
                        );
                        currentPath.reset();
                        currentPath.addCircle(startX, startY, radiusEnd, Path.Direction.CW);

                        mPaintList.add(currentPaint);
                        mPathList.add(currentPath);
                        initLayerDraw();
                        break;
                }
                break;

            case 3:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = lx;
                        startY = ly;
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        float left = Math.min(startX, lx);
                        float top = Math.min(startY, ly);
                        float right = Math.max(startX, lx);
                        float bottom = Math.max(startY, ly);

                        currentPath.reset();
                        currentPath.addRect(left, top, right, bottom, Path.Direction.CW);
                        break;

                    case MotionEvent.ACTION_UP:
                        float L = Math.min(startX, lx);
                        float T = Math.min(startY, ly);
                        float R = Math.max(startX, lx);
                        float B = Math.max(startY, ly);

                        currentPath.reset();
                        currentPath.addRect(L, T, R, B, Path.Direction.CW);

                        mPaintList.add(currentPaint);
                        mPathList.add(currentPath);
                        initLayerDraw();
                        break;
                }
                break;
        }
        invalidate();
        return true;
    }

    private void initLayerDraw() {
    }

    public void limparPaint(){
        mPaintList.clear();
        mPathList.clear();
        currentPath.reset();
        invalidate();
    }
    public void setColor(int color) {
        currentColor.setColor(color);
        currentPaint.setColor(color);
    }
}

