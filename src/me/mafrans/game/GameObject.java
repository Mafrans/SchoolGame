package me.mafrans.game;

import java.util.Arrays;

public abstract class GameObject {
    public Sprite sprite;
    public Transform transform = new Transform();
    public void update() {}
    public void start() {}
    public void destroy() {}
    public void collision(Collision c) {}

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
}
