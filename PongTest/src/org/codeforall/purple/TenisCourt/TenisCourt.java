package org.codeforall.purple.TenisCourt;

import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.codeforall.purple.GridSimple;

import java.awt.*;

public class TenisCourt implements Shape {

    private Picture tenisCourt;
    GridSimple gridSimple;

    public TenisCourt(int x, int y, String imagePath) {
        tenisCourt = new Picture(x, y, imagePath);
        tenisCourt.draw();
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void draw() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void grow(double v, double v1) {
        v = gridSimple.getWidth();
        v1 = gridSimple.getHeight();
    }

    @Override
    public void paintShape(Graphics2D graphics2D) {

    }
}

