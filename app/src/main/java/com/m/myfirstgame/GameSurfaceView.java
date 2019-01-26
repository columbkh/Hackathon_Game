package com.m.myfirstgame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private SurfaceHolder holder;
    private DrawingThread thread;
    private Paint paint;
    private GameController controller;

    public GameSurfaceView(Context context, GameController controller) {
        super(context);
        this.controller = controller;
        holder = getHolder();
        holder.addCallback(this);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
    }

    public int getSurfaceWidth() {
        return holder.getSurfaceFrame().width();
    }

    public int getSurfaceHeight() {
        return holder.getSurfaceFrame().height();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(0, getHeight());
        canvas.scale(1,-1);
        super.onDraw(canvas);
        controller.update();
        canvas.drawColor(Color.WHITE);
        for (Drawable obj : controller.getGame().getObjects()) {
            obj.draw(canvas, paint);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        controller.start();
        thread = new DrawingThread();
        thread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {


    }



    @SuppressLint("WrongCall")
    private class DrawingThread extends Thread {
        public void run() {
            while (true) {
                Canvas canvas = null;
                try {
                    canvas = holder.lockCanvas();
                    synchronized (holder) {
                        try {
                            onDraw(canvas);
                        } catch (Exception e ) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    if (canvas != null) {
                        holder.unlockCanvasAndPost(canvas);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


