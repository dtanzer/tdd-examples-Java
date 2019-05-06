package net.davidtanzer.tdd.hangman;

public class SecretWordContainer {

	private final String wort;

	public SecretWordContainer(String wort) {
		this.wort = wort;
	}

	public String getWort() {
		return wort;
	}

	int indexOf(char buchstabe, int i) {
		return getWort().indexOf(buchstabe, i);
	}
}
