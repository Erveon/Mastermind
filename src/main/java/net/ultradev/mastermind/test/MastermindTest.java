package net.ultradev.mastermind.test;

import net.ultradev.mastermind.game.Combination;
import net.ultradev.mastermind.game.Game;
import net.ultradev.mastermind.game.Game.Color;
import net.ultradev.mastermind.game.Game.GameState;

public class MastermindTest {

	public enum WinCondition { LASTTRY, FIRSTTRY, NEVER };
	
	//Rather use an enum than method names like 'testWinOnTheFirstTry'
	public static void testWin(WinCondition condition) {
		Game g = new Game(3, new Combination(Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK));
		
		//First guess
		if(condition.equals(WinCondition.FIRSTTRY)) {
			g.guess(new Combination(Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK));
			if(!g.getState().equals(GameState.WON))
				System.out.println("Test failed: did not win on the first try.");
			return;
		} else {
			g.guess(new Combination(Color.GREEN, Color.BLUE, Color.YELLOW, Color.GREEN));
			if(g.getState().equals(GameState.WON))
				System.out.println("Test failed: Won on the first try when this was not the point");
		}

		//Second guess
		g.guess(new Combination(Color.GREEN, Color.BLUE, Color.YELLOW, Color.GREEN));
		if(g.getState().equals(GameState.WON))
			System.out.println("Test failed: Was not supposed to win the second guess, ever.");
		
		//Third guess
		if(condition.equals(WinCondition.LASTTRY)) {
			g.guess(new Combination(Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK));
			if(!g.getState().equals(GameState.WON))
				System.out.println("Test failed: did not win on the last try.");
			return;
		} else {
			g.guess(new Combination(Color.GREEN, Color.BLUE, Color.YELLOW, Color.GREEN));
			if(!g.getState().equals(GameState.LOST))
				System.out.println("Test failed: did not lose the last try.");
		}
		
	}
	
}
