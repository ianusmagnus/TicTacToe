package de.jk.ttt.playboard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayboardTest {

    Playboard playboard;

    @Before
    public void setup() {
        playboard = new Playboard();
    }

    @Test
    public void testTurn() {
        playboard.nextTurn(Piece.CIRCLE, 0, 0);
        Piece field = playboard.getField(0, 0);
        Assert.assertEquals(Piece.CIRCLE, field);

        playboard.nextTurn(Piece.CROSS, 0, 1);
        field = playboard.getField(0, 1);
        Assert.assertEquals(Piece.CROSS, field);

    }

    @Test
    public void testDuplicateTurn() {
        playboard.nextTurn(Piece.CIRCLE, 0, 0);

        try {
            playboard.nextTurn(Piece.CROSS, 0, 0);
            Assert.fail();
        } catch (PlayboardException e) {

        }

    }

    @Test
    public void testFieldRange() {

        try {
            playboard.nextTurn(Piece.CIRCLE, -1, 0);
            Assert.fail();
        } catch (PlayboardException e) {

        }

        try {
            playboard.nextTurn(Piece.CIRCLE, 3, 0);
            Assert.fail();
        } catch (PlayboardException e) {

        }

        try {
            playboard.nextTurn(Piece.CIRCLE, 0, -1);
            Assert.fail();
        } catch (PlayboardException e) {

        }

        try {
            playboard.nextTurn(Piece.CIRCLE, 0, 3);
            Assert.fail();
        } catch (PlayboardException e) {

        }

    }

}
