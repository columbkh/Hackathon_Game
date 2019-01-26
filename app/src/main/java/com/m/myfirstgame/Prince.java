package com.m.myfirstgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

public class Prince extends GameObject {

    private final static int PRINCE_COLOR = Color.RED;
    private float width = 20f;
    private float height = 30f;
    private float speed = 10f;

    public Prince(float x, float y) {
        super(x, y);
    }

    @Override
    public RectF getBoundingRect() {
        return new RectF(x, y, x + width, y + height);
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(PRINCE_COLOR);
        canvas.drawRect(getBoundingRect(), paint);
        Log.e("Coordinates", Float.toString(x) + "     " + Float.toString(y) + "   " + Float.toString(speed));
    }

    public void updatePosition() {
        this.x -= speed;
    }



}
