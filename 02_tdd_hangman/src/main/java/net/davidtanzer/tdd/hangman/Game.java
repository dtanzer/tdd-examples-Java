package net.davidtanzer.tdd.hangman;

import java.util.List;

public class Game {
	public static final int MAX_FAILS = 11;
	private String placeholder;

	private int failCount;
	private GameStatus status;
	private SecretWord secretWord;

	private List<Character> guessed;

	public Game(String secretWord) {
		this.secretWord = new SecretWord(secretWord);
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public SecretWord getSecretWord() {
		return secretWord;
	}

	public List<Character> getGuessed() {
		return guessed;
	}

	public void setGuessed(List<Character> guessed) {
		this.guessed = guessed;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}
}
