package me.mafrans.game.gameobjects;

import me.mafrans.game.*;

public class Paddle extends GameObject {
    @Override
    public void start() {
        sprite = new Sprite("paddle.png");
        transform.position = new Vector2(0, 250);
        colliders = new Collider[]{new RectCollider(new Vector2(64, 8))};
    }

    @Override
    public void update() {
        transform.position.x = Input.mousePosition.x - sprite.getWidth()/2;
    }
}
