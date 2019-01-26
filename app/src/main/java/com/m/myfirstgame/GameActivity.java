package com.m.myfirstgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity {

    GameController controller;
    private static float SPEED_X = 5f;
    private static float SPEED_Y = 1000f;
    private static float GRAVITY = 100f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new GameController(this, SPEED_X, SPEED_Y, GRAVITY);
        setContentView(controller.getView());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}
