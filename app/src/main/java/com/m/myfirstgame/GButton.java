package com.m.myfirstgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GButton extends StaticObject{

    private final static int BUTTON_COLOR = Color.RED;

/*
    public Matrix btn_matrix = new Matrix();

    public RectF btn_rect;
*/


    public GButton(float x, float y, float width, float height)
    {
        super(x,y, width, height);

    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(BUTTON_COLOR);
        canvas.drawRect(getBoundingRect(), paint);
    }
}
