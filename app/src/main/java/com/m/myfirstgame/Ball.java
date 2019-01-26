package com.m.myfirstgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Ball extends GameObject {
    private float speedX;
    private float speedY;
    private float gravity;
    private float radius = 50f;
    private static int BALL_COLOR = Color.BLACK;
    private static float INIT_X = 100;
    private static float INIT_Y = 100;

    public Ball(float speedX, float speedY, float gravity) {
        super(INIT_X, INIT_Y);
        this.speedX = speedX;
        this.speedY = speedY;
        this.gravity = gravity;
    }

    public void updatePosition() {
        this.x += speedX;
        this.y += (-gravity*n + speedY - gravity/2);
    }

    public RectF getBoundingRect() {
        return new RectF(x - radius, y - radius, x + radius, y + radius);
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(BALL_COLOR);
        canvas.drawCircle(x, y, radius, paint);
    }


}
