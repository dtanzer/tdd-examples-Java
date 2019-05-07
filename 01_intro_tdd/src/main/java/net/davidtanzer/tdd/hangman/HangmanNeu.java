package net.davidtanzer.tdd.hangman;

public class HangmanNeu {
	private String wort;
	private String geraten = "_";

	protected void rateBuchstabe(char buchstabe) {
		geraten += buchstabe;
	}

	protected void setWort(String wort) {
		this.wort = wort;
	}

	String getRatezustand(){
		return wort.replaceAll("[^"+ geraten +"]","_" );
	}
}
