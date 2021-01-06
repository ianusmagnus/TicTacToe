package de.jk.ttt.playboard;

import java.util.Arrays;

public class Playboard implements Cloneable {

	public static final int DIM = 3;

	private Piece[][] fields = new Piece[DIM][DIM];

	private int turn = 0;

	private Piece winner;

	public void nextTurn(Piece token, int x, int y) {

		if (token != currentToken()) {
			throw new PlayboardException("Wrong piece.");
		}

		if (checkFieldRange(x) || checkFieldRange(y)) {
			throw new PlayboardException("Field out of range.");
		}

		if (getField(x, y) != Piece.EMPTY) {
			throw new PlayboardException("Field already occupied.");
		}

		if (isFinished()) {
			throw new PlayboardException("Game already ended.");
		}

		fields[x][y] = token;
		turn++;

		if (checkWin(token, x, y)) {
			winner = token;
		}
	}

	private boolean checkFieldRange(int i) {
		return i < 0 || i >= DIM;
	}

	private boolean checkWin(Piece token, int x, int y) {
		boolean win = false;

		win |= checkWinHorizontal(token, x);
		win |= checkWinVertical(token, y);
		win |= checkWinAcross(token);
		win |= checkWinAcross2(token);

		return win;
	}

	public int getTurn() {
		return turn;
	}

	public boolean checkWinHorizontal(Piece token, int x) {
		boolean win = false;

		for (int y = 0; y < DIM; y++) {
			win = token == getField(x, y);

			if (!win) {
				break;
			}
		}

		return win;
	}

	public boolean checkWinVertical(Piece token, int y) {
		boolean win = false;

		for (int x = 0; x < DIM; x++) {
			win = token == getField(x, y);

			if (!win) {
				break;
			}
		}

		return win;
	}

	public boolean checkWinAcross(Piece token) {
		boolean win = false;

		for (int x = 0; x < DIM; x++) {
			win = token == getField(x, x);

			if (!win) {
				break;
			}
		}

		return win;
	}

	public boolean checkWinAcross2(Piece token) {
		boolean win = false;

		for (int x = 0, y = 2; x < DIM; x++, y--) {
			win = token == getField(x, y);

			if (!win) {
				break;
			}
		}

		return win;
	}

	public Piece currentToken() {
		return turn % 2 == 0 ? Piece.CIRCLE : Piece.CROSS;
	}

	public Piece getField(int x, int y) {
		Piece value = fields[x][y];
		return value == null ? Piece.EMPTY : value;
	}

	public Piece getWinner() {
		return winner;
	}

	public boolean isFinished() {
		return winner != null || turn >= 9;
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		Playboard clone = new Playboard();
		clone.fields = new Piece[DIM][DIM];

		for (int x = 0; x < DIM; x++) {
			for (int y = 0; y < DIM; y++) {
				clone.fields[x][y] = fields[x][y];
			}
		}

		clone.winner = winner;
		clone.turn = turn;

		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(fields);
		result = prime * result + turn;
		result = prime * result + (winner == null ? 0 : winner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Playboard other = (Playboard) obj;
		if (!Arrays.deepEquals(fields, other.fields)) {
			return false;
		}
		if (turn != other.turn) {
			return false;
		}
		if (winner != other.winner) {
			return false;
		}
		return true;
	}

}
