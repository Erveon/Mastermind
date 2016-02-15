package net.ultradev.mastermind;

import net.ultradev.mastermind.test.MastermindTest;
import net.ultradev.mastermind.test.MastermindTest.WinCondition;

public class Mastermind {
	
	public static void main(String[] args) {
		System.out.println("Running..");
		MastermindTest.testWin(WinCondition.FIRSTTRY);
		MastermindTest.testWin(WinCondition.LASTTRY);
		MastermindTest.testWin(WinCondition.NEVER);
		System.out.println("Finished testing, if no 'failed test' was given between the start and this line, then the program ran correctly..");
	}
	
}
