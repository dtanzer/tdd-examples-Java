package net.davidtanzer.tdd.hangman;

public class HangmanImpl {

	private String guess = "";
	private SecretHolder secretHolder;

	public HangmanImpl(SecretHolder secretHolder){
		this.secretHolder = secretHolder;
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
