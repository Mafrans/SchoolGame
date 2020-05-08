package me.mafrans.game;

public interface Collider {
    Collision withCircle(Vector2 a, Vector2 b, CircleCollider c);
    Collision withRect(Vector2 a, Vector2 b, RectCollider c);
}
