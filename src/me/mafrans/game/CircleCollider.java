package me.mafrans.game;

public class CircleCollider implements Collider {
    public int radius = 0;
    public Vector2 offset = Vector2.zero;

    public CircleCollider(int radius) {
        this.radius = radius;
    }

    public CircleCollider(int radius, Vector2 offset) {
        this.radius = radius;
        this.offset = offset;
    }

    @Override
    public Collision withCircle(Vector2 a, Vector2 b, CircleCollider c) {
        double distance = Vector2.distance(a.add(offset), b.add(c.offset));

        if(distance > radius + c.radius) {
            return null;
        }
        else {
            return new Collision(b.subtract(a).normalize());
        }
    }

    @Override
    public Collision withRect(Vector2 a, Vector2 b, RectCollider c) {
        return c.withCircle(b, a, this);
    }
}
