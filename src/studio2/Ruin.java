package studio2;

import java.util.Scanner;

public class Ruin {
	
	public static void main(String[] args) 
	{
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("startAmount:");
			int startAmount = in.nextInt();
			System.out.println("winLimit:");
			int winLimit = in.nextInt();
			System.out.println("winChance:");
			double win = in.nextDouble();
			int WinRounds = 0;
			int LoseRounds = 0;
			System.out.println("SimulationsLimit:");
			int SimulationsLimit = in.nextInt();
			double Alpha = (1-win)/win;
			double expectedRuin;
			double startAmount2 = startAmount;
			double winLimit2 = winLimit;
			if (win==0.5)
			{
				expectedRuin = 1 - (startAmount2/winLimit2);
			}
			else
			{
				expectedRuin = (Math.pow(Alpha,startAmount) - Math.pow(Alpha,winLimit))/(1 - Math.pow(Alpha,winLimit));
			}
			for (int Simulations = 1; Simulations <= SimulationsLimit; Simulations ++)
			{
				int eachstartAmount = startAmount;   
				int Rounds = 0;
				
				    while ((eachstartAmount>0)&&(eachstartAmount<winLimit))
			    {
				    double winChance = Math.random();
				    if (winChance <= win)
				    {
				    	eachstartAmount = eachstartAmount + 1;
				    }
			        else
				    {
			        	eachstartAmount = eachstartAmount - 1;
				    }
				    Rounds ++;
				    if (Rounds >= 50)
				    	break;
			    }
			        
				    if (eachstartAmount == 0)
			    {
				    LoseRounds ++;
				    System.out.println("Simulation " + Simulations + ": " + "Rounds " + Rounds + "; Lose!");
			    }
			        else if((eachstartAmount > 0)&&(eachstartAmount < winLimit))
			    {
			        System.out.println("Simulation " + Simulations + ": " + "Rounds " + Rounds + "; No lose no win.");
			    }
				    else
			    {
			        WinRounds ++;
			        System.out.println("Simulation " + Simulations + ": " + "Rounds " + Rounds + "; Win!");
			    }
				    
			}
			double LoseRounds2 = LoseRounds;
			double SimulationsLimit2 = SimulationsLimit;
			double RuinRate = LoseRounds2/SimulationsLimit2;
			System.out.println("Win Rounds: " + WinRounds + "; Lose Rounds: " + LoseRounds);
			System.out.println("Simulations: " + SimulationsLimit);
			System.out.println("Ruin Rate from Simulation: " + RuinRate + "; Expected Ruin Rate: " + expectedRuin);
		}
	}
}