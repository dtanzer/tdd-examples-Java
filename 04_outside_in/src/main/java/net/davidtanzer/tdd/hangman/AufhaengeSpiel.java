package net.davidtanzer.tdd.hangman;

public class AufhaengeSpiel {

	public static void main(String... args){
		HangmanNeu hangman = new HangmanNeu();
		hangman.setWort("baumelnderMann");
		HangmanUi hangmanUi = new HangmanUi(hangman, new KonsolenAnzeige(System.in,System.out ));
		hangmanUi.start();
	}
}
