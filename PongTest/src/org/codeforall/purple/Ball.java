package org.codeforall.purple;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.codeforall.purple.TenisCourt.Padle;

import java.util.Random;

public class Ball implements Runnable {

    private int x;
    private int y;
    public Rectangle ball;
    private GridSimple gridSimple;
    public Padle padleLeft;
    public Padle padleRight;
    int ballDiameter;
    private Color color;
    private int xSpeed;
    private int ySpeed;
    public Integer scorePlayer1;
    public Integer scorePlayer2;
    public boolean scoreP1 = true;
    public boolean scoreP2 = true;
    private Text score2;
    private Text score;

    private int xPlayer1 = 1300 / 2 + 60;  //posição inicial;
    private int yPos = 20;
    private int xPlayer2 = 1300 / 2 - 60;


    public Ball(GridSimple gridSimple, Padle padleLeft, Padle padleRight) {
        this.gridSimple = gridSimple;
        this.padleLeft = padleLeft;
        this.padleRight = padleRight;
        this.x = gridSimple.getWidth() / 2 - 10;  //posição inicial
        this.y = gridSimple.getHeight() / 2 - 10;
        this.ballDiameter = 20;
        this.color = Color.LIGHT_GRAY;
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        initializeBall();
        initializeBallSpeed();
        initializeScorePlayer1();
        initializeScorePlayer2();
    }

    @Override
    public void run() {
        while (true) {
            movement();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void initializeBall() {
        ball = new Rectangle(x, y, ballDiameter, ballDiameter);
        ball.setColor(color);
        ball.fill();
    }

    public void endGame() {
        this.x = gridSimple.getWidth() / 2 - ballDiameter / 2;  // Reset X position to the center
        this.y = gridSimple.getHeight() / 2 - ballDiameter / 2; // Reset Y position to the center
        ball.delete();
        initializeBall();
        initializeBallSpeed();

    }

    private void movement() {

        x += xSpeed;
        y += ySpeed;

        // Colisões com parede
        if (x <= 0 || x + ballDiameter >= gridSimple.getWidth()) {
            xSpeed = -xSpeed;
            if (x <= 0) {
                scorePlayer2++;
                initializeScorePlayer2();


                endGame();

            } else {
                scorePlayer1++;
                initializeScorePlayer1();

                endGame();
            }
            return;
        }

        if (y <= 20 || y + ballDiameter >= gridSimple.getHeight()) {
            ySpeed = -ySpeed;
        }


        if (intersects(padleLeft.getPaddle())) {
            xSpeed = -xSpeed;

        } else if (intersects(padleRight.getPaddle())) {
            xSpeed = -xSpeed;

        }
      //  moreSpeed = moreSpeed+10;
        ball.translate(xSpeed, ySpeed);
    }

    private void initializeBallSpeed() { //Este método inicializa no constructor não necessario alterar
        Random random = new Random();
        this.xSpeed = random.nextInt(2) == 0 ? -10 : 10;
        this.ySpeed = random.nextInt(2) == 0 ? -10 : 10;
    }

    public boolean intersects(Rectangle paddle) {
        return ball.getX() + ballDiameter >= paddle.getX() &&
                ball.getX() <= paddle.getX() + paddle.getWidth() &&
                ball.getY() + ballDiameter >= paddle.getY() &&
                ball.getY() <= paddle.getY() + paddle.getHeight();
    }


    public void initializeScorePlayer1() {
        if (scoreP1) {
            score = new Text(xPlayer2, yPos, scorePlayer1.toString());
            score.setColor(Color.WHITE);
            score.draw();
            scoreP1 = false;
        } else {
            score.delete();
            score.setText(scorePlayer1.toString());
            score.draw();
        }
    }

    public void initializeScorePlayer2() {
        if (scoreP2) {
            score2 = new Text(xPlayer1, yPos, scorePlayer2.toString());
            score2.setColor(Color.WHITE);
            score2.draw();
            scoreP2 = false;
        } else {
            score2.delete();
            score2.setText(scorePlayer2.toString());
            score2.draw();
        }
    }
    
}