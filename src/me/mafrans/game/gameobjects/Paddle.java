package me.mafrans.game.gameobjects;

import me.mafrans.game.GameObject;
import me.mafrans.game.Input;
import me.mafrans.game.Sprite;
import me.mafrans.game.Vector2;

public class Paddle extends GameObject {
    @Override
    public void start() {
        sprite = new Sprite("paddle.png");
        transform.position = new Vector2(0, 250);
    }

    @Override
    public void update() {
        transform.position.x = Input.mousePosition.x - sprite.getWidth()/2;
        System.out.println(transform.position);
    }
}
