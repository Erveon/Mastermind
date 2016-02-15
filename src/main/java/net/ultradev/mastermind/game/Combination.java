package net.ultradev.mastermind.game;

import java.util.Arrays;

import net.ultradev.mastermind.game.Game.Color;

public class Combination {
	
	private Color[] colors;
	
	public Combination(Color... colors) {
		this.colors = colors;
	}
	
	public Color[] getColors() {
		return colors;
	}
	
	public boolean equals(Combination combination) {
		return Arrays.equals(colors, combination.getColors());
	}

}
