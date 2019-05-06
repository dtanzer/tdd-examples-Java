package net.davidtanzer.tdd.hangman;

public class SecretWordContainer {

	private final String wort;

	public SecretWordContainer(String wort) {
		this.wort = wort;
	}

	public int length(){
		return wort.length();
	}

	int indexOf(char buchstabe, int i) {
		return wort.indexOf(buchstabe, i);
	}
}
