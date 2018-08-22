package net.davidtanzer.tdd.hangman;

public class Hangman {

	private String secret;
	private String guess = "";

	public Hangman(String secret) {
		this.secret = secret;
	}

	public String generateHint() {
		String regex = generateRegex(guess);
		return secret.replaceAll(regex, "-");
	}

	private String generateRegex(String guess) {
		String regex = ".";
		if (!guess.isEmpty()) {
			regex = "[^" + guess + "]";
		}
		return regex;
	}

	public void guess(char guess) {
		//Code Vorbedingungen

		this.guess += guess;

		//Code Fehlercount, Status, ...
	}
}
