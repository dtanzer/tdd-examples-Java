package net.davidtanzer.tdd.tictactoe;

public class HangmanMain {

	private Ui ui;
	private HangmanFactory hangmanFactory;

	public HangmanMain(Ui ui, HangmanFactory hangmanFactory) {
		this.ui = ui;
		this.hangmanFactory = hangmanFactory;
	}

	public void start() {
		Hangman hangman = hangmanFactory.createHangman();
		ui.renderHint(hangman.generateHint());
	}
}
