package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HangmanTest {
	private Hangman hangman = new Hangman("test");

	@Test
	public void platzHalterStimmtMitWortlaenge() {
		assertThat(hangman.getRatezustand().length()).isEqualTo(4);
	}

	@Test
	public void initialPlatzhalter(){
		assertThat(hangman.getRatezustand()).matches("_+");
	}

	@Test
	public void platzHalterStimmtMitWortlaenge_keineAhnung() {
		Hangman hangman = new Hangman("keineAhnung");
		assertThat(hangman.getRatezustand().length()).isEqualTo(11);
	}

	@Test
	public void ungeratenerBuchstabeWirdNichtAufgedeckt( ){
		hangman.rateBuchstabe('e');
		assertThat(hangman.getRatezustand()).isEqualTo("_e__");
	}

	@Test
	public void mehrereBuchstabenWerdenAufgedeckt() {
		hangman.rateBuchstabe('s');
		hangman.rateBuchstabe('e');
		assertThat(hangman.getRatezustand()).isEqualTo("_es_");
	}

	@Test
	public void alleGleichenBuchstabenWerdenAufgedeckt(){
		hangman.rateBuchstabe('t');
		assertThat(hangman.getRatezustand()).isEqualTo("t__t");
	}


}