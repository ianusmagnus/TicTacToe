package de.jk.ttt;

import java.util.Scanner;

import de.jk.ttt.playboard.Piece;
import de.jk.ttt.playboard.Playboard;
import de.jk.ttt.player.ConsolePlayer;
import de.jk.ttt.player.Player;
import de.jk.ttt.player.RandomPlayer;

public class RandomPlayerGame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Playboard playboard = new Playboard();
        Scanner sc = new Scanner(System.in);
        Player player1 = new ConsolePlayer(Piece.CIRCLE, sc);
        Player player2 = new RandomPlayer(Piece.CROSS);

        Game game = new Game(player1, player2, playboard);

        game.play();

        sc.close();

    }

}
