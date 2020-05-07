package me.mafrans.game;

public class RectCollider implements Collider {
    public Vector2 dimension;
    public Vector2 offset = new Vector2(-dimension.x/2, -dimension.y/2);

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
}
