package de.jk.ttt;

import de.jk.ttt.playboard.Piece;
import de.jk.ttt.playboard.Playboard;
import de.jk.ttt.player.Player;
import de.jk.ttt.player.RandomPlayer;

public class TwoRandomPlayerGame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Playboard playboard = new Playboard();

        Player player1 = new RandomPlayer(Piece.CIRCLE);
        Player player2 = new RandomPlayer(Piece.CROSS);

        Game game = new Game(player1, player2, playboard);

        game.play();

    }

}
