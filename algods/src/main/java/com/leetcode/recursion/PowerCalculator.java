package com.leetcode.recursion;
/** TODO Anki
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
import static org.junit.Assert.assertEquals;
public class PowerCalculator {
	/* Iterative version of Faster Power: O(logN) O(1) */
	public double myPow(double x, int n) {
        if(x == 1 || n==0) return 1;
        long N=n;
        if(N <0 ) {x=1/x; N=-N;}
        double result=1, current=x;
        for(long i=N; i > 0; i/=2){// can't go from 1 to N as it will not reach the odd numbers
            if(i%2 !=0) result*=current;
            current*=current;
        }
        return result;
	}
	/* Faster: O(logN) O(logN)
	 * pow(x,3) => x*pow(x*x, 3/2)
	 * pow(x,4) =>   pow(x*x, 4/2) */
//	public double myPow(double x, int n) {
//		if(x == 1 || n== 0) return 1;
//		long N=n;
//		if(N <0 ) {x=1/x; N=-N;}
//		return power(x,N);
//	}
//	private double power(double x, long n) {
//		if(x == 1 || n==0) return 1;
//		if(n%2 == 0) return power(x*x,n/2);
//		else return x*power(x*x,n/2);
//	}
	/* Iterative: O(n) O(1)*/
//	public double myPow(double x, int n) {
//		if(x == 1 || n==0) return 1;
//		long N=n;
//		if(N <0 ) {x= 1/x; N=-N;}// need a long N to assign -N. if we reverse the sign, Integer.MIN_VALUE is bigger than MAX_VALUE
//		double result=1;
//		for(long i=0; i< N; i++) result*=x;
//		return result;
//	}
	/* Recursion: stack overflow :D */
//	public double myPow(double x, int n) {
//		if(x == 1 || n==0) return 1;
//		if(n <0 ) {x= 1/x; n=-n;}
//		return x*myPow(x,n-1);
//	}
	/* Approach 01: somehow O(n) O(n)*/
//	public double myPow(double x, int n) {
////		System.out.println(x+" ^ "+n);
//		double result = 1.00000;
//		boolean negative = false;
//		
//		if(n <0) {
//			negative = true;
//			n= -n;
//		}
//		
//		result=power(x,n);
//		if(negative) {
//			result = 1/result;
//		}
//		return result;
//    }
//	
//	private double power(double a, int n) {
////		System.out.println(a+" ^ "+n);
//		if(n ==0 || a==1) return 1;// a^0 = 1, 1^n = 1
//		double x=power(a,n/2);
//		
//		if(n%2 == 0) return x*x;
//		else return a*x*x;
//	}
	public static void main(String[] args) {
		assertEquals(1024.0,(new PowerCalculator().myPow(2.00000, 10)),0.1);//1024
		assertEquals(9.261,(new PowerCalculator().myPow(2.10000, 3)),0.1);//9.26100
		assertEquals(0.25,(new PowerCalculator().myPow(2.00000, -2)),0.1);//0.25000
		assertEquals(8.0,(new PowerCalculator().myPow(2.00000, 3)),0.1);//8.0000
		assertEquals(0.0,(new PowerCalculator().myPow(1.0E-5, 2147483647)),0.1);//0.00000
		assertEquals(0.0,(new PowerCalculator().myPow(2.00000, -2147483648)),0.1);//0.00000
		assertEquals(1.0,(new PowerCalculator().myPow(1.00000, -2147483648)),0.1);//1.00000
		assertEquals(1.0,(new PowerCalculator().myPow(-1.00000, -2147483648)),0.1);//1.00000
		assertEquals(0.0,(new PowerCalculator().myPow(2.00000, -2147483648)),0.1);//0.00000
	}

}
