/*
 * File: Game.java
 *
 */
package de.jk.ttt;

import de.jk.ttt.playboard.Playboard;
import de.jk.ttt.playboard.PlayboardPrinter;
import de.jk.ttt.player.Player;

/**
 * TODO describe the class
 *
 * @author KIRCHJ Jan Kirchner
 *
 */
public class Game {

    private Player player1;
    private Player player2;

    private Playboard playboard;
    private PlayboardPrinter printer;

    /**
     * @param player1
     * @param player2
     * @param playboard
     */
    public Game(Player player1, Player player2, Playboard playboard) {
        super();
        this.player1 = player1;
        this.player2 = player2;
        this.playboard = playboard;

        printer = new PlayboardPrinter(playboard);
    }

    public void play() {

        printer.print();

        while (!playboard.isFinished()) {

            player1.doTurn(playboard);
            printer.print();

            if (playboard.isFinished()) {
                break;
            }

            player2.doTurn(playboard);
            printer.print();

        }

        printer.print();
    }
}
