package org.codeforall.purple.TenisCourt;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Padle {


    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private Rectangle paddle;

    public Padle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        initializePaddle();
    }

    private void initializePaddle() {
        paddle = new Rectangle(x, y, width, height);
        paddle.setColor(color);
        paddle.fill();
    }

    public Rectangle getPaddle() {
        return paddle;
    }
}
