package net.davidtanzer.tdd.hangman;

public interface Ui {
	void renderHint(String hint);

	char readGuess();
}
