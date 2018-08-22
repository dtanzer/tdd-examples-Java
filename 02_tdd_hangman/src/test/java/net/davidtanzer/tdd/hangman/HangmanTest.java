package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HangmanTest {

	@Test
	public void hintIsInitiallySingleDashForLetterA() {
		Hangman hangman = new Hangman(new SecretHolder("a"));
		String hint = hangman.generateHint();
		assertThat(hint).isEqualTo("-");
	}

	@Test
	void hintIsInitiallySixDashesForWordRandom() {
		Hangman hangman = new Hangman(new SecretHolder("random"));
		String hint = hangman.generateHint();
		assertThat(hint).isEqualTo("------");
	}

	@Test
	public void hintIsLetterAAfterGuessingCorrectly() {
		Hangman hangman = new Hangman(new SecretHolder("a"));
		hangman.guess('a');
		assertThat(hangman.generateHint()).isEqualTo("a");
	}

	@Test
	public void hintHasRARevealedAfterGuessingCorrectlyTwice() {
		Hangman hangman = new Hangman(new SecretHolder("random"));
		hangman.guess('a');
		hangman.guess('r');
		assertThat(hangman.generateHint()).isEqualTo("ra----");
	}
}