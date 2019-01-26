package com.m.myfirstgame;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    GameController controller;
    private float x;
    private float y;
    private float angle;
    private float power;
    private boolean drag;
    private float SPEED_X = (float) (power * Math.cos(angle));
    private  float SPEED_Y = (float) (power * Math.sin(angle));
    private static float GRAVITY = 5.4f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        controller = new GameController(this, 0, 0, GRAVITY);
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
                    SPEED_X = (float) (power * Math.cos(angle));
                    SPEED_Y = (float) (power * Math.sin(angle));
                    controller.getBall().setSpeedX(SPEED_X);
                    controller.getBall().setSpeedY(SPEED_Y);
                }
                break;
            // касание завершено
            case MotionEvent.ACTION_UP:
                // выключаем режим перетаскивания

                // BOOM?
                if (drag==true) {
                    Toast.makeText(getApplicationContext(),"PEWPEWPEW",Toast.LENGTH_SHORT).show();
                    controller.enableRun();
                    /*try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    controller.disableRun();*/


                }
                else {
                    Toast.makeText(getApplicationContext(),"Adjusting bombarde: power "+power+" angle "+angle,Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return true;
    }
}

