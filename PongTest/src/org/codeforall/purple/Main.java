package org.codeforall.purple;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.codeforall.purple.Players.EventHandler1;
import org.codeforall.purple.Players.EventHandler2;
import org.codeforall.purple.Music.Sound;
import org.codeforall.purple.TenisCourt.Padle;
import org.codeforall.purple.TenisCourt.StartImage;

public class Main {

    public static void main(String[] args) {

        GridSimple grid = new GridSimple(1300, 860);
        grid.createField();

        Padle padleLeft = new Padle(30, grid.getHeight() / 2 - 50, 20, 100, Color.LIGHT_GRAY);
        Padle padleRight = new Padle(grid.getWidth() - 30, grid.getHeight() / 2 - 50, 20, 100, Color.LIGHT_GRAY);


        Sound sound = new Sound("/res/backgroundmusic.wav");
        sound.play();

        StartImage start = new StartImage(grid);
        GamHandler gameStarter = new GamHandler(start.createStar());
        gameStarter.init();


        Ball ball = new Ball(grid, padleLeft, padleRight);



        EventHandler1 eventHandlerLeft = new EventHandler1(padleLeft.getPaddle(), grid);
        eventHandlerLeft.init();

        EventHandler2 eventHandlerRight = new EventHandler2(padleRight.getPaddle(), grid);
        eventHandlerRight.init();

        Thread T = new Thread(ball);
        T.start();


    }

}