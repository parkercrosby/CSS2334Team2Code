package classCS;
import java.math.BigInteger;
import java.util.*;

public class PresentationFactorial {
	public static BigInteger factorialRecursive(BigInteger n) {

		BigInteger sum = BigInteger.ZERO;
		if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		else {
			sum = n.multiply(factorialRecursive(n.subtract(BigInteger.ONE)));
		}
		return sum;
		
	}
	
	public static BigInteger factorialIterative(BigInteger n) {
		
		BigInteger sum = BigInteger.ONE;
		
		for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
			sum = sum.multiply(i);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		long n = System.nanoTime();
		System.out.println(n);
		//System.out.println(factorialIterative(BigInteger.valueOf(100000)));
		System.out.println(factorialRecursive(BigInteger.valueOf(100000)));
		long m = System.nanoTime();
		System.out.println(m);
		System.out.println(m - n);
		
	}
}
