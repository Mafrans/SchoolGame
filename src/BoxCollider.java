public class BoxCollider implements Collider {
    public double width;
    public double height;
    public double angle;

    @Override
    public Collision withCircle(Vector2 a, Vector2 b, CircleCollider c) {
        return null;
    }

    @Override
    public Collision withBox(Vector2 a, Vector2 b, BoxCollider c) {
        return null;
    }
}
