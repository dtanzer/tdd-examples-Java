package net.davidtanzer.tdd.hangman;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Arrays;

public class Hangman {

	private final SecretWordContainer s;
	private String ratezustand;

	public Hangman(SecretWordContainer container) {
		s = container;
		char[] array = new char[s.length()];
		Arrays.fill(array, '_');
		ratezustand = new String(array);
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
