package edu.mtc.egr283.yahtzee;

public class Player {
	
	private String name;
	private ScoreCard scorecard;
	
	public Player(String newName) {
		this.setName(newName);
		this.scorecard = new ScoreCard();
	}// Ending bracket of constructor
	
	public String getName() {
		return this.name;
	}// Ending bracket of method getName
	
	private void setName(String newName) {
		this.name = newName;
	}// Ending bracket of method setName
	
	public int getScoreTypeIndex(String scoreType) {
		return this.scorecard.getScoreTypeIndex(scoreType);
	}// Ending bracket of method getScoreTypeIndex
	
	public void setScore(int indexOfWhichScoreToSet, int[] diceValues) {
		this.scorecard.setScore(indexOfWhichScoreToSet, diceValues);
	}// Ending bracket of method setScore
	
	public int calculateScores() {
		return this.scorecard.totalTheScores();
	}// Ending bracket of method calculateScores
	
	public void printScorecard() {
		this.scorecard.printScorecard();
	}// Ending bracket of method printScorecard
	
}// Ending bracket of class Player
