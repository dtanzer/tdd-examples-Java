package net.davidtanzer.tdd.tictactoe;

import org.junit.jupiter.api.Assertions;

public class MockIO implements IO {
	private String placeholder;

	@Override
	public void renderPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public void verifyRenderPlaceholderCalled(String expectedPlaceholder) {
		if (this.placeholder == null)
			Assertions.fail("not called");

		if (!this.placeholder.equals(expectedPlaceholder)) {
			Assertions.fail("Placeholder was not equal to expected Placeholder");
		}
	}
}
