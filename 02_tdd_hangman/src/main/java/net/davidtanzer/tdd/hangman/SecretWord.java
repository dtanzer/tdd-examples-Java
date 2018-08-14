package net.davidtanzer.tdd.hangman;

import java.util.List;

public class SecretWord {
	private String secretWord;

	public SecretWord(String secretWord) {
		this.secretWord = secretWord.toUpperCase();
	}

	public boolean isIncorrectGuess(Character character){
		return !secretWord.contains(String.valueOf(character));
	}

	public String calculatePlaceholder(List<Character> guessed) {
		int wordLength = secretWord.length();

		String placeholder = "";
		for (int i = 0; i < wordLength; i++) {
			Character charAt = secretWord.charAt(i);
			if (guessed.contains(charAt)) {
				placeholder += charAt;
			} else {
				placeholder += "_";
			}

			placeholder += " ";
		}

		return placeholder.trim();
	}
}
