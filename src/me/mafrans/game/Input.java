package me.mafrans.game;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static List<Integer> keys = new ArrayList<>();
    private static List<Integer> lastKeys = new ArrayList<>();
    private static List<Integer> pressedKeys = new ArrayList<>();

    public static void setKey(int key, boolean down) {
        if(down) {
            if(!keys.contains(key)) {
                keys.add(key);
            }
        }
        else {
            keys.remove(key);
        }
    }

    public static void update() {
        pressedKeys.clear();
        for(int key : keys) {
            if(!lastKeys.contains(key)) {
                pressedKeys.add(key);
            }
        }

        lastKeys = keys;
    }

    public static boolean getKey(int key) {
        return keys.contains(key);
    }

    public static boolean getKeyPressed(int key) {
        return pressedKeys.contains(key);
    }
}
