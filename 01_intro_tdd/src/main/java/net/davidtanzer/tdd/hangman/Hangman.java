package net.davidtanzer.tdd.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Hangman {
	private String word;
	private List<Character> guesses = new ArrayList<>();

	public Hangman(String word) {
		this.word = word;
	}

	public String getHint() {
		StringBuilder hint = new StringBuilder();
		Arrays.asList(word.toCharArray()).stream().forEach(c->{
			System.out.println(c);
			if(guesses.contains(c)){
				hint.append(c);
			} else {
				hint.append('-');
			}
		});
		return hint.toString();
	}

	public void guess(char guess) {
		guesses.add(guess);
	}
}
