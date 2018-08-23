package net.davidtanzer.tdd.hangman;

public class SecretHolder {

	private String secret;

	public SecretHolder(String secret){
		this.secret = secret;
	}

	public String generateHint(String guess){
		String regex = generateRegex(guess);
		return secret.replaceAll(regex, "-");
	}

	private String generateRegex(String guess) {
		String regex = ".";
		if (!guess.isEmpty()) {
			regex = "[^" + guess + "]";
		}
		return regex;
	}
}
