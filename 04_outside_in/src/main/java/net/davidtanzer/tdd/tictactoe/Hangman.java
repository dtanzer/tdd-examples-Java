package net.davidtanzer.tdd.tictactoe;

public class Hangman {
	private final Controller controller;
	private Game game;
	private final IO io;


	public Hangman(Controller controller, Game game, IO io) {
		this.controller = controller;
		this.game = game;
		this.io = io;
	}

	public void onCharEntered(Character character) {
		controller.guess(character);

		String placeholder = game.getPlaceholder();

		io.renderPlaceholder(placeholder);
	}
}
