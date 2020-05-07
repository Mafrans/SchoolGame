package me.mafrans.game;

public class RectCollider implements Collider {
    public Vector2 dimension;
    public Vector2 offset;

    @Override
    public Collision withCircle(Vector2 a, Vector2 b, CircleCollider c) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
