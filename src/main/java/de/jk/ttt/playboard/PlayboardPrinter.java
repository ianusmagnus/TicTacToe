package de.jk.ttt.playboard;

public class PlayboardPrinter {

	Playboard playboard;

	/**
	 * @param layboard
	 */
	public PlayboardPrinter(Playboard playboard) {
		super();
		this.playboard = playboard;
	};

	public void print() {

		System.out.println();
		System.out.printf("Next move: %s\n", playboard.currentToken());
		System.out.println();
		for (int x = 0; x < Playboard.DIM; x++) {
			for (int y = 0; y < Playboard.DIM; y++) {
				Piece field = playboard.getField(x, y);
				System.out.print(toString(field));
			}
			System.out.println();
		}

		if (playboard.isFinished()) {
			System.out.printf("\nWinner: %s\n", toString(playboard.getWinner()));
		}
	}

	private String toString(Piece field) {
		String value = "none";

		if (field != null) {
			switch (field) {
			case CIRCLE:
				value = "O ";
				break;
			case CROSS:
				value = "X ";
				break;
			default:
				value = "_ ";
			}
		}

		return value;
	}

}
