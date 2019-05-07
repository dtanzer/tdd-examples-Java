package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class HangmanTest {

	private final HangmanNeu hangmanNeu = new HangmanNeu();

	@Test
	public void initialerRatezustandBeiWortTest() {
		hangmanNeu.setWort("test");
		assertThat(hangmanNeu.getRatezustand()).isEqualTo("____");
	}

	@Test
	public void initialerRatezustandBeiWortWtf() {
		hangmanNeu.setWort("wtf");
		assertThat(hangmanNeu.getRatezustand()).isEqualTo("___");
	}

	@Test
	public void ratezustandNachGeratenE() {
		hangmanNeu.setWort("test");
		hangmanNeu.rateBuchstabe('e');

		assertThat(hangmanNeu.getRatezustand()).isEqualTo("_e__");
	}

	@Test
	public void ratezustandNachGeratenEUndS() {
		hangmanNeu.setWort("test");
		hangmanNeu.rateBuchstabe('e');
		hangmanNeu.rateBuchstabe('s');

		assertThat(hangmanNeu.getRatezustand()).isEqualTo("_es_");
	}

}