public class CircleCollider implements Collider {
    public int radius = 0;

    @Override
    public Collision withCircle(Vector2 a, Vector2 b, CircleCollider c) {
        double distance = Vector2.distance(a, b);

        if(distance > radius + c.radius) {
            return null;
        }
        else {
            return new Collision(b.subtract(a).normalize());
        }
    }

    @Override
    public Collision withBox(Vector2 a, Vector2 b, BoxCollider c) {
        return null;
    }
}
