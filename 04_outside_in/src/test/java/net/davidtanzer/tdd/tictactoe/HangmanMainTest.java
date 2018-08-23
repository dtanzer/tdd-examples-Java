package net.davidtanzer.tdd.tictactoe;

import org.junit.jupiter.api.Test;

class HangmanMainTest {
	private UiMock ui = new UiMock();
	private HangmanFactoryStub hangmanFactory = new HangmanFactoryStub();
	private HangmanMain hangmanMain = new HangmanMain(ui, hangmanFactory);

	@Test
	public void fixmeGiveMeABetterName() {
		hangmanMain.start();
		ui.verifyRenderHintCalledWith("-");
	}

	private class HangmanFactoryStub implements HangmanFactory{
		@Override
		public Hangman createHangman(){
			return new Hangman() {
				@Override
				public String generateHint() {
					return "-";
				}
			};
		}
	}
}