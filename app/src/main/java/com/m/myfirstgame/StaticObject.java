package com.m.myfirstgame;

import android.graphics.RectF;

public abstract class StaticObject extends GameObject {

    protected RectF boundingRect;
    protected float width, height;

    public StaticObject(float x, float y, float width, float height) {
        super(x, y);
        this.width = width;
        this.height = height;

        this.boundingRect = new RectF(x, y, x + width, y + height);
    }

    public RectF getBoundingRect() {
        return new RectF(boundingRect);
    }

}
