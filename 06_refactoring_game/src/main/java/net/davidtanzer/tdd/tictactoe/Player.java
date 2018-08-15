package net.davidtanzer.tdd.tictactoe;

public enum Player {

	X {
		@Override
		public Player nextPlayer() {
			return Player.O;
		}
	}, O {
		@Override
		public Player nextPlayer() {
			return Player.X;
		}
	}, FREE{
		@Override
		public Player nextPlayer() {
			throw new UnsupportedOperationException("FREE Player has no next player");
		}
	};

	public abstract Player nextPlayer();
}
