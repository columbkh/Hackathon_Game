package com.m.myfirstgame;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity {

    GameController controller;
    private static double ANGLE = 64.3f;
    private static double VELOCITY = 103.36;
    private float SPEED_X = (float) (VELOCITY * Math.cos(ANGLE));
    private  float SPEED_Y = (float) (VELOCITY * Math.sin(ANGLE));
    private static float GRAVITY = 10.1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        controller = new GameController(this, SPEED_X, SPEED_Y, GRAVITY);
        setContentView(controller.getView());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}
