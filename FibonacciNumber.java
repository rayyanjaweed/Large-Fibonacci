/**
 * This class calculates the Fibonacci number for a given number. It also shows the time consumed for performing the calculation.
 * It calculates the fibonacci number by an iterative method. The algorithm can handle large number range, for instance : 10 million.
 * 
 * @author Rayyan Mohammed Jaweed
 * @version 2nd February, 2016
 */

import java.math.BigInteger;

public class FibonacciNumber {

	public static void main(String[] args) {
		int number = 10000000;
		
		BigInteger previous = new BigInteger("0");
		BigInteger present = new BigInteger("1");
		BigInteger next = new BigInteger("0");
		
		long startTime = System.nanoTime();
		
		for( int iterator = 2; iterator <= number ; iterator++){
			
			next = previous.add(present);
			previous = present;
			present = next;
		}
		
		long timeConsumed = System.nanoTime()-startTime;
		System.out.println("Iterative Method");
		System.out.println("Time Consumed = " + (timeConsumed/1000000) + " ms");
		System.out.println("F["+number+"] = " + next );
		
	}

}
