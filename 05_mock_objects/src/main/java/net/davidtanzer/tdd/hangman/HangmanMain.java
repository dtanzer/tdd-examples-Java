package net.davidtanzer.tdd.hangman;

public class HangmanMain {

	private Ui ui;
	private Hangman hangman;

	public HangmanMain(Ui ui, Hangman hangman) {
		this.ui = ui;
		this.hangman = hangman;
	}

	public void start() {
		String hint = hangman.generateHint();
		ui.renderHint(hint);
		while (hangman.isRunning()) {
			char guess = ui.readGuess();
			hangman.guess(guess);
			hint = hangman.generateHint();
			ui.renderHint(hint);
		}
	}

	public static void main(String[] args) {
		HangmanMain hangmanMain = new HangmanMain(new ConsoleUi(), new HangmanImpl(new SecretHolder("geheim")));
		hangmanMain.start();
	}
}
