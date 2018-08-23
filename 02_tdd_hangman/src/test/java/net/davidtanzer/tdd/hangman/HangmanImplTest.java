package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HangmanImplTest {

	@Test
	public void hintIsInitiallySingleDashForLetterA() {
		HangmanImpl hangmanImpl = new HangmanImpl(new SecretHolder("a"));
		String hint = hangmanImpl.generateHint();
		assertThat(hint).isEqualTo("-");
	}

	@Test
	void hintIsInitiallySixDashesForWordRandom() {
		HangmanImpl hangmanImpl = new HangmanImpl(new SecretHolder("random"));
		String hint = hangmanImpl.generateHint();
		assertThat(hint).isEqualTo("------");
	}

	@Test
	public void hintIsLetterAAfterGuessingCorrectly() {
		HangmanImpl hangmanImpl = new HangmanImpl(new SecretHolder("a"));
		hangmanImpl.guess('a');
		assertThat(hangmanImpl.generateHint()).isEqualTo("a");
	}

	@Test
	public void hintHasRARevealedAfterGuessingCorrectlyTwice() {
		HangmanImpl hangmanImpl = new HangmanImpl(new SecretHolder("random"));
		hangmanImpl.guess('a');
		hangmanImpl.guess('r');
		assertThat(hangmanImpl.generateHint()).isEqualTo("ra----");
	}
}