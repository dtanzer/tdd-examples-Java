package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HangmanTest {

	@Test
	public void hintIsInitiallySingleDashForLetterA() {
		Hangman hangman = new Hangman("a");
		String hint = hangman.generateHint();
		assertThat(hint).isEqualTo("-");
	}

	@Test
	void hintIsInitiallySixDashesForWordRandom() {
		Hangman hangman = new Hangman("random");
		String hint = hangman.generateHint();
		assertThat(hint).isEqualTo("------");
	}

	@Test
	public void hintIsLetterAAfterGuessingCorrectly() {
		Hangman hangman = new Hangman("a");
		hangman.guess('a');
		assertThat(hangman.generateHint()).isEqualTo("a");
	}

	@Test
	public void hintHasRARevealedAfterGuessingCorrectlyTwice() {
		Hangman hangman = new Hangman("random");
		hangman.guess('a');
		hangman.guess('r');
		assertThat(hangman.generateHint()).isEqualTo("ra----");
	}
}