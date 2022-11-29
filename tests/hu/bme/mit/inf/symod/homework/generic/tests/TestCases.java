package hu.bme.mit.inf.symod.homework.generic.tests;

import org.junit.Test;

public class TestCases {
	public static void main(String[] args) {
		TestCases testCases = new TestCases();
		try{ testCases.base1(); }catch(AssertionError e) {}try{ testCases.base2(); }catch(AssertionError e) {}try{ testCases.optionCycle(); }catch(AssertionError e) {}try{ testCases.checkSetStartTime(); }catch(AssertionError e) {}try{ testCases.checkSetBonusTime(); }catch(AssertionError e) {}try{ testCases.checkSetMaxTime(); }catch(AssertionError e) {}try{ testCases.checkSetStartPlayer(); }catch(AssertionError e) {}try{ testCases.checkEffectSetStartPlayer(); }catch(AssertionError e) {}try{ testCases.checkEffectSetStartTime(); }catch(AssertionError e) {}try{ testCases.checkEffectSetBonusTime(); }catch(AssertionError e) {}try{ testCases.checkResetInOptions(); }catch(AssertionError e) {}try{ testCases.checkStartInGame(); }catch(AssertionError e) {}try{ testCases.checkModInGame(); }catch(AssertionError e) {}try{ testCases.checkLastSeconds(); }catch(AssertionError e) {}
	}
	
	@Test(timeout=10000)
	public void base1() {
		TesterAPI c = new TesterAPI("base1","Basic test: Pressing each button.");
	c.pushBlack();
	c.pushWhite();
	c.pushMod();
	c.pushStart();
	System.out.println("base1 Succeeded!");
	}
	
	@Test(timeout=10000)
	public void base2() {
		TesterAPI c = new TesterAPI("base2","Basic test: Waiting for 3 sec.");
	c.clockForward(3000);
	System.out.println("base2 Succeeded!");
	}
	
	@Test(timeout=10000)
	public void optionCycle() {
		TesterAPI c = new TesterAPI("optionCycle","By pushing the MOD button in the menu each options are available, and are set to the default values.");
	c.expectText("Ready to play");
	c.pushMod();
	c.expectBeep(false);
	c.expectText("White begins");
	c.pushMod();
	c.expectBeep(false);
	c.expectText("Initial time");
	c.expectWhiteNumber(120);
	c.pushMod();
	c.expectBeep(false);
	c.expectText("Increment time");
	c.expectWhiteNumber(10);
	c.pushMod();
	c.expectBeep(false);
	c.expectText("Maximal time");
	c.expectWhiteNumber(600);
	c.pushMod();
	c.expectBeep(false);
	c.expectText("Ready to play");
	System.out.println("optionCycle Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkSetStartTime() {
		TesterAPI c = new TesterAPI("checkSetStartTime","Checking the upper and lower bounds of the target option. First, the value is increased from default to maximal, plus one more time to check if it stops. Then, it decreased to minimal and checked again it it stops.");
	c.pushMod();
	c.pushMod();
	c.expectWhiteNumber(120);
	c.pushWhite();
	c.expectWhiteNumber(130);
	c.pushWhite();
	c.expectWhiteNumber(140);
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.expectWhiteNumber(280);
	c.pushWhite();
	c.expectWhiteNumber(290);
	c.pushWhite();
	c.expectWhiteNumber(300);
	c.pushWhite();
	c.expectBeep(true);
	c.expectWhiteNumber(300);
	c.pushBlack();
	c.expectWhiteNumber(290);
	c.pushBlack();
	c.expectWhiteNumber(280);
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.expectWhiteNumber(50);
	c.pushBlack();
	c.expectWhiteNumber(40);
	c.pushBlack();
	c.expectWhiteNumber(30);
	c.pushBlack();
	c.expectWhiteNumber(30);
	c.expectBeep(true);
	System.out.println("checkSetStartTime Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkSetBonusTime() {
		TesterAPI c = new TesterAPI("checkSetBonusTime","Checking the upper and lower bounds of the target option. First, the value is increased from default to maximal, plus one more time to check if it stops. Then, it decreased to minimal and checked again it it stops.");
	c.pushMod();
	c.pushMod();
	c.pushMod();
	c.expectWhiteNumber(10);
	c.pushWhite();
	c.expectWhiteNumber(11);
	c.pushWhite();
	c.expectWhiteNumber(12);
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.expectWhiteNumber(28);
	c.pushWhite();
	c.expectWhiteNumber(29);
	c.pushWhite();
	c.expectWhiteNumber(30);
	c.pushWhite();
	c.expectBeep(true);
	c.expectWhiteNumber(30);
	c.pushBlack();
	c.expectWhiteNumber(29);
	c.pushBlack();
	c.expectWhiteNumber(28);
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.expectWhiteNumber(2);
	c.pushBlack();
	c.expectWhiteNumber(1);
	c.pushBlack();
	c.expectWhiteNumber(0);
	c.pushBlack();
	c.expectWhiteNumber(0);
	c.expectBeep(true);
	System.out.println("checkSetBonusTime Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkSetMaxTime() {
		TesterAPI c = new TesterAPI("checkSetMaxTime","Checking the upper and lower bounds of the target option. First, the value is increased from default to maximal, plus one more time to check if it stops. Then, it decreased to minimal and checked again it it stops.");
	c.pushMod();
	c.pushMod();
	c.pushMod();
	c.pushMod();
	c.expectWhiteNumber(600);
	c.pushWhite();
	c.expectWhiteNumber(660);
	c.pushWhite();
	c.expectWhiteNumber(720);
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.pushWhite();
	c.expectWhiteNumber(1080);
	c.pushWhite();
	c.expectWhiteNumber(1140);
	c.pushWhite();
	c.expectWhiteNumber(1200);
	c.pushWhite();
	c.expectBeep(true);
	c.expectWhiteNumber(1200);
	c.pushBlack();
	c.expectWhiteNumber(1140);
	c.pushBlack();
	c.expectWhiteNumber(1080);
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.pushBlack();
	c.expectWhiteNumber(720);
	c.pushBlack();
	c.expectWhiteNumber(660);
	c.pushBlack();
	c.expectWhiteNumber(600);
	c.pushBlack();
	c.expectWhiteNumber(600);
	c.expectBeep(true);
	System.out.println("checkSetMaxTime Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkSetStartPlayer() {
		TesterAPI c = new TesterAPI("checkSetStartPlayer","Checking whether the initial player can be set.");
	c.pushMod();
	c.expectText("White begins");
	c.pushBlack();
	c.expectText("Black begins");
	c.pushBlack();
	c.expectText("Black begins");
	c.pushWhite();
	c.expectText("White begins");
	System.out.println("checkSetStartPlayer Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkEffectSetStartPlayer() {
		TesterAPI c = new TesterAPI("checkEffectSetStartPlayer","Checks the result of changing the initial player.");
	c.pushMod();
	c.pushBlack();
	c.pushMod();
	c.pushMod();
	c.pushMod();
	c.pushMod();
	c.expectText("Ready to play");
	c.pushStart();
	c.expectText("Black moves");
	System.out.println("checkEffectSetStartPlayer Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkEffectSetStartTime() {
		TesterAPI c = new TesterAPI("checkEffectSetStartTime","Checks the result of changeing the initial time for player Global.");
	c.pushMod();
	c.pushMod();
	c.expectText("Initial time");
	c.expectWhiteNumber(120);
	c.pushWhite();
	c.expectText("Initial time");
	c.expectWhiteNumber(130);
	c.pushMod();
	c.pushMod();
	c.pushMod();
	c.expectText("Ready to play");
	c.pushStart();
	c.expectText("White moves");
	c.expectWhiteNumber(130);
	c.clockForward(3000);
	c.expectWhiteNumber(127);
	c.pushWhite();
	c.expectBeep(true);
	c.expectText("Black moves");
	c.expectBlackNumber(130);
	c.clockForward(3000);
	c.expectBlackNumber(127);
	System.out.println("checkEffectSetStartTime Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkEffectSetBonusTime() {
		TesterAPI c = new TesterAPI("checkEffectSetBonusTime","Checks the result of changeing the initial time for player Global.");
	c.pushMod();
	c.pushMod();
	c.pushMod();
	c.expectText("Increment time");
	c.expectWhiteNumber(10);
	c.pushWhite();
	c.expectText("Increment time");
	c.expectWhiteNumber(11);
	c.pushMod();
	c.pushMod();
	c.expectText("Ready to play");
	c.pushStart();
	c.expectText("White moves");
	c.expectWhiteNumber(120);
	c.expectBlackNumber(120);
	c.pushWhite();
	c.expectBeep(true);
	c.expectText("Black moves");
	c.pushBlack();
	c.expectBeep(true);
	c.expectText("White moves");
	c.expectWhiteNumber(131);
	c.expectBlackNumber(131);
	System.out.println("checkEffectSetBonusTime Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkResetInOptions() {
		TesterAPI c = new TesterAPI("checkResetInOptions","Checking the effect of pushing the START/RESET button in the options.");
	c.pushMod();
	c.pushMod();
	c.expectText("Initial time");
	c.expectWhiteNumber(120);
	c.pushWhite();
	c.expectText("Initial time");
	c.expectWhiteNumber(130);
	c.pushStart();
	c.expectText("Ready to play");
	System.out.println("checkResetInOptions Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkStartInGame() {
		TesterAPI c = new TesterAPI("checkStartInGame","Checking the START/RESET button in the game");
	c.expectText("Ready to play");
	c.expectText("Ready to play");
	c.pushStart();
	c.expectText("White moves");
	c.pushStart();
	c.expectText("Ready to play");
	System.out.println("checkStartInGame Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkModInGame() {
		TesterAPI c = new TesterAPI("checkModInGame","Checking the MOD button in the game");
	c.expectText("Ready to play");
	c.pushStart();
	c.expectText("White moves");
	c.expectWhiteNumber(120);
	c.expectBlackNumber(120);
	c.clockForward(3000);
	c.pushMod();
	c.expectText("Game over");
	c.expectWhiteNumber(117);
	c.expectBlackNumber(120);
	c.pushBlack();
	c.expectBeep(false);
	c.pushWhite();
	c.expectBeep(false);
	c.pushMod();
	c.expectText("Game over");
	c.expectWhiteNumber(117);
	c.expectBlackNumber(120);
	c.pushStart();
	c.expectText("Ready to play");
	System.out.println("checkModInGame Succeeded!");
	}
	
	@Test(timeout=10000)
	public void checkLastSeconds() {
		TesterAPI c = new TesterAPI("checkLastSeconds","Checking the last seconds of a game button in the game.  First, each moves after 10 sec, the the White player waits until the end of the game.");
	c.expectText("Ready to play");
	c.pushStart();
	c.expectText("White moves");
	c.expectWhiteNumber(120);
	c.expectBlackNumber(120);
	c.clockForward(10000);
	c.expectText("White moves");
	c.expectWhiteNumber(110);
	c.expectBlackNumber(120);
	c.pushWhite();
	c.expectText("Black moves");
	c.expectWhiteNumber(120);
	c.expectBlackNumber(120);
	c.clockForward(10000);
	c.expectText("Black moves");
	c.expectWhiteNumber(120);
	c.expectBlackNumber(110);
	c.pushBlack();
	c.expectText("White moves");
	c.expectWhiteNumber(120);
	c.expectBlackNumber(120);
	c.clockForward(114000);
	c.expectText("White moves");
	c.expectWhiteNumber(6);
	c.expectBlackNumber(120);
	c.clockForward(1000);
	c.expectBeep(false);
	c.expectText("White moves");
	c.expectWhiteNumber(5);
	c.expectBlackNumber(120);
	c.clockForward(1000);
	c.expectBeep(false);
	c.expectText("White moves");
	c.expectWhiteNumber(4);
	c.expectBlackNumber(120);
	c.clockForward(1000);
	c.expectBeep(false);
	c.expectText("White moves");
	c.expectWhiteNumber(3);
	c.expectBlackNumber(120);
	c.clockForward(1000);
	c.expectBeep(false);
	c.expectText("White moves");
	c.expectWhiteNumber(2);
	c.expectBlackNumber(120);
	c.clockForward(1000);
	c.expectBeep(false);
	c.expectText("White moves");
	c.expectWhiteNumber(1);
	c.expectBlackNumber(120);
	c.clockForward(1000);
	c.expectBeep(true);
	c.expectText("White flag fallen");
	c.expectWhiteNumber(0);
	c.expectBlackNumber(120);
	c.pushBlack();
	c.pushWhite();
	c.pushMod();
	c.expectText("White flag fallen");
	c.expectWhiteNumber(0);
	c.expectBlackNumber(120);
	c.pushStart();
	c.expectText("Ready to play");
	System.out.println("checkLastSeconds Succeeded!");
	}
	
}
