package com.leetcode._explore;
/* 902. Numbers at most N Digit Set
 * 
 * Given an array of digits, you can write numbers using each digits[i] as many times as we want.  For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.

Return the number of positive integers that can be generated that are less than or equal to a given integer n.

 

Example 1:

Input: digits = ["1","3","5","7"], n = 100
Output: 20
Explanation: 
The 20 numbers that can be written are:
1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
Example 2:

Input: digits = ["1","4","9"], n = 1000000000
Output: 29523
Explanation: 
We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
In total, this is 29523 integers that can be written using the digits array.
Example 3:

Input: digits = ["7"], n = 8
Output: 1
 

Constraints:

1 <= digits.length <= 9
digits[i].length == 1
digits[i] is a digit from '1' to '9'.
All the values in digits are unique.
1 <= n <= 109
 */
public class NumbersAtMostNDigitSet {
	 public int atMostNGivenDigitSet(String[] D, int N) {
	        int digitCount = 0, copy = N;
	        String number = "";
	        while(copy > 0){
	            number = (copy % 10) + number;
	            copy = copy/10;
	            digitCount++;
	        }
	        int result = 0;
		// Calculate the combo that is shorter than N 
	        for(int i = 0; i < digitCount - 1; i++) result += Math.pow(D.length, i+1);
					
		// Convert the string array to char array			
	        char[] choice = new char[D.length];
	        for(int i = 0; i < D.length; i++) choice[i] = D[i].toCharArray()[0];
	        
		// The choice array is sorted, we only want to go up to the number that is the same as target numbers corresponding digit
	        for (int i = 0; i < choice.length && choice[i] <= number.charAt(0); i++){
	            if (choice[i] == number.charAt(0)){
	                result += helper(choice, number, N, digitCount, i, "");                    
	            }else{
			//If the current digit(most significant) is less than target's first digit already, any digit can come after
	                result += Math.pow(D.length, number.length() - 1);
	            }
	        }
	        return result;
	    }
	    
	    private int helper(char[] choice, String number, int N, int digitCount, int index, String cur){
	        cur += choice[index];
	        if (cur.length() == digitCount){
	            return 1;
	        }
	        int result = 0;
	        for (int i = 0 ; i < choice.length && choice[i] <= number.charAt(cur.length()); i++){
	            
	            if (choice[i] == number.charAt(cur.length())){
	                result += helper(choice, number, N, digitCount, i, new String(cur));
	            }else{
	                // If the current digit is less than the target number's current digit, the subsequent digit can be any number in the choice 
	                result += Math.pow(choice.length, number.length() - cur.length() - 1);
	            }            
	        }
	        return result;
	    }
}
