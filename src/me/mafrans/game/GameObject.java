package me.mafrans.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public abstract class GameObject {
    public Game game;
    public Sprite sprite;
    public Transform transform = new Transform();
    public Collider[] colliders = new Collider[0];
    public HashSet<Collider> _collidingWith = new HashSet<>();
    public void update() {}
    public void start() {}
    public void destroy() {}
    public void collisionEnter(Collision c) {}
    public void collisionExit(Collision c) {}
    public void collisionStay(Collision c) {}

    public void draw(int[] screen, int screenWidth, int screenHeight) {
        if(sprite == null) return;

        for (int i = 0; i < sprite.getHeight(); i++) {
            for (int j = 0; j < sprite.getWidth(); j++) {
                Vector2 screenPoint = new Vector2(transform.position.x+j, transform.position.y+i);

                if(screenPoint.x < 0 || screenPoint.y < 0 || screenPoint.x > screenWidth || screenPoint.y > screenHeight) {
                    continue; // Don't draw pixels out of bounds
                }

                int index = (int)((screenPoint.y)*screenWidth + screenPoint.x);
                if(index >= 0 && index < screen.length) {
                    int color = sprite.getPixels()[i*sprite.getWidth() + j];
                    if(color != Sprite.TRANSPARENT) {
                        screen[index] = color;
                    }
                }
            }
        }
    }

    public void _collide(Collision collision) {
        collision.gameObject = this;

        if(!_collidingWith.contains(collision.collider)) {
            collisionEnter(collision);
            _collidingWith.add(collision.collider);
        }
    }

    public void _uncollide(Collision collision) {
        collision.gameObject = this;

        if(_collidingWith.contains(collision.collider)) {
            collisionExit(collision);
            _collidingWith.remove(collision.collider);
        }
    }
}
