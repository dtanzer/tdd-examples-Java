package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

@ExtendWith(MockitoExtension.class)
class HangmanMainTest {

	@Mock
	private Ui ui;
	@Mock
	private Hangman hangman;

	@InjectMocks
	private HangmanMain hangmanMain;

	@Test
	public void onStartUIReceivesGeneratedHintFromHangman() {
		when(hangman.generateHint()).thenReturn("-");
		hangmanMain.start();
		verify(ui).renderHint("-");
	}

	@Test
	public void afterStartSingleGuessIsReadAndPassedToHangman(){
		when(hangman.isRunning()).thenReturn(true).thenReturn(false);
		when(ui.readGuess()).thenReturn('a');
		hangmanMain.start();

		verify(hangman).guess('a');
	}

	@Test
	public void hintIsPrintedAfterGuessing() {
		when(hangman.isRunning()).thenReturn(true).thenReturn(false);
		hangmanMain.start();

		verify(ui, times(2)).renderHint(any());
	}


}