package net.ultradev.mastermind.game;

public class Game {

	public enum Color { YELLOW, ORANGE, RED, BLUE, BLACK, GREEN };
	public enum GameState { PLAYING, WON, LOST };
	
	private int maxTries;
	private int tries;
	private GameState state;
	
	private Combination secret;
	
	public Game(int maxTries, Combination secretColors) {
		this.maxTries = maxTries;
		this.secret = secretColors;
		this.state = GameState.PLAYING;
	}
	
	private Combination getSecret() {
		return secret;
	}
	
	public GameState getState() {
		return state;
	}
	
	public void guess(Combination combination) {
		if(combination.getColors().length != secret.getColors().length) {
			return;
		}
		if(getSecret().equals(combination)) {
			win();
		} else {
			tries++;
			if(tries == maxTries) {
				lose();
			}
		}
	}
	
	public void win() {
		state = GameState.WON;
		System.out.println("Congratulations, you won!");
	}
	
	public void lose() {
		state = GameState.LOST;
		System.out.println("Ahh damn, you lost!");
	}
	
}
