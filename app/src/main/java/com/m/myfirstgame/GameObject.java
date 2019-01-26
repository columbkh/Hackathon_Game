package com.m.myfirstgame;

import android.graphics.RectF;

public abstract class GameObject implements Drawable {
    protected float x;
    protected float y;
    protected int n;

    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
        n = 0;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    abstract public RectF getBoundingRect();
}
