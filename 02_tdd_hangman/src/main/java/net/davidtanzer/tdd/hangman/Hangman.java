package net.davidtanzer.tdd.hangman;

public class Hangman {

	private final SecretWordContainer s;
	private String ratezustand;

	public Hangman(String wort) {
		s = new SecretWordContainer(wort);
		ratezustand = wort.replaceAll(".", "_");
	}

	public String getRatezustand() {
		return ratezustand;

	}

	public void rateBuchstabe(char buchstabe) {

		int index = s.indexOf(buchstabe, 0);
		StringBuilder stringBuilder = new StringBuilder(ratezustand);

		while(index >= 0){
			stringBuilder.setCharAt(index, buchstabe);
			index = s.indexOf(buchstabe, index+1);
		}

		ratezustand = stringBuilder.toString();
	}

}
