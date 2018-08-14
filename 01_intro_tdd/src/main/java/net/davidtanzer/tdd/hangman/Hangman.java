package net.davidtanzer.tdd.hangman;

import java.util.List;
import java.util.Random;

public class Hangman {
	public String chooseWord(List<String> wordsToChooseFrom) {

		if(wordsToChooseFrom == null){
			throw new IllegalArgumentException("wordstochoosefrom must not be null");
		}

		int size = wordsToChooseFrom.size();

		if(size <= 0){
			throw new IllegalArgumentException("wordstochoosefrom must not be empty");
		}

		Random random = new Random();

		int index = random.nextInt(size);


		return wordsToChooseFrom.get(index);
	}


	public List<Integer> findCharacters(String word, String character) {
		return null;
	}
}
