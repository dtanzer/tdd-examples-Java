package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class HangmanUiTest {
	Hangman hangman;
	Anzeige anzeige;
	HangmanUi hangmanUi;

	@BeforeEach
	public void initialisierung(){
		hangman = mock(Hangman.class);
		anzeige = mock(Anzeige.class);
		hangmanUi = new HangmanUi(hangman, anzeige);
	}

	@Test
	public void startAnzeigeZeigtRatezustandAn() {
		//given
		String ratezustand = "_____";

		//when
		when(hangman.getRatezustand()).thenReturn(ratezustand);
		hangmanUi.start();

		//verify
		verify(anzeige).zeigeAn(ratezustand);
	}

	@Test
	public void beiHorcheRateUndZeigeAn(){
		//given
		String ratezustand = "_____";
		char buchstabe = 'e';
		//when
		when(hangman.getRatezustand()).thenReturn(ratezustand);
		hangmanUi.horche(buchstabe);

		//verify
		InOrder inorder = Mockito.inOrder(hangman, anzeige);
		inorder.verify(hangman).rate(buchstabe);
		inorder.verify(anzeige).zeigeAn(ratezustand);
	}

	@Test
	public void registriereAlsGeratenerBuchstabenHorcher() {
		hangmanUi = new HangmanUi(hangman, anzeige);
		verify(anzeige).registriereGerateneBuchstabenHorcher(hangmanUi);
	}
}