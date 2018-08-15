package net.davidtanzer.tdd.tictactoe;

import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeController {

	private Player currentPlayer = Player.X;

	private Map<Position, Player> board = new HashMap<>();
	private GameStatus gameStatus = GameStatus.RUNNING;

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void enterPosition(Position position) {
		board.put(position, currentPlayer);
		currentPlayer = currentPlayer.nextPlayer();
	}

	public Player getPlayerOnField(Position position) {

		return board.getOrDefault(position, Player.FREE);
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}
}
