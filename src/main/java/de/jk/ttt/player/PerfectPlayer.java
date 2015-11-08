package de.jk.ttt.player;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.jk.ttt.playboard.Piece;
import de.jk.ttt.playboard.Playboard;

public class PerfectPlayer extends AbstractPlayer {

    private Move next;

    public PerfectPlayer(Piece piece) {
        super(piece);
    }

    private Piece getOtherPiece() {
        return getPiece() == Piece.CROSS ? Piece.CIRCLE : Piece.CROSS;
    }

    /**
     * @see de.jk.ttt.player.Player#doTurn(de.jk.ttt.playboard.Playboard)
     */
    @Override
    public void doTurn(Playboard playboard) {
        next = null;

        minimax((Playboard) playboard.clone(), true);

        playboard.nextTurn(getPiece(), next.getX(), next.getY());

    }

    private int score(Playboard playboard) {
        int score;

        if (playboard.getWinner() == getPiece()) {
            score = 10 - playboard.getTurn();
        } else if (playboard.getWinner() == null) {
            score = 0;
        } else {
            score = -(10 - playboard.getTurn());
        }

        return score;
    }

    private int minimax(Playboard playboard, boolean myTurn) {
        if (playboard.isFinished()) {
            return score(playboard);
        }

        List<Move> scores = new LinkedList<>();

        for (int x = 0; x < Playboard.DIM; x++) {
            for (int y = 0; y < Playboard.DIM; y++) {
                if (playboard.getField(x, y) == Piece.EMPTY) {

                    Playboard newState = (Playboard) playboard.clone();

                    newState.nextTurn(myTurn ? getPiece() : getOtherPiece(), x, y);
                    int score = minimax(newState, !myTurn);

                    scores.add(new Move(x, y, score));
                }
            }
        }

        Collections.sort(scores);

        if (myTurn) {
            Collections.reverse(scores);
        }

        next = scores.iterator().next();
        return next.getScore();

    }

}
