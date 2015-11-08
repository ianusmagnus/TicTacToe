/*
 * File: RandomPlayer.java
 *
 */
package de.jk.ttt.player;

import java.util.Random;

import de.jk.ttt.playboard.Piece;
import de.jk.ttt.playboard.Playboard;

/**
 * TODO describe the class
 *
 * @author KIRCHJ Jan Kirchner
 *
 */
public class RandomPlayer extends AbstractPlayer {
    private Random rand = new Random();

    public RandomPlayer(Piece piece) {
        super(piece);
    }

    /**
     * @see de.jk.ttt.player.Player#doTurn(de.jk.ttt.playboard.Playboard)
     */
    @Override
    public void doTurn(Playboard playboard) {

        int x, y;
        do {
            x = randInt();
            y = randInt();
        } while (playboard.getField(x, y) != Piece.EMPTY);

        System.out.printf("random(%d, %d)\n", x, y);
        playboard.nextTurn(getPiece(), x, y);

    }

    public int randInt() {
        int min = 0;
        int max = 30000;

        return (rand.nextInt(max - min + 1) + min) % 3;
    }

}
