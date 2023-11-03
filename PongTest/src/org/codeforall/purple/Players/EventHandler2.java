package org.codeforall.purple.Players;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.codeforall.purple.GridSimple;

public class EventHandler2 implements KeyboardHandler {

    private Rectangle player2;

    private GridSimple gridSimple;

    private int moveDistance = 40;

    public EventHandler2(Rectangle player2, GridSimple gridSimple) {
        this.player2 = player2;
        this.gridSimple = gridSimple;
    }

    public void init() {

        Keyboard kbUp = new Keyboard(this);
        Keyboard kbDown = new Keyboard(this);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        kbUp.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        kbDown.addEventListener(down);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (player2.getY() > 10){
                    player2.translate(0,- moveDistance);}
                break;
            case KeyboardEvent.KEY_DOWN:
                if(player2.getY() + player2.getHeight() < gridSimple.getHeight() - 5){
                    player2.translate(0,moveDistance);}
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){

    }

}


