/*
 * File: Player.java
 *
 */
package de.jk.ttt.player;

import de.jk.ttt.playboard.Playboard;

/**
 * TODO describe the class
 *
 * @author KIRCHJ Jan Kirchner
 *
 */
public interface Player {

    /**
     * @param playboard
     */
    void doTurn(Playboard playboard);

}
