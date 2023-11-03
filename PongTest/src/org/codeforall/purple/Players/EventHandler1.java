package org.codeforall.purple.Players;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.codeforall.purple.GridSimple;

public class EventHandler1 implements KeyboardHandler {

    private Rectangle player1;

    private GridSimple gridSimple;

        private int moveDistance = 40;

    public EventHandler1(Rectangle player1, GridSimple gridSimple) {
        this.player1 = player1;
        this.gridSimple = gridSimple;
    }

    public void init() {

        Keyboard kbUpW = new Keyboard(this);
        Keyboard kbDownS = new Keyboard(this);


        KeyboardEvent upW = new KeyboardEvent();
        upW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upW.setKey(KeyboardEvent.KEY_W);

        kbUpW.addEventListener(upW);


        KeyboardEvent downS = new KeyboardEvent();
        downS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downS.setKey(KeyboardEvent.KEY_S);

        kbDownS.addEventListener(downS);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                if (player1.getY() > 10) {
                    player1.translate(0, -moveDistance);
                }
                break;
            case KeyboardEvent.KEY_S:
                if (player1.getY() + player1.getHeight() < gridSimple.getHeight() - 10) {
                    player1.translate(0, moveDistance);
                }
                break;

        }
    }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent){


        }

}
