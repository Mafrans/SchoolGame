package me.mafrans.game;

public class Collision {
    public Vector2 normal;
    public Collider collider;

    public Collision(Vector2 normal) {
        this.normal = normal;
    }
    public Collision(Collider collider) {
        this.collider = collider;
    }
    public Collision(Vector2 normal, Collider collider) {
        this.normal = normal;
        this.collider = collider;
    }
}
