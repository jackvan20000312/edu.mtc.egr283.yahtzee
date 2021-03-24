package edu.mtc.egr283.yahtzee;

import java.util.Scanner;

public class YahtzeeDriver {
	
	private static Scanner keyboard;
	private static Player[] player;
	private static Cup cup;
	
	public static void main(String[] args) {
		
		keyboard = new Scanner(System.in);
		cup = new Cup();
		
		System.out.print("Enter number of players: ");
		player = new Player[keyboard.nextInt()];
		for(int i = 0; i < player.length; ++i) {
			System.out.print("Enter name of player #" + (i+1) + ": ");
			player[i] = new Player(keyboard.next());
			
		}// Ending bracket of for loop

		int roll;
		boolean[] whichDiceToRoll = new boolean[5];
		char rerollAnswer;
		int whichDieToReroll = 0;
		int temp = 0;
		String scoreChoice = "";
		for(int turn = 1; turn <= 13; ++turn) {
			for(int i = 0; i < player.length; ++i) {
				roll = 0;
				rerollAnswer = 'Y';
				for(int j = 0; j < whichDiceToRoll.length; ++j) {
					whichDiceToRoll[j] = true;
				}// Ending bracket of for loop

				System.out.println(player[i].getName() + "'s turn #" + turn + ":");
				++roll;
				YahtzeeDriver.rollTheDice(roll, whichDiceToRoll);

				// Code to handle recalling the dice
				// Time to score the player's roll
				for(String s : ScoreCard.SCORE_TYPE) {
					if(!("".equals(s))) {
						System.out.print(s + ", ");
					}// Ending bracket of if
				}// Ending bracket of for each loop
				System.out.println();
				System.out.print("Where do you want to score this? ");
				scoreChoice = keyboard.next();
				player[i].setScore(player[i].getScoreTypeIndex(scoreChoice), cup.getDieArrayValues());
				player[i].printScorecard();
				System.out.println();

			}// Ending bracket of PLAYER for loop
		}// Ending bracket of TURN for loop

		keyboard.close();
		
	}// Ending bracket of method main

	private static void rollTheDice(int roll, boolean[] whichDiceToRoll) {
		System.out.print("Roll #" + roll + " is ");
		cup.shakeAndRollTheDice(whichDiceToRoll);
		int[] rollValues = cup.getDieArrayValues();
		for(int i = 0; i < rollValues.length; ++i) {
			System.out.print(rollValues[i] + " ");
		}// Ending bracket of for loop
		System.out.println();
	}// Ending bracket of method rollTheDice
	
}// Ending bracket of class YahtzeeDriver