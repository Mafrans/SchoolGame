package me.mafrans.game;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public static Vector2 mousePosition;

    private static List<Integer> keys = new ArrayList<>();
    private static List<Integer> lastKeys = new ArrayList<>();
    private static List<Integer> pressedKeys = new ArrayList<>();

    private static List<Integer> mouseButtons = new ArrayList<>();
    private static List<Integer> lastMouseButtons = new ArrayList<>();
    private static List<Integer> pressedMouseButtons = new ArrayList<>();

    public static void setKey(int key, boolean down) {
        if(down) {
            if(!keys.contains(key)) {
                keys.add(key);
            }
        }
        else {
            keys.remove((Object)key);
        }
    }

    public static void setMouseKey(int key, boolean down) {
        if(down) {
            if(!mouseButtons.contains(key)) {
                mouseButtons.add(key);
            }
        }
        else {
            mouseButtons.remove((Object)key);
        }
    }

    public static void update() {
        pressedKeys.clear();
        pressedMouseButtons.clear();
        for(int key : keys) {
            if(!lastKeys.contains(key)) {
                pressedKeys.add(key);
            }
        }

        for(int key : mouseButtons) {
            if(!lastMouseButtons.contains(key)) {
                pressedMouseButtons.add(key);
            }
        }

        lastKeys = keys;
        lastMouseButtons = mouseButtons;
    }

    public static boolean getKey(int key) {
        return keys.contains(key);
    }

    public static boolean getKeyPressed(int key) {
        return pressedKeys.contains(key);
    }

    public static boolean getMouseButton(int key) {
        return mouseButtons.contains(key);
    }

    public static boolean getMouseButtonPressed(int key) {
        return pressedMouseButtons.contains(key);
    }
}
