package me.mafrans.game;

import java.awt.*;

public class Vector2 {
    public static Vector2 zero = new Vector2(0, 0);
    public static Vector2 one = new Vector2(1, 1);
    public static Vector2 right = new Vector2(1, 0);
    public static Vector2 left = new Vector2(-1, 0);
    public static Vector2 up = new Vector2(0, 1);
    public static Vector2 down = new Vector2(0, -1);

    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public static Vector2 fromAngle(int angle, double length) {
        return new Vector2(
                Mathf.cos(angle) * length,
                Mathf.cos(angle) * length
            );
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

    public double magnitude() {
        return Math.abs(distance(Vector2.zero));
    }

    public Vector2 normalize() {
        double magnitude = magnitude();
        return new Vector2(x / magnitude, y / magnitude);
    }

    public double dir() {
        return Mathf.atan(y / x);
    }

    public Vector2 round() {
        return new Vector2(Math.round(this.x), Math.round(this.y));
    }

    public double distance(Vector2 b) {
        return Vector2.distance(this, b);
    }

    public static double distance(Vector2 a, Vector2 b) {
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
