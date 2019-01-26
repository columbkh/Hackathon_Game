package com.m.myfirstgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Ball extends GameObject {
    private float speedX;
    private float speedY;
    private float gravity;
    private boolean run = false;
    private float radius = 20f;
    private static int BALL_COLOR = Color.BLACK;
    private static float INIT_X = 100;
    private float INIT_Y = 600;

    public Ball(float speedX, float speedY, float gravity, int height) {
        super(INIT_X, (float)(height-100));
        this.speedX = speedX;
        this.speedY = speedY;
        this.gravity = gravity;
   }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public void rebound() {
        n = 0;
    }




    public void updatePosition() {
        if (run) {
            this.x += speedX;
            this.y += (-gravity*n + speedY - gravity/2);
            n += 1;
        }

    }

    public RectF getBoundingRect() {
        return new RectF(x - radius, y - radius, x + radius, y + radius);
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(BALL_COLOR);
        canvas.drawCircle(x, y, radius, paint);
        /*Log.e("Coordinates", Float.toString(x) + "     " + Float.toString(y) + "   " + Float.toString(speedX) + "  " + Float.toString(speedY) +
              "  " +  Float.toString(n));*/
    }


}
