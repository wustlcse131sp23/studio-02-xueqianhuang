package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int startAmount;
		double winChance;
		int winLimit;
		int totalSimulations;
		System.out.println("What is your start amount?");
		startAmount = in.nextInt();
		System.out.println("What is your win rate?");
		winChance = in.nextDouble();
		System.out.println("What is your win limit?");
		winLimit = in.nextInt();
		System.out.println("How many times you went to casino?");
		totalSimulations = in.nextInt();
		double expectedRuin;
		
		int winDay = 0;
		int ruinDay = 0;
		
		for (int i = 1; i <= totalSimulations; i++)
		{
			int times = 0;
			int everyStartAmount = startAmount;
			while(everyStartAmount > 0 && everyStartAmount < winLimit)
			{
				times ++; 
				double a = Math.random();
				if (a <= winChance)
				{
					everyStartAmount ++;
				}
				else
					everyStartAmount --;
			}
			System.out.print("Simulation " + i + ": " + times + " " );
				if (everyStartAmount >= winLimit)
				{
					System.out.println("WIN");	
					winDay ++;
				}
				else
				{
					System.out.println("LOSE");		
					ruinDay ++;
				}
				
		}
		  double ruinRate = (double) ruinDay / totalSimulations;
		  System.out.println("Ruin rate from Simulation:  " + ruinRate + " ");
		  if (winChance == 0.5)
		  {
			expectedRuin = (1 - startAmount / winLimit);
			System.out.println("The expected ruin is " + expectedRuin + " .");
		  }
		  else 
		  {
			double alpha = (1 - winChance) / winChance;
			expectedRuin = (Math.pow(alpha,startAmount) - Math.pow(alpha,winLimit)) / (1 - Math.pow(alpha,winLimit));
			System.out.println("Expected Ruin Rate: " + expectedRuin);
		  }
		 
		
	}

}
