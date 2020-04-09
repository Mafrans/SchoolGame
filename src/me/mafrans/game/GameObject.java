package me.mafrans.game;

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
                screen[(int)((transform.position.y+i)*screenWidth + transform.position.x+j)] = sprite.getPixels()[i*sprite.getWidth() + j];
            }
        }
    }
}
