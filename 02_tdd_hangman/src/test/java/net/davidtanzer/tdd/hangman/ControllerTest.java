package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ControllerTest {
	private Hangman hangman = new Hangman();

	@Test
	public void createsInitialPlaceholderInControllerConstructor() {

		Game game = new Game("A");

		Controller controller = new Controller(game);

		assertThat(game.getPlaceholder()).isEqualTo("_");//
	}

	@Test
	public void createsInitialPlaceholderInControllerConstructorForLongerWord() {

		Game game = new Game("Brot");
		Controller controller = new Controller(game);

		assertThat(game.getPlaceholder()).isEqualTo("_ _ _ _");
	}

	@Test
	public void updatesPlaceholderAfterCorrectGuess() {

		Game game = new Game("Brot");
		Controller controller = new Controller(game);

		controller.guessCharacter('R');

		assertThat(game.getPlaceholder()).isEqualTo("_ R _ _");
	}

	@Test
	public void showsMultipleCharactersAfterOneCorrectGuess() {

		Game game = new Game("Hello");
		Controller controller = new Controller(game);

		controller.guessCharacter('L');

		assertThat(game.getPlaceholder()).isEqualTo("_ _ L L _");
	}

	@Test
	public void showsCorrectPlaceholderAfterTwoCorrectGuesses() {

		Game game = new Game("Hello");
		Controller controller = new Controller(game);

		controller.guessCharacter('L');
		controller.guessCharacter('H');

		assertThat(game.getPlaceholder()).isEqualTo("H _ L L _");
	}

	@Test
	public void incrementsFailuresAfterWrongGuess() {

		Game game = new Game("Brot");
		Controller controller = new Controller(game);

		int oldFailCount = game.getFailCount();
		controller.guessCharacter('Y');

		assertThat(game.getFailCount()).isEqualTo(oldFailCount + 1);
	}

	@Test
	public void doesNotIncrementFailuresAfterCorrectGuess() {

		Game game = new Game("Brot");
		Controller controller = new Controller(game);

		int oldFailCount = game.getFailCount();
		controller.guessCharacter('B');

		assertThat(game.getFailCount()).isEqualTo(oldFailCount);
	}

	@Test
	public void setStateToLostAfterMaxIncorrectGuesses() {

		Game game = new Game("Brot");
		game.setFailCount(Game.MAX_FAILS - 1);

		Controller controller = new Controller(game);

		controller.guessCharacter('Y');

		assertThat(game.getStatus()).isEqualTo(GameStatus.LOST);

	}

	@Test
	public void setStateToRunningAfterGameStart() {

		Game game = new Game("Brot");

		Controller controller = new Controller(game);

		assertThat(game.getStatus()).isEqualTo(GameStatus.RUNNING);

	}

	@Test
	public void setStateToWinWhenAllCharactersCorrectlyGuessed() {

		Game game = new Game("hello");

		Controller controller = new Controller(game);
		controller.guessCharacter('h');
		controller.guessCharacter('e');
		controller.guessCharacter('L');
		controller.guessCharacter('O');

		assertThat(game.getStatus()).isEqualTo(GameStatus.WON);
	}
}