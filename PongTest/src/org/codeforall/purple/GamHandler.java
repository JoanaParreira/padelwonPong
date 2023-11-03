package org.codeforall.purple;


import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GamHandler implements KeyboardHandler {
    private Picture startImageMenu;
    public boolean gameStarted = false;

    public GamHandler(Picture startImage) {
        this.startImageMenu = startImage;
    }

    public void init() {



        Keyboard kbStart = new Keyboard(this);

        KeyboardEvent start = new KeyboardEvent();
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        start.setKey(KeyboardEvent.KEY_SPACE);

        kbStart.addEventListener(start);
        while (!gameStarted){
            startImageMenu.draw();
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            gameStarted = true;

            startImageMenu.delete();

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public boolean isGameStarted() {
        return gameStarted;
    }

}



