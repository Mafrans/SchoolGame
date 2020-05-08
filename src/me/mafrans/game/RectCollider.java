package me.mafrans.game;

import java.util.Arrays;
import java.util.Comparator;

public class RectCollider implements Collider {
    public Vector2 dimension;
    public Vector2 offset = Vector2.zero;

    public RectCollider(Vector2 dimension) {
        this.dimension = dimension;
    }

    public RectCollider(Vector2 dimension, Vector2 offset) {
        this.dimension = dimension;
        this.offset = offset;
    }

    @Override
    public Collision withCircle(Vector2 a, Vector2 b, CircleCollider c) {
        Vector2 rpos = a.add(offset);
        Vector2 cpos = b.add(c.offset);

        Vector2 testPos = cpos;

        if(cpos.x > rpos.x + dimension.x) { // Check right edge
            testPos.x = rpos.x + dimension.x;
        }

        if(cpos.x < rpos.x) { // Check right edge
            testPos.x = rpos.x;
        }

        if(cpos.y > rpos.y) { // Check top edge
            testPos.y = rpos.y + dimension.y;
        }

        if(cpos.y < rpos.y) { // Check bottom edge
            testPos.y = rpos.y;
        }

        double distance = Vector2.distance(cpos, testPos);

        if(distance <= c.radius) {
            return new Collision(testPos.normalize());
        }
        return null;
    }

    @Override
    public Collision withRect(Vector2 a, Vector2 b, RectCollider r) {
        Vector2 pos = a.add(offset);
        Vector2 otherPos = b.add(r.offset);
        Vector2[] edges = {
                pos.add(new Vector2(dimension.x, dimension.y/2)),
                pos.add(new Vector2(0, dimension.y/2)),
                pos.add(new Vector2(dimension.x/2, dimension.y)),
                pos.add(new Vector2(dimension.x/2, 0)),
        };

        if(pos.x + this.dimension.x >= otherPos.x &&
            pos.x <= otherPos.x + r.dimension.x &&
            pos.y + this.dimension.y >= otherPos.y &&
            pos.y <= otherPos.y + r.dimension.y) {

            Arrays.sort(edges, new Comparator<Vector2>() {
                @Override
                public int compare(Vector2 vector2, Vector2 t1) {
                    return Mathf.sign(otherPos.add(r.dimension.dot(0.5)).distance(vector2) - otherPos.add(r.dimension.dot(0.5)).distance(t1));
                }
            });

            return new Collision(pos.add(dimension.dot(0.5)).subtract(edges[0]).normalize());
        }

        return null;
    }
}
