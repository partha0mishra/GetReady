package com.algods.leetcode.math;
/* 1009 Complement of Base 10 Integer
Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 
11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.

The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  
For example, the complement of "101" in binary is "010" in binary.

For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.

Example 1:

Input: 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
Example 2:

Input: 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
Example 3:

Input: 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 

Note:

0 <= N < 10^9
This question is the same as 476: https://leetcode.com/problems/number-complement/
 * */
public class ComplementOfBase10 {
	/* According to the problem, the result is

The flipped version of the original input but
Only flip N bits within the range from LEFTMOST bit of 1 to RIGHTMOST.
For example input = 5 (the binary representation is 101), the LEFTMOST bit of 1 is the third one from RIGHTMOST (100, N = 3). 
Then we need to flip 3 bits from RIGHTMOST and the answer is 010
To achieve above algorithm, we need to do 3 steps:

Create a bit mask which has N bits of 1 from RIGHTMOST. 
In above example, the mask is 111. And we can use the decent Java built-in function Integer.highestOneBit to get the LEFTMOST bit of 1, 
left shift one, and then minus one. Please remember this wonderful trick to create bit masks with N ones at RIGHTMOST, 
you will be able to use it later.
Negate the whole input number.
Bit AND numbers in step 1 and 2.
	 * */
	public int bitwiseComplement(int N) {
		if(N ==0) return 1;// corner case
		return ~N & ((Integer.highestOneBit(N) << 1) - 1);
    }
}
