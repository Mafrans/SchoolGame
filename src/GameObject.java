public abstract class GameObject {
    public Transform transform = new Transform();
    public void update() {}
    public void start() {}
    public void destroy() {}
    public void collision(Collision c) {}
}
