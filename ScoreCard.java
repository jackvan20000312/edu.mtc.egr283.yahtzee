package edu.mtc.egr283.yahtzee;

import java.util.Arrays;

public class ScoreCard {
	// +------------+-----+-+---------------+-----+
	// |            |Score| |               |Score|
	// +------------+-----+-+---------------+-----+
	// | Ones       |  0  | | 3 of a Kind   |  9  |
	// +------------+-----+-+---------------+-----+
	// | Twos       |  1  | | 4 of a Kind   | 10  |
	// +------------+-----+-+---------------+-----+
	// | Threes     |  2  | | Full House    | 11  |
	// +------------+-----+-+---------------+-----+
	// | Fours      |  3  | | Low Straight  | 12  |
	// +------------+-----+-+---------------+-----+
	// | Fives      |  4  | | High Straight | 13  |
	// +------------+-----+-+---------------+-----+
	// | Sixes      |  5  | | Yahtzee       | 14  |
	// +------------+-----+-+---------------+-----+
	// | Subtotal   |  6  | | Chance        | 15  |
	// +------------+-----+-+---------------+-----+
	// | Bonus      |  7  | | SubTotal 2    | 16  |
	// +------------+-----+-+---------------+-----+
	// | SubTotal 1 |  8  | | SubTotal 1    |  8  |
	// +------------+-----+-+---------------+-----+
	// |            |     | | Grand Total   | 17  |
	// +------------+-----+-+---------------+-----+

	private int[] scoreArray; 
	private static final int STANDARD = 18;
	public static final String[] SCORE_TYPE = {  "1S", "2S", "3S", "4S", "5S", "6S", "", "", "", "3K", "4K", "FH", "LS", "HS", "YZ", "CH"};

	public ScoreCard() {
		this.scoreArray = new int[ScoreCard.STANDARD];
		for(int i = 6; i < this.scoreArray.length; ++i) {
			this.scoreArray[i] = 0;
		}// Ending bracket of for loop
	}// Ending bracket of constructor

	public int getScore(int indexOfWhichScoreToGet) {
		return this.scoreArray[indexOfWhichScoreToGet];
	}// Ending bracket of method getScore

	public String getScoreType(int indexOfWhichScoreTypeToGet) {
		return ScoreCard.SCORE_TYPE[indexOfWhichScoreTypeToGet];
	}// Ending bracket of method getScoreType

	public int getScoreTypeIndex(String scoreType) {
		int rv = -1;
		for(int i = 0; i < ScoreCard.SCORE_TYPE.length; ++i) {
			if(ScoreCard.SCORE_TYPE[i].equalsIgnoreCase(scoreType)) {
				rv = i;
				break;
			}// Ending bracket of if
		}// Ending bracket of for loop
		return rv;
	}// Ending bracket of method getScoreTypeIndex

	public void setScore(int indexOfWhichScoreToSet, int[] diceValues) {
		switch(indexOfWhichScoreToSet) {
		case 0:
			this.scoreArray[0] = this.calculateOnes(diceValues);
			break;
		case 1:
			this.scoreArray[1] = this.calculateTwos(diceValues);
			break;
		case 2:
			this.scoreArray[2] = this.calculateThrees(diceValues);
			break;
		case 3:
			this.scoreArray[3] = this.calculateFours(diceValues);
			break;
		case 4:
			this.scoreArray[4] = this.calculateFives(diceValues);
			break;
		case 5:
			this.scoreArray[5] = this.calculateSixes(diceValues);
			break;
		case 9:
			this.scoreArray[9] = this.calculate3OfAKind(diceValues);
			break;
		case 10:
			this.scoreArray[10] = this.calculate4OfAKind(diceValues);
			break;
		case 11:
			this.scoreArray[11] = this.calculateFullHouse(diceValues);
			break;
		case 12:
			this.scoreArray[12] = this.calculateLowStraight(diceValues);
			break;
		case 13:
			this.scoreArray[13] = this.calculateHighStraight(diceValues);
			break;
		case 14:
			this.scoreArray[14] = this.calculateYahtzee(diceValues);
			break;
		case 15:
			this.scoreArray[15] = this.calculateChance(diceValues);
			break;
		default:
			// What should we do?
		}// Ending bracket of switch
	}// Ending bracket of method setScore

	public int totalTheScores() {
		this.scoreArray[6] = this.calculateSubtotal();
		this.scoreArray[7] = this.calculateTheBonus();
		this.scoreArray[8] = this.calculateSubtotal1();
		this.scoreArray[16] = this.calculateSubtotal2();
		this.scoreArray[17] = this.calculateGrandTotal();
		return this.scoreArray[17];
	}// Ending bracket of method totalTheScores

	public void printScorecard() {
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("| \t\t|Score  | |               |Score|");
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("| Ones\t\t| " + this.getScore(0) + "\t| | 3 of a Kind\t  | " + this.getScore(9) + "\t|");
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("| Twos\t\t| " + this.getScore(1) + "\t| | 4 of a Kind\t  | " + this.getScore(10) + "\t|");
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("| Threes\t| " + this.getScore(2) + "\t| | Full House\t  | " + this.getScore(11) + "\t|");
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("| Fours\t\t| " + this.getScore(3) + "\t| | Low Straight  | " + this.getScore(12) + "\t|");
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("| Fives\t\t| " + this.getScore(4) + "\t| | High Straight | " + this.getScore(13) + "\t|");
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("| Sixes\t\t| " + this.getScore(5) + "\t| | Yahtzee\t  | " + this.getScore(14) + "\t|");
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("| Subtotal\t| " + this.getScore(6) + "\t| | Chance\t  | " + this.getScore(15) + "\t|");
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("| Bonus\t\t| " + this.getScore(7) + "\t| | SubTotal 2\t  | " + this.getScore(16) + "\t|");
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("| SubTotal 1\t| " + this.getScore(8) + "\t| | SubTotal 1\t  | " + this.getScore(8) + "\t|");
		System.out.println("+---------------+-------+-+---------------+-----+");
		System.out.println("|\t\t|\t| | Grand Total\t  | " + this.getScore(17) + "\t|");
		System.out.println("+---------------+-------+-+---------------+-----+");
	}// Ending bracket of method printScorecard


	// Ones - total of all ones rolled
	private int calculateOnes(int[] diceValues) {
		int rv = 0;
		for(int i = 0; i < diceValues.length; ++i) {
			if(diceValues[i] == 1) {
				rv += 1;
			}// Ending bracket of if
		}// Ending bracket of for
		return rv;
	}// Ending bracket of method calculateOnes

	// Twos - total of all twos rolled
	private int calculateTwos(int[] diceValues) {
		int rv = 0;
		for(int i = 0; i < diceValues.length; ++i) {
			if(diceValues[i] ==2) {
				rv += 2; 
			}// Ending bracket of if
		}// Ending bracket of for
		return rv;
	}// Ending bracket of method calculateTwos

	// Threes - total of all threes rolled
	private int calculateThrees(int[] diceValues) {
		int rv = 0;
		for(int i = 0; i < diceValues.length; ++i) {
			if(diceValues[i] == 3) {
				rv += 3;
			}// Ending bracket of if
		}// Ending bracket of for
		return rv;
	}// Ending bracket of method calculateThrees

	// Fours - total of all fours rolled
	private int calculateFours(int[] diceValues) {
		int rv = 0;
		for(int i = 0; i < diceValues.length; ++i) {
			if(diceValues[i] == 4) {
				rv += 4;
			}// Ending bracket of if
		}// Ending bracket of for
		return rv;
	}// Ending bracket of method calculateFours
	// Fives - total of all fives rolled
	private int calculateFives(int[] diceValues) {
		int rv = 0;
		for(int i = 0; i < diceValues.length; ++i) {
			if(diceValues [i] == 5) {
				rv += 5;
			}// Ending bracket of if
		}// Ending bracket of for
		return rv;
	}// Ending bracket of method calculateFives
	// Sixes - total of all sixes rolled
	private int calculateSixes(int[] diceValues) {
		int rv = 0;
		for(int i = 0; i < diceValues.length; ++i) {
			if(diceValues [i] == 6) {
				rv += 6;
			}// Ending bracket of if
		}// Ending bracket of for
		return rv;
	}// Ending bracket of method calculateSixes

	private int calculate3OfAKind(int[] diceValues) {

		int rv = 0;

		Arrays.sort(diceValues);
		if((diceValues[0] == diceValues[2]) || (diceValues[1] == diceValues[3]) || (diceValues[2] == diceValues[4])) {
			rv = totalOfAllDice(diceValues);
		}// Ending bracket of if

		return rv;
	}// Ending bracket of method calculate3OfAKind

	// 4 of a Kind - total of all dice rolled or 0
	private int calculate4OfAKind(int[] diceValues) {
		int rv = 0;

		Arrays.sort(diceValues);
		if((diceValues[0] == diceValues[3]) || (diceValues[1] == diceValues[4])) {
			rv = totalOfAllDice(diceValues);
		}// Ending bracket of if
		return rv;
	}// Ending bracket of method calculate30fAKind

	// Full House - 3 of a Kind and a pair - 25 points or 0
	private int calculateFullHouse(int[] diceValues) {
		int rv = 0;

		Arrays.sort(diceValues);
		if((diceValues[0] == diceValues[2] && diceValues[3] == diceValues[4]) ||
				(diceValues[2] == diceValues[4] && diceValues[0] == diceValues[1])) {
			if(diceValues[0] != diceValues[4]) {
				rv = 25;
			}// Ending bracket of NESTED if
		}// Ending bracket of if
		return rv;
	}// Ending bracket of method calculateFullHouse

	// Low Straight - 4 in a row - 30 points or 0
	private int calculateLowStraight(int[]diceValues) {
		int rv = 0;
		int count = 0;
		Arrays.sort(diceValues);
		for(int i = 0; i < diceValues.length - 1; ++i) {
			if(diceValues[i] + 1 == diceValues[i + 1]) {
				++count;
			} else if(diceValues[i] == diceValues[i + 1]) {
				continue;
			} else {
				if(count >= 3) {
					break;
				}// Ending bracket of nested if
				count = 0;
			}// Ending bracket of if
		}// Ending bracket of for loop
		if(count >= 3) {
			rv = 30;
		}// Ending bracket of if
		return rv;
	}// Ending bracket of method calculateLowStraight

	// High Straight - 5 in a row - 40 points or 0
	private int calculateHighStraight(int [] diceValues) {
		int rv = 0;
		Arrays.sort(diceValues);
		if(diceValues[0] + 1 == diceValues[1] &&
				diceValues[1] + 1 == diceValues[2] &&
				diceValues[2] + 1 == diceValues[3] &&
				diceValues[3] + 1 == diceValues[4]) {
			rv = 40;
		}// Ending bracket of if
		return rv;
	}// Ending bracket of method calculateHighStraight

	//Yahtzee - 5 of a Kind - 50 points or 0
	private int calculateYahtzee(int[] diceValues) {
		int rv = 0;

		Arrays.sort(diceValues);
		if(diceValues[0] == diceValues[4]) {
			rv = 50;
		}// Ending bracket of if

		return rv;
	}// Ending bracket of method calculateYahtzee

	//Chance - total of all dice rolled

	private int calculateChance(int[] diceValues) {
		return totalOfAllDice(diceValues);
	}// Ending bracket of method calculateChance

	private int calculateSubtotal() {
		int rv = 0;
		for(int i = 0; i <= 5; ++i) {
			rv += this.scoreArray[i];
		}// Ending bracket of for
		return rv;
	}// Ending bracket of method calculateSubtotal

	private int calculateTheBonus() {
		int rv = 0;
		if(this.calculateSubtotal() >= 63) {
			rv = 35;
		}// Ending bracket of if
		return rv;
	}// Ending bracket of method calculateTheBonus

	private int calculateSubtotal1() {
		return this.scoreArray[6] + this.scoreArray[7];
	}// Ending bracket of method calculateSubtotall

	private int calculateSubtotal2() {
		int rv = 0;
		for(int i = 9; i <= 15; ++i) {
			rv += this.scoreArray[i];
		}// Ending bracket of for loop
		return rv;
	}// Ending bracket of method calculateSubtotalZ

	private int calculateGrandTotal() {
		return this.scoreArray[8] + this.scoreArray[16];
	}// Ending bracket of method calculateGrandTotal

	private int totalOfAllDice(int[] diceValues) {
		int rv = 0;
		for(int i = 0; i < diceValues.length; ++i) {
			rv += diceValues[i];
		}// Ending bracket of for loop|
		return rv;
	}// Ending bracket of method totalOfAllDice





}// Ending bracket of class Scorecard
