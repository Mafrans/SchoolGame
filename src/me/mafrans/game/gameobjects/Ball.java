package me.mafrans.game.gameobjects;

import me.mafrans.game.*;

import java.awt.event.MouseEvent;

public class Ball extends GameObject {
    public double moveScale = 1;
    public double moveSpeed = 3;
    public Vector2 direction = Vector2.down;

    @Override
    public void start() {
        sprite = new Sprite("ball.png");
        transform.position = new Vector2(200, 150);
        colliders = new Collider[]{new RectCollider(new Vector2(8, 8))};
    }

    @Override
    public void update() {
        System.out.println(direction);

        if (transform.position.x <= 0 || transform.position.x >= game.getScaledWidth()) {
            direction.x *= -1;
        }

        if(Input.getMouseButton(MouseEvent.BUTTON1)) {
            moveScale = 0.5;
        }
        else {
            moveScale = 1;
        }

        transform.position = transform.position.add(direction.dot(moveSpeed * moveScale).round());
    }

    @Override
    public void collisionEnter(Collision c) {
        if (c.gameObject instanceof Paddle) {
            direction = transform.position.add(new Vector2(sprite.getWidth() / 2, sprite.getHeight() / 2)).subtract(((Paddle) c.gameObject).transform.position.add(new Vector2(32, 0))).normalize();
        }
    }
}
