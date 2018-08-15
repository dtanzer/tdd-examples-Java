package net.davidtanzer.tdd.tictactoe;

import org.junit.jupiter.api.Test;

class HangmanTest {

	@Test
	public void controllerGuessesUserInput() {

		Controller controller = new MockController();
		Game game = new GameStub();
		IO io = new MockIO();

		Hangman hangman = new Hangman(controller, game, io);

		Character character = 'C';
		hangman.onCharEntered(character);

		((MockController) controller).verifyGuessCharacterCalled(character);
	}

	@Test
	public void renderPlaceholderOnCharacterEntered(){
		Controller controller = new MockController();
		Game game = new GameStub();
		MockIO io = new MockIO();

		Hangman hangman = new Hangman(controller, game, io);

		Character character = 'C';
		hangman.onCharEntered(character);

		String expectedPlaceholder = game.getPlaceholder();

		io.verifyRenderPlaceholderCalled(expectedPlaceholder);

	}

	private class GameStub implements Game {
		@Override
		public String getPlaceholder() {
			return "_";
		}
	}
}