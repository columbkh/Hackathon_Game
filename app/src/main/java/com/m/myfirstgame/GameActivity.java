package com.m.myfirstgame;
import android.view.MotionEvent;


import android.widget.Toast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity {

    GameController controller;
    private static float SPEED_X = 5f;
    private static float SPEED_Y = 1000f;
    private static float GRAVITY = 100f;
    private float x;
    private float y;
    private float angle;
    private float power;
    private boolean drag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new GameController(this, SPEED_X, SPEED_Y, GRAVITY);
        setContentView(controller.getView());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // координаты Touch-события
        float evX = event.getX();
        float evY = event.getY();

        switch (event.getAction()) {
            // касание началось
            case MotionEvent.ACTION_DOWN: {
                drag = true;
                x = evX;
                y = evY;
            }
            break;
            // тащим
            case MotionEvent.ACTION_MOVE:
                if (drag) {
                    // определеяем новые координаты для рисования
                    angle += 0.1f * (y-evY);
                    angle = Math.max(0.1f, Math.min(angle, 1.0f));
                    power += 0.1f * (evX-x);
                    power = Math.max(0.1f, Math.min(power, 1.0f));
                    x = evX;
                    y = evY;
                    drag=false;
                }
                break;
            // касание завершено
            case MotionEvent.ACTION_UP:
                // выключаем режим перетаскивания

                // BOOM?
                if (drag==true)
                    Toast.makeText(getApplicationContext(),"PEWPEWPEW",Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(),"Adjusting bombarde: power "+power+" angle "+angle,Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}

