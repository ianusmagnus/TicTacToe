package de.jk.ttt.playboard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayboardWinTest {

    Playboard playboard;

    PlayboardPrinter printer;

    @Before
    public void setup() {
        playboard = new Playboard();

        printer = new PlayboardPrinter(playboard);
    }

    @Test
    public void testVerticalWin() {

        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 0, 0);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CROSS, 0, 1);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 1, 0);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CROSS, 1, 1);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 2, 0);

        printer.print();

        Assert.assertTrue(playboard.isFinished());

    }

    @Test
    public void testHorizontalWin() {

        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 2, 0);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CROSS, 1, 0);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 2, 1);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CROSS, 1, 1);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 2, 2);

        printer.print();

        Assert.assertTrue(playboard.isFinished());

        try {
            playboard.nextTurn(Piece.CROSS, 0, 0);
            Assert.fail();
        } catch (PlayboardException e) {

        }
    }

    @Test
    public void testCrossWin() {

        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 0, 0);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CROSS, 0, 1);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 1, 1);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CROSS, 1, 2);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 2, 2);

        printer.print();

        Assert.assertTrue(playboard.isFinished());
    }

    @Test
    public void testCrossWin2() {

        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 0, 2);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CROSS, 0, 1);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 1, 1);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CROSS, 1, 2);
        Assert.assertFalse(playboard.isFinished());
        playboard.nextTurn(Piece.CIRCLE, 2, 0);

        printer.print();

        Assert.assertTrue(playboard.isFinished());
    }

}
