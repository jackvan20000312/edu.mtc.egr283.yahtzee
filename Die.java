package edu.mtc.egr283.yahtzee;

import java.util.Random;

public class Die {
	
	private int value;
	private static Random randomizer;
	private int numberOfSides;
	public static final int DEFAULT_NUMBER_OF_SIDES = 6;

	public Die() {
		this(Die.DEFAULT_NUMBER_OF_SIDES);
	}// Ending bracket of default constructor

	public Die(int newNumberOfSides) {
		this.setNumberOfSides(newNumberOfSides);
		Die.randomizer = new Random();
		this.setValue(0);
	}// Ending bracket of constructor

	public int roll() {
		this.setValue(Die.randomizer.nextInt(this.getNumberOfSides()) + 1);
		return this.getValue();
	}// Ending bracket of method roll

	public int getValue() {
		return this.value;
	}// Ending bracket of method getvalue

	public int getNumberOfSides() {
		return this.numberOfSides;
	}// Ending bracket of method getNumberOfSides

	private void setValue(int newValue) {
		this.value = newValue;
	}// Ending bracket of method setvalue

	private void setNumberOfSides(int newNumberOfSides) {
		this.numberOfSides = newNumberOfSides;
	}// Ending bracket of method setNumberOfSides

}// Ending bracket of class Die
