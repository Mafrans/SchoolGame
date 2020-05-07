package me.mafrans.game.gameobjects;

import me.mafrans.game.*;

import java.awt.event.KeyEvent;

public class Cursor extends GameObject {
    @Override
    public void start() {
        transform.position = Vector2.zero;
        sprite = new Circle(16);
        //sprite.setColor(0x777777);
    }

    @Override
    public void update() {
        if(Input.mousePosition != null) {
            transform.position = Input.mousePosition;
        }
    }
}
