package net.davidtanzer.tdd.hangman;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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

		int index = s.getWort().indexOf(buchstabe);
		StringBuilder stringBuilder = new StringBuilder(ratezustand);

		while(index >= 0){
			stringBuilder.setCharAt(index, buchstabe);
			index = s.getWort().indexOf(buchstabe,index+1);
		}

		ratezustand = stringBuilder.toString();
	}
}
