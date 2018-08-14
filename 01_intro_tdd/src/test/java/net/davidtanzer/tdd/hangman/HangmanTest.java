package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HangmanTest {
	private Hangman hangman = new Hangman();

	@Test
	public void testCanChooseWord() {

		List<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("word");
		assertThat(hangman.chooseWord(words)).isNotEmpty();
	}

	@Test
	public void testWordListMustNotBeEmpty(){
		List<String> words = new ArrayList<String>();

		assertThatThrownBy(() -> hangman.chooseWord(words))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("wordstochoosefrom must not be empty");
	}

	@Test
	public void testWordListMustNotBeNull(){
		assertThatThrownBy(() -> hangman.chooseWord(null))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("wordstochoosefrom must not be null");
	}

	@Test
	public void testFindCharacters(){
		String word = "Test";
		String character = "e";

		List<Integer> indexes = hangman.findCharacters(word, character);

		assertThat(indexes).contains(1);

	}
}