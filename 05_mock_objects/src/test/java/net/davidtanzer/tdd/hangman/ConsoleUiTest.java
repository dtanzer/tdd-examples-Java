package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ConsoleUiTest {

	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	PrintStream out = new PrintStream(outputStream);

	ConsoleUi ui = new ConsoleUi();

	@Test
	void hintIsPrinted() {
		System.setOut(out);
		ui.renderHint("-");
		assertThat(new String(outputStream.toByteArray())).isEqualTo("-\r\n");
	}

	@Test
	void guessIsRead(){
		System.setIn(new ByteArrayInputStream("a".getBytes()));
		char guess = ui.readGuess();
		assertThat(guess).isEqualTo('a');
	}

	@Test
	void secondGuessIsRead(){
		System.setIn(new ByteArrayInputStream("ab".getBytes()));
		ui.readGuess();
		char guess = ui.readGuess();
		assertThat(guess).isEqualTo('b');
	}
}