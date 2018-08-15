package net.davidtanzer.tdd.tictactoe;

import org.junit.jupiter.api.Assertions;

public class MockController implements Controller {

	private Character calledCharacter;

	public void verifyGuessCharacterCalled(Character character) {
		if (this.calledCharacter == null)
			Assertions.fail("not called");

		if (!this.calledCharacter.equals(character))
			Assertions.fail("wrong character called. expected: " + character + ", actual: " + calledCharacter);
	}

	@Override
	public void guess(Character character) {
		this.calledCharacter = character;
	}
}


