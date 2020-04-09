package me.mafrans.game.gameobjects;

import me.mafrans.game.GameObject;
import me.mafrans.game.Input;
import me.mafrans.game.Sprite;
import me.mafrans.game.Vector2;

import java.awt.event.KeyEvent;

public class TestObject extends GameObject {
    @Override
    public void start() {
        transform.position = new Vector2(200, 200);
        sprite = new Sprite("sprite.png");
    }

    @Override
    public void update() {
        if(Input.getKey(KeyEvent.VK_RIGHT)) {
            transform.position.x += 1;
        }
        if(Input.getKey(KeyEvent.VK_LEFT)) {
            transform.position.x -= 1;
        }
        if(Input.getKey(KeyEvent.VK_DOWN)) {
            transform.position.y += 1;
        }
        if(Input.getKey(KeyEvent.VK_UP)) {
            transform.position.y -= 1;
        }
    }
}
