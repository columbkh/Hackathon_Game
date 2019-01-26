package com.m.myfirstgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Turm extends StaticObject {
    private final static int TURM_COLOR = Color.DKGRAY;

    public Turm(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(TURM_COLOR);
        canvas.drawRect(this.boundingRect, paint);
    }

}
