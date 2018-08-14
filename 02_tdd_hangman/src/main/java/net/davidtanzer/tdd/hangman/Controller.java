package net.davidtanzer.tdd.hangman;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	private Game game;

	public Controller(Game game) {

		SecretWord secretWord = game.getSecretWord();
		game.setGuessed(new ArrayList<>());

		String placeholder = secretWord.calculatePlaceholder(game.getGuessed());

		game.setPlaceholder(placeholder);

		game.setStatus(GameStatus.RUNNING);
		setGame(game);

	}

	private void setGame(Game game) {
		this.game = game;
	}


	public void guessCharacter(Character character) {

		List<Character> guessed = game.getGuessed();
		guessed.add(Character.toUpperCase(character));

		SecretWord secretWord = game.getSecretWord();

		boolean isIncorrectGuess = secretWord.isIncorrectGuess(character);
		if (isIncorrectGuess) {
			game.setFailCount(game.getFailCount() + 1);

			if (game.getFailCount() >= Game.MAX_FAILS) {
				game.setStatus(GameStatus.LOST);
			}
		} else {
			String placeholder = secretWord.calculatePlaceholder(guessed);
			game.setPlaceholder(placeholder);
			if (!placeholder.contains("_")) {
				game.setStatus(GameStatus.WON);
			}
		}

	}
}
