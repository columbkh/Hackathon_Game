package com.m.myfirstgame;

import java.util.LinkedList;

public class Game {
    private Ball ball;
    private LinkedList<Drawable> objects;
    private final int screenWidth, screenHeight;

    public Game(int screenWidth, int screenHeight, float speedX, float speedY, float gravity) {
        ball = new Ball(speedX, speedY, gravity);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        objects = new LinkedList<>();
        objects.add(ball);
    }

    public Ball getBall() {
        return ball;
    }

    public LinkedList<Drawable> getObjects() {
        return objects;
    }
}
