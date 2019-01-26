package com.m.myfirstgame;
public class GameController {
    private GameActivity context;
    private GameSurfaceView view;
    private Game game;
    private Ball ball;
    private float speedX;
    private float speedY;
    private float gravity;
    private Prince prince;
    private boolean run;


    public Ball getBall() {
        return ball;
    }

    public void enableRun() {
        this.run = true;
    }

    public void disableRun() {
        this.run = false;
    }

    public void throwBall() {
        if (run) {
            ball.setRun(true);
        }
    }





    public GameController(GameActivity context, float speedX, float speedY, float gravity) {
        this.context = context;
        this.view = new GameSurfaceView(context, this);
        this.speedX = speedX;
        this.speedY = speedY;
        this.gravity = gravity;


    }

    public void update() {
        throwBall();

        ball.updatePosition();
        prince.updatePosition();


        Platform p = game.getPlatform();

        if (ball.getBoundingRect().intersect(p.boundingRect)) {
            ball.rebound();
        }

        if (ball.getBoundingRect().intersect(prince.getBoundingRect())) {
            game.deletePrince();
        }














    }

    public Game getGame() {
        return this.game;
    }

    public void start() {
        game = new Game(this.view.getSurfaceWidth(), this.view.getSurfaceHeight(), speedX, speedY, gravity);
        ball = game.getBall();

        prince = game.getPrince();

    }



    public GameSurfaceView getView() {
        return view;
    }






    }
