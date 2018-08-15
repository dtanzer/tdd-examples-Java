package net.davidtanzer.tdd.tictactoe;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TicTacToeControllerTest {


	@Test
	public void canDetermineFirstPlayer(){

		TicTacToeController controller = new TicTacToeController();

		Player nextPlayer = controller.getCurrentPlayer();

		assertThat(nextPlayer).isEqualTo(Player.X);
	}

	@Test
	public void canDetermineNextPlayerAfterOneTurn() {

		TicTacToeController controller = new TicTacToeController();
		Position position = new Position(Col.LEFT, Row.TOP);

		controller.enterPosition(position);

		Player nextPlayer = controller.getCurrentPlayer();
		assertThat(nextPlayer).isEqualTo(Player.O);
	}

	@Test
	public void canDetermineNextPlayerAfterTwoTurns() {

		TicTacToeController controller = new TicTacToeController();

		controller.enterPosition(new Position(Col.LEFT, Row.TOP));
		controller.enterPosition(new Position(Col.LEFT, Row.TOP));

		Player nextPlayer = controller.getCurrentPlayer();
		assertThat(nextPlayer).isEqualTo(Player.X);
	}

	@Test
	public void returnsPlayerAfterPositionEntered(){

		TicTacToeController controller = new TicTacToeController();

		controller.enterPosition(new Position(Col.LEFT, Row.TOP));

		Player playerOnField = controller.getPlayerOnField(new Position(Col.LEFT, Row.TOP));
		assertThat(playerOnField).isEqualTo(Player.X);
	}

	@Test
	public void returnsFreePosition() {

		TicTacToeController controller = new TicTacToeController();

		Player player = controller.getPlayerOnField(new Position(Col.LEFT, Row.TOP));

		assertThat(player).isEqualTo(Player.FREE);
	}

	@Test
	public void canDetermineGameWon() {

		TicTacToeController controller = new TicTacToeController();

		playUntilPlayerXhasWon(controller);

		GameStatus gameStatus = controller.getGameStatus();
		assertThat(gameStatus).isEqualTo(GameStatus.WON);
	}

	@Test
	public void canDetermineGameRunning() {

		TicTacToeController controller = new TicTacToeController();

		GameStatus gameStatus = controller.getGameStatus();
		assertThat(gameStatus).isEqualTo(GameStatus.RUNNING);
	}

	private void playUntilPlayerXhasWon(TicTacToeController controller) {
		controller.enterPosition(new Position(Col.LEFT, Row.TOP));
		controller.enterPosition(new Position(Col.LEFT, Row.MIDDLE));
		controller.enterPosition(new Position(Col.CENTER, Row.TOP));
		controller.enterPosition(new Position(Col.CENTER, Row.MIDDLE));
		controller.enterPosition(new Position(Col.RIGHT, Row.TOP));
	}

}
