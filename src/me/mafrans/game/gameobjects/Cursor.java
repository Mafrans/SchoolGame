package me.mafrans.game.gameobjects;

import me.mafrans.game.GameObject;
import me.mafrans.game.Input;
import me.mafrans.game.Sprite;
import me.mafrans.game.Vector2;

import java.awt.event.KeyEvent;

public class Cursor extends GameObject {
    @Override
    public void start() {
        transform.position = Vector2.zero;
        sprite = new Sprite(32, 32);
        sprite.setColor(0x777777);
    }

    @Override
    public void update() {
    }
}
