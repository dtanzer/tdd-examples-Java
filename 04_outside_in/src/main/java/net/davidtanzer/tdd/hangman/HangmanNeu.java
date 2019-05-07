package net.davidtanzer.tdd.hangman;

public class HangmanNeu implements Hangman {
	private String wort;
	private String geraten = "_";

	protected void rateBuchstabe(char buchstabe) {
		geraten += buchstabe;
	}

	protected void setWort(String wort) {
		this.wort = wort;
	}

	@Override
	public String getRatezustand(){
		return wort.replaceAll("[^"+ geraten +"]","_" );
	}

	@Override
	public void rate(char buchstabe) {
		rateBuchstabe(buchstabe);
	}
}
