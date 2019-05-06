package net.davidtanzer.tdd.hangman;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hangman {


	private final String wort;
	private String ratezustand;

	public Hangman(String wort) {

		this.wort = wort;
		ratezustand = wort.replaceAll(".", "_");
	}

	public String getRatezustand() {
		return ratezustand;

	}

	public void rateBuchstabe(char buchstabe) {

		int index = wort.indexOf(buchstabe);
		StringBuilder stringBuilder = new StringBuilder(ratezustand);

		while(index >= 0){
			stringBuilder.setCharAt(index, buchstabe);
			index = wort.indexOf(buchstabe,index+1);
		}

		ratezustand = stringBuilder.toString();
	}
}
