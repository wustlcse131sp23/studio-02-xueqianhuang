package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	

	System.out.println("How many times do you want to throw?");
	int throwTimes = in.nextInt();
	double timesIn = 0;
	double timesOut = 0;
	for (int i = 0; i <= throwTimes;i++)
	{

		double x = Math.random();
		double y = Math.random();
		double sum = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
		if (sum <= 1)
		{
			timesIn++;
		}
		else
		{
			timesOut++;
		}
	}
	double Pi = (double) 4 * (timesIn / throwTimes);
	System.out.println("The Pi is " + Pi + " .");
	
	}

}
