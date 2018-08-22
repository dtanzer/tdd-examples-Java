package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HangmanTest {

	@Test
	public void testHintIsReturnedForGivenWord() {
		assertThat(new Hangman("random").getHint()).isEqualTo("------");
		assertThat(new Hangman("happy").getHint()).isEqualTo("-----");
	}

	@Test
	public void testHintIsUpdatedIfTheGuessIsCorrect(){
		Hangman hangman =new Hangman("random");
        hangman.guess('a');
		assertThat(hangman.getHint()).isEqualTo("-a----");
	}






}