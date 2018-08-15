package net.davidtanzer.tdd.tictactoe;

import java.util.Objects;

public class Position {
	private final Col col;
	private final Row row;

	public Position(Col col, Row row) {
		this.col = col;
		this.row = row;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return col == position.col &&
				row == position.row;
	}

	@Override
	public int hashCode() {
		return Objects.hash(col, row);
	}
}
