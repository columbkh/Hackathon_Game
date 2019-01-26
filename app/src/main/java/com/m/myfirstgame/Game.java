package com.m.myfirstgame;

import java.util.LinkedList;

public class Game {
    private Ball ball;
    private LinkedList<Drawable> objects;
    private final int screenWidth, screenHeight;
    private Platform platform;

    public Game(int screenWidth, int screenHeight, float speedX, float speedY, float gravity) {
        ball = new Ball(speedX, speedY, gravity, screenHeight);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        objects = new LinkedList<>();
        objects.add(ball);
        platform = new Platform(0, 0, screenWidth, 50);
        objects.addFirst(platform);
    }

    public Ball getBall() {
        return ball;
    }

    public Platform getPlatform() {
        return platform;
    }

    public LinkedList<Drawable> getObjects() {
        return objects;
    }
}
