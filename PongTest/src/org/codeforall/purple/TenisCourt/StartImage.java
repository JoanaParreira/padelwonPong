package org.codeforall.purple.TenisCourt;

import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.codeforall.purple.GridSimple;

import java.awt.*;

public class StartImage implements Shape {

    GridSimple gridSimple;

    public StartImage(GridSimple gridSimple) {
        this.gridSimple = gridSimple;
    }

    public Picture createStar() {
        Picture star = new Picture(10,10,"res/start.1.jpg");
        star.draw();
        return star;
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
