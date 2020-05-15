package me.mafrans.game;

import me.mafrans.game.gameobjects.*;

/**
 * This is a class
 * Created 2020-03-25
 *
 * @author Magnus Silverdal
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game(400,300,2);

        game.instantiate(new Paddle());
        game.start();
    }
}
