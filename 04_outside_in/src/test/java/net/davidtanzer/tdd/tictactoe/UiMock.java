package net.davidtanzer.tdd.tictactoe;

import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

public class UiMock implements Ui{

	private String hint;

	public void verifyRenderHintCalledWith(String expectedHint) {
		assertThat(hint).isEqualTo(expectedHint);
	}

	@Override
	public void renderHint(String hint) {
		this.hint = hint;
	}
}
