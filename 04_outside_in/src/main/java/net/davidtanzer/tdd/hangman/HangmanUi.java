package net.davidtanzer.tdd.hangman;

public class HangmanUi implements GeratenerBuchstabenHorcher {
	private final Hangman hangman;
	private final Anzeige anzeige;

	public HangmanUi(Hangman hangman, Anzeige anzeige) {
		this.hangman = hangman;
		this.anzeige = anzeige;
		anzeige.registriereGerateneBuchstabenHorcher(this);
	}

	public void start() {
		anzeige.zeigeAn(hangman.getRatezustand());
	}

	@Override
	public void horche(char buchstabe) {
		hangman.rate(buchstabe);
		anzeige.zeigeAn(hangman.getRatezustand());
	}
}
