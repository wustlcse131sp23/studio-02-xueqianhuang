package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        double times1=0;
        double times2=0;
        for (int simulations=1; simulations<=20; simulations++) {
        	for (int i=0; i<=100000; i++) {
                double x=Math.random();
                double y=Math.random();
                if ((x*x+y*y)<=1)
                {
            	    times1++;
                }
                else
                {
            	    times2++;
                }
            }
            double pi=((times1/(times1+times2))*4);
            System.out.println("simulation: "+simulations+"; pi = "+pi);
        }    
	}
}