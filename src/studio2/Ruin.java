package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Money you start with: ");
		double startAmount = in.nextDouble();
		System.out.println("The chance of you winning, in percent: ");
		double winChance = in.nextDouble();
		System.out.println("Your win limit: ");
		double winLimit = in.nextDouble();
		double totalSimulations = 0.0;
		double loss = 0.0;
		double win = 0.0;
		
		double money = startAmount;
		
		while (money != 0 && money != winLimit) {
			int rnd1 = (int)(Math.random()*100);
			totalSimulations = totalSimulations + 1;
			if (rnd1 < winChance) {
				money = money + 1;
				win = win + 1;
				System.out.println("Day " + totalSimulations + ": Win! You have $" + money);
			}
			else {
				money = money - 1;
				loss = loss + 1;
				System.out.println("Day " + totalSimulations + ": Loss. You have $" + money);
			}
		}
		
		if (money == 0) {
			System.out.println("You lost :(");
		}
		else {
			System.out.println("You win :)");
		}
		
		System.out.println("You won " + win + " times and lost " + loss + " times out of " + totalSimulations + " days.");
		double a = (1-winChance)/winChance;
		double ruin = loss / (loss + win);
		double exRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit));
		System.out.println("Expected ruin rate: " + exRuin);
		System.out.println("Actual ruin rate: " + loss / totalSimulations);
		
		
		

	}

}
