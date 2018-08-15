package net.davidtanzer.tdd.hangman;

public class Hangman {

	private final Controller controller;
	private final Game game;
	private final IO io;

	public Hangman(Controller controller, Game game, IO io) {

		this.controller = controller;
		this.game = game;
		this.io = io;
	}

	public void onCharEntered(Character character) {
		controller.guessCharacter(character);

		io.renderPlaceHolder(game.getPlaceholder());
	}
}
