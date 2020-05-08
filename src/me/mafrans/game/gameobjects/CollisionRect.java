package me.mafrans.game.gameobjects;

import me.mafrans.game.*;

public class CollisionRect extends GameObject {
    @Override
    public void start() {
        transform.position = new Vector2(100, 100);
        colliders = new Collider[] { new RectCollider(new Vector2(64, 32)) };
        sprite = new Sprite(64, 64);
        sprite.setColor(0x777777);
    }

    @Override
    public void update() {

    }

    @Override
    public void collisionEnter(Collision c) {
        System.out.println("Enter: " + c.collider);

        sprite.setColor(0xFF0000);
    }

    @Override
    public void collisionExit(Collision c) {
        System.out.println("Exit: " + c.collider);
        sprite.setColor(0x777777);
    }
}
