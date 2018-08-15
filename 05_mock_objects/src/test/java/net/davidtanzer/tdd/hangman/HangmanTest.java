package net.davidtanzer.tdd.hangman;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class HangmanTest {

	@Test
	public void controllerGuessesUserInput() {

		Controller controller = mock(Controller.class);
		Game game = mock(Game.class);
		IO io = mock(IO.class);

		Hangman hangman = new Hangman(controller, game, io);

		Character character = 'C';
		hangman.onCharEntered(character);

		verify(controller).guessCharacter(character);
	}

	@Test
	public void renderPlaceholderOnCharacterEntered(){
		Controller controller = mock(Controller.class);
		Game game = mock(Game.class);
		IO io = mock(IO.class);
		Hangman hangman = new Hangman(controller, game, io);

		String expectedPlaceholder = "_";
		when(game.getPlaceholder()).thenReturn(expectedPlaceholder);

		hangman.onCharEntered('C');

		verify(io).renderPlaceHolder(expectedPlaceholder);

	}
}