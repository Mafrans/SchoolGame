public class Vector2 {
    public static Vector2 zero = new Vector2(0, 0);
    public static Vector2 one = new Vector2(1, 1);
    public static Vector2 right = new Vector2(1, 0);
    public static Vector2 left = new Vector2(-1, 0);
    public static Vector2 up = new Vector2(0, 1);
    public static Vector2 down = new Vector2(0, -1);

    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 o) {
        return new Vector2(x + o.x, y + o.y);
    }

    public Vector2 subtract(Vector2 o) {
        return new Vector2(x - o.x, y - o.y);
    }

    public Vector2 invert() {
        return new Vector2(-x, -y);
    }

    public Vector2 dot(double o) {
        return new Vector2(x * o, y * o);
    }

    public Vector2 cross(Vector2 o) {
        return new Vector2(x * o.x, y * o.y);
    }

    public double dir() {
        return Mathf.atan(y / x);
    }

    public double distance(Vector2 b) {
        return Vector2.distance(this, b);
    }

    public static double distance(Vector2 a, Vector2 b) {
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }
}
