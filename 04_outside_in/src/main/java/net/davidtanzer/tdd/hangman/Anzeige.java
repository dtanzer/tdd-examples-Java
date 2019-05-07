package net.davidtanzer.tdd.hangman;

import java.util.function.Consumer;

public interface Anzeige {
	public void zeigeAn(String ratezustand);

	void registriereGerateneBuchstabenHorcher(GeratenerBuchstabenHorcher horche);
}
