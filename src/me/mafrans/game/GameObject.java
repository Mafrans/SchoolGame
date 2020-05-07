package me.mafrans.game;

import java.util.Arrays;

public abstract class GameObject {
    public Sprite sprite;
    public Transform transform = new Transform();
    public void update() {}
    public void start() {}
    public void destroy() {}
    public void collision(Collision c) {}

    public void draw(int[] screen, int screenWidth) {
        if(sprite == null) return;

        for (int i = 0; i < sprite.getHeight(); i++) {
            for (int j = 0; j < sprite.getWidth(); j++) {
                int index = (int)((transform.position.y+i)*screenWidth + transform.position.x+j);
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
