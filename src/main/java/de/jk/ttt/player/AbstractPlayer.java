/*
 * File: AbstractPlayer.java
 *
 */
package de.jk.ttt.player;

import de.jk.ttt.playboard.Piece;

/**
 * TODO describe the class
 *
 * @author KIRCHJ Jan Kirchner
 *
 */
public abstract class AbstractPlayer implements Player {

    private Piece piece;

    AbstractPlayer(Piece piece) {
        this.piece = piece;
    }

    /**
     * @return the piece
     */
    public Piece getPiece() {
        return piece;
    }

}
