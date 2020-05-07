package me.mafrans.game;

public class Circle extends Sprite {
    public Circle(int r) {
        super(r*2, r*2);

        for (int x = 0; x < r*2; x++) {
            for(int y = 0; y < r*2; y++) {
                pixels[y * r * 2 + x] = Sprite.TRANSPARENT;
                if(new Vector2(r, r).distance(new Vector2(x, y)) <= r) {
                    pixels[y * r * 2 + x] = 0xFF0000;
                }
            }
        }
    }

    @Override
    public int[] getPixels() {
        return pixels;
    }

    public Circle(int w, int h, int col) {
        super(w, h, col);
    }

    public Circle(String path) {
        super(path);
    }
}
