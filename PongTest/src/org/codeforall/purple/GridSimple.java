package org.codeforall.purple;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class GridSimple {
    private int width;
    private int height;

    public GridSimple(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void createField() {

        Rectangle border = new Rectangle(10, 10, width, height);
        border.setColor(Color.BLACK);
        border.fill();

        int x = width / 2 + 10;
        int startY = 20;
        int endY = height + 10;
        int dashLength = 10;
        int gapLength = 10;
        boolean drawDash = true;

        for (int y = startY; y <= endY; y += (drawDash ? dashLength : gapLength)) {
            if (drawDash) {
                Line dashLine = new Line(x, y, x, Math.min(y + dashLength, endY));
                dashLine.setColor(Color.LIGHT_GRAY);
                dashLine.draw();
            }
            drawDash = !drawDash;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

