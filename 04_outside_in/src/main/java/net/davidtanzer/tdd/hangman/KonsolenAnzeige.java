package net.davidtanzer.tdd.hangman;

import java.io.*;

public class KonsolenAnzeige implements Anzeige {
	private final BufferedReader in;
	private final PrintStream out;

	public KonsolenAnzeige(InputStream in, PrintStream out) {
		this.in = new BufferedReader(new InputStreamReader(in));
		this.out = out;
	}

	@Override
	public void zeigeAn(String ratezustand) {
		out.print(ratezustand);
	}

	@Override
	public void registriereGerateneBuchstabenHorcher(GeratenerBuchstabenHorcher horche){


		new Thread(()-> {
			String geleseneZeile;
			try {
				while ((geleseneZeile = in.readLine()) != null) {
					horche.horche(geleseneZeile.charAt(0));
				}
			} catch (IOException ignorieren) {

			}
		}).start();
		try {
			Thread.sleep(10);
		} catch(InterruptedException mirDochEgal) {

		}
	}
}
