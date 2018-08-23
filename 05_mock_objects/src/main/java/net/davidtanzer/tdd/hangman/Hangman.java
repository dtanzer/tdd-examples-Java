package net.davidtanzer.tdd.hangman;

public interface Hangman {
	String generateHint();
	boolean isRunning();

	void guess(char a);
}
