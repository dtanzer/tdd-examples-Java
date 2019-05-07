package net.davidtanzer.tdd.hangman;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class KonsolenAnzeigeIntegrationsTest {
	@Test
	public void zeigeAktuellenRatezustandAn() {
		InputStream in = new ByteArrayInputStream("".getBytes());
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(byteArrayOutputStream);
		Anzeige anzeige = new KonsolenAnzeige(in, out);

		anzeige.zeigeAn("wort");
		assertThat(byteArrayOutputStream.toString()).isEqualTo("wort");
	}

	@Test
	public void erhorcheEinenBuchstaben() {
		InputStream in = new ByteArrayInputStream("a\n".getBytes());
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(byteArrayOutputStream);
		Anzeige anzeige = new KonsolenAnzeige(in, out);

		GeratenerBuchstabenHorcher horcher = mock(GeratenerBuchstabenHorcher.class);
		anzeige.registriereGerateneBuchstabenHorcher(horcher);

		verify(horcher).horche('a');
	}

	@Test
	public void erhorcheZweiBuchstaben() {
		InputStream in = new ByteArrayInputStream("a\ne\n".getBytes());
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(byteArrayOutputStream);
		Anzeige anzeige = new KonsolenAnzeige(in, out);

		GeratenerBuchstabenHorcher horcher = mock(GeratenerBuchstabenHorcher.class);
		anzeige.registriereGerateneBuchstabenHorcher(horcher);

		verify(horcher).horche('a');
		verify(horcher).horche('e');
	}
}
