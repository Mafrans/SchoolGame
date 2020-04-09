public interface Collider {
    public Collision withCircle(Vector2 a, Vector2 b, CircleCollider c);
    public Collision withBox(Vector2 a, Vector2 b, BoxCollider c);
}
