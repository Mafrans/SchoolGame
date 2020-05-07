package me.mafrans.game;

public class CircleCollider implements Collider {
    public int radius = 0;
    public Vector2 offset = Vector2.one.dot(-radius);

    @Override
    public Collision withCircle(Vector2 a, Vector2 b, CircleCollider c) {
        double distance = Vector2.distance(a.add(offset), b);

        if(distance > radius + c.radius) {
            return null;
        }
        else {
            return new Collision(b.subtract(a).normalize());
        }
    }
}
