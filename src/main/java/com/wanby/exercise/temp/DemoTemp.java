package com.wanby.exercise.temp;

/**
 * This type use to show 
 * "Thinking in java" some simple exercises.
 * @author wanby
 * @version 1.0.00
 * Apr 9, 2017 3:06:50 PM
 */
public class DemoTemp {
	
//	private int num;
//	private char name;
	
	/**
	 * Calculate chars length.
	 * @param s The chars.
	 * @return The chars twice length.
	 */
	public int storage(String s) {
		return s.length() * 2;
	}
	
	/**
	 * Show all of vampire numbers between 1000 and 9999.
	 */
	public void showVampireNum() {
		for(int i = 1000;i <= 9999;i++) {
			int thousands = i / 1000;
			int hundreds = (i % 1000) / 100;
			int decade = (i % 100) / 10;
			int theUnit = i % 10;
			if(isVampireNume(i, doubleDigit(thousands, hundreds), doubleDigit(decade, theUnit))) {
				continue;
			}
			if(isVampireNume(i, doubleDigit(thousands, hundreds), doubleDigit(theUnit, decade))) {
				continue;
			}
			if(isVampireNume(i, doubleDigit(hundreds, thousands), doubleDigit(decade, theUnit))) {
				continue;
			}
			if(isVampireNume(i, doubleDigit(hundreds, thousands), doubleDigit(theUnit, decade))) {
				continue;
			}
			if(isVampireNume(i, doubleDigit(thousands, decade), doubleDigit(hundreds, theUnit))) {
				continue;
			}
			if(isVampireNume(i, doubleDigit(thousands, decade), doubleDigit(theUnit, hundreds))) {
				continue;
			}
			
			if(isVampireNume(i, doubleDigit(decade, thousands), doubleDigit(hundreds, theUnit))) {
				continue;
			}
			if(isVampireNume(i, doubleDigit(decade, thousands), doubleDigit(theUnit, hundreds))) {
				continue;
			}
			if(isVampireNume(i, doubleDigit(thousands, theUnit), doubleDigit(hundreds, decade))) {
				continue;
			}
			if(isVampireNume(i, doubleDigit(thousands, theUnit), doubleDigit(decade, hundreds))) {
				continue;
			}
			if(isVampireNume(i, doubleDigit(theUnit, thousands), doubleDigit(hundreds, decade))) {
				continue;
			}
			isVampireNume(i, doubleDigit(theUnit, thousands), doubleDigit(decade, hundreds));
		}
	}
	
	/**
	 * Calculate to double digit
	 * @param decade the decade
	 * @param theUnit the unit
	 * @return double digit
	 */
	public int doubleDigit(int decade, int theUnit) {
		if(0 == decade) {
			return 0;
		} else {
			return decade * 10 + theUnit;
		}
	}
	
	/**
	 * Judge result is num1 * num2.
	 * @param result product
	 * @param num1 double digit one
	 * @param num2 double digit two
	 * @return true or false
	 */
	public boolean isVampireNume(int result, int num1, int num2) {
		if(result == num1 * num2) {
			System.out.println("Vampire num is " + result + " = " + num1 + " * " + num2);
			return true;
		}
		return false;
	}

	/**
	 * This method use to run the programmer.
	 * @param args Some commands
	 */
	public static void main(String[] args) {
		DemoTemp dTemp = new DemoTemp();
//		System.out.println("Int default value is : " + dTemp.num);
//		System.out.println("Char default value is : " + dTemp.name);
//		System.out.println(dTemp.storage(args[0]));
		dTemp.showVampireNum();
	}

}
