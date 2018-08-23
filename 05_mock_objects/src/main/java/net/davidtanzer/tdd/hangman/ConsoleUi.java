package net.davidtanzer.tdd.hangman;

import java.io.IOException;

public class ConsoleUi implements Ui {

	@Override
	public void renderHint(String hint) {
		System.out.println(hint);
	}

	@Override
	public char readGuess() {
		try {
			return (char)System.in.read();
		} catch (IOException e) {
			throw new RuntimeException("Error during guess.", e);
		}
	}
}
