/*
 * File: ConsolePlayer.java
 *
 */
package de.jk.ttt.player;

import java.util.Scanner;

import de.jk.ttt.playboard.Piece;
import de.jk.ttt.playboard.Playboard;
import de.jk.ttt.playboard.PlayboardException;

/**
 * TODO describe the class
 *
 * @author KIRCHJ Jan Kirchner
 *
 */
public class ConsolePlayer extends AbstractPlayer {

    Scanner sc;

    /**
     * @param sc
     */
    public ConsolePlayer(Piece piece, Scanner sc) {
        super(piece);
        this.sc = sc;
    }

    /**
     * @see de.jk.ttt.player.Player#doTurn(de.jk.ttt.playboard.Playboard)
     */
    @Override
    public void doTurn(Playboard playboard) {
        boolean success = false;

        while (!success) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            try {
                playboard.nextTurn(getPiece(), x, y);
                success = true;
            } catch (PlayboardException e) {
                System.err.println(e.getMessage());
            }

        }

    }

}
