package net.davidtanzer.tdd.hangman;

public class Hangman {
	
	private String guess = "";
	private SecretHolder secretHolder;

	public Hangman(String secret) {
		this.secretHolder = new SecretHolder(secret);
	}

	public String generateHint() {
		return secretHolder.generateHint(guess);
	}

	public void guess(char guess) {
		//Code Vorbedingungen

		this.guess += guess;

		//Code Fehlercount, Status, ...
	}
}
