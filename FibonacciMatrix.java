/**
 * This class calculates the Fibonacci number for a given number. It also shows the time consumed for performing the calculation.
 * It calculates the fibonacci number by a matrix-doubling method. The algorithm can handle large number range, for instance : 10 million.
 * This algorithm calculates faster than the iterative method algorithm.
 * 
 * @author Rayyan Mohammed Jaweed
 * @version 2nd February, 2016
 */

import java.math.BigInteger;

public class FibonacciMatrix {
	
	public static void main(String args[]){
		
		int number = 10000000;
		int duplicate = number;
		
		// Base Matrix [ 0 , 1 , 1 , 1 ]
		BigInteger[] baseMatrix = {BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE};
		
		// Final Matrix, initializing with Identity Matrix [ 1 , 0 , 0 , 1 ]
		BigInteger[] finalMatrix = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE};
		
		long startTime = System.nanoTime();
		
		while (0 != number) {
			if ( (number % 2) != 0){
				finalMatrix = multiplyMatrices(finalMatrix, baseMatrix);
			}
			number /= 2;
			baseMatrix = multiplyMatrices(baseMatrix, baseMatrix);
		}
		
		long timeConsumed = System.nanoTime() -startTime;
		System.out.println("Matrix Doubling Method");
		System.out.println("Time Consumed = " + (timeConsumed/1000000) + " ms");
		System.out.println("F["+duplicate+"] = " + finalMatrix[1] );
	}

	private static BigInteger[] multiplyMatrices(BigInteger[] leftMatrix, BigInteger[] rightMatrix) {
		
		BigInteger product[]= new BigInteger[4];
		product[0] = (   leftMatrix[0].multiply(rightMatrix[0])  ).add( leftMatrix[1].multiply(rightMatrix[2])   ) ;
		product[1] = (   leftMatrix[0].multiply(rightMatrix[1])  ).add( leftMatrix[1].multiply(rightMatrix[3])   ) ;
		product[2] = (   leftMatrix[2].multiply(rightMatrix[0])  ).add( leftMatrix[3].multiply(rightMatrix[2])   ) ;
		product[3] = (   leftMatrix[2].multiply(rightMatrix[1])  ).add( leftMatrix[3].multiply(rightMatrix[3])   ) ;
		return product;
	}

}
