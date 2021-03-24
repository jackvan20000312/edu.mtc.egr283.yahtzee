package edu.mtc.egr283.yahtzee;

public class Cup {

	private Die[] dieArray;
	public static final int DEFAULT_NUMBER_OF_DIE = 5;
	
	public Cup() {
		this(Cup.DEFAULT_NUMBER_OF_DIE, Die.DEFAULT_NUMBER_OF_SIDES);
	}// Ending bracket of default constructor
	
	public Cup(int newNumberOfDie, int newNumberOfSides) {
		this.dieArray = new Die[newNumberOfDie];
		for(int i = 0; i < this.dieArray.length; ++i) {
			this.dieArray[i] = new Die(newNumberOfSides);
		}// Ending bracket of for
	}// Ending bracket of constructor
	
	public void shakeAndRollTheDice(boolean[] whichDiceToRoll) {
		for(int i = 0; i < this.dieArray.length; ++i) {
			if(whichDiceToRoll[i]) {
				this.dieArray[i].roll();
			}// Ending bracket of if
		}// Ending bracket of for loop
	}// Ending bracket of method shakeAndRollTheDice
	
	public int[] getDieArrayValues() {
		int[] rv = new int[this.dieArray.length];
		for(int i = 0; i < this.dieArray.length; ++i) {
			rv[i] = (this.dieArray[i]).getValue();
		}// Ending bracket of for loop
		return rv;
	}// Ending bracket of method getDieArrayvalues

}// Ending bracket of class Cup


