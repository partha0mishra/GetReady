package com.leetcode.recursion;
/*** TODO Anki
 * 1414 Find the Minimum Number of Fibonacci Numbers Whose Sum Is K
 * 
 * Given the number k, return the minimum number of Fibonacci numbers whose sum is equal to k,
 * whether a Fibonacci number could be used multiple times.

The Fibonacci numbers are defined as:

F1 = 1
F2 = 1
Fn = Fn-1 + Fn-2 , for n > 2.
It is guaranteed that for the given constraints we can always find such fibonacci numbers that sum k.
 

Example 1:

Input: k = 7
Output: 2 
Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ... 
For k = 7 we can use 2 + 5 = 7.
Example 2:

Input: k = 10
Output: 2 
Explanation: For k = 10 we can use 2 + 8 = 10.
Example 3:

Input: k = 19
Output: 3 
Explanation: For k = 19 we can use 1 + 5 + 13 = 19.
 

Constraints:

1 <= k <= 10^9
 */
import java.util.TreeSet;
import static org.junit.Assert.assertEquals;
public class FibNumsSumK {
	/* Approach 02: No extra space. 
	 * Go once up for generation and then come back 
	 * O(logK) O(1)*/
	public int findMinFibonacciNumbers(int k) {
		int a=1, b=1, result=0,tmp;
		while(b <=k) {
			tmp=b; b+=a; a=tmp;
		}// b and a are the last 2 fib numbers. we can now generate the sequence back.
		while(a> 0) {
			if(a <=k) {
				k-=a;
				result+=1;
			}
			// generate the prev number of b-> a-> ?
			tmp=a;a=b-a;b=tmp;
		}
		return result;
    }
	/* GREEDY Solution */
/*
	public int findMinFibonacciNumbers(int k) {
		if(k<2) return k;
        TreeSet<Integer> ts= new TreeSet<Integer>();
        int a=0,b=1,tmp,result=0;
        while(b<k) {// generating FIB numbers
        	tmp=b;
        	b+=a;
        	a=tmp;
        	ts.add(b);
//        	System.out.println(b);
        }
        while(k>0) {
        	k-=ts.floor(k);// NOTE
        	result++;
        }
        return result;
    }
*/
	public static void main(String[] args) {
		FibNumsSumK instance= new FibNumsSumK();
		assertEquals(2,instance.findMinFibonacciNumbers(7));
		assertEquals(2,instance.findMinFibonacciNumbers(10));
		assertEquals(3,instance.findMinFibonacciNumbers(19));
		assertEquals(13,instance.findMinFibonacciNumbers(100000000));
		assertEquals(1,instance.findMinFibonacciNumbers(1));
	}

}
