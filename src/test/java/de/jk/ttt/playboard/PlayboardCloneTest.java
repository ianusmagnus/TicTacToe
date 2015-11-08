package de.jk.ttt.playboard;

import org.junit.Assert;
import org.junit.Test;

public class PlayboardCloneTest {
	@Test
	public void testClone() {
		Playboard playboard = new Playboard();

		playboard.nextTurn(Piece.CIRCLE, 0, 1);
		playboard.nextTurn(Piece.CROSS, 1, 1);

		Playboard playboard2 = (Playboard) playboard.clone();

		Assert.assertFalse(playboard == playboard2);
		Assert.assertTrue(playboard.equals(playboard2));

		playboard.nextTurn(Piece.CIRCLE, 0, 2);
		Assert.assertFalse(playboard.equals(playboard2));

		playboard2.nextTurn(Piece.CIRCLE, 0, 2);
		Assert.assertTrue(playboard.equals(playboard2));

	}

}
