package com.leetcode.backtracking;
/** Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with '0'. We cannot ignore a zero when we face it while decoding. So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.
Example 4:

Input: s = "1"
Output: 1
 

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
 */
import static org.junit.Assert.assertEquals;
public class DecodeWays {
	/**
	 * DP - start from the beginning, need to check 1 chars or 2 chars
	 *  FOR ANOTHER DAY
	 */
	public int numDecodings(String s) {
		int[] dp= new int[s.length()+1];
        for(int i=0; i< s.length(); i++) {
        	
        }
        return dp[s.length()];
    }
	/**
	 * Backtracking with pruning
	 * O(N) O(N) 
	 */
//	public int numDecodings(String s) {
//		int[] dp= new int[s.length()+1];
//        return backtrack(s,0,dp);
//    }
//	private int backtrack(String s, int index, int[] dp) {
//		if(index > s.length()) return 0;
//		if(index == s.length()) {dp[index]=1; return dp[index];}
//		if(dp[index] != 0) return dp[index];
//		for(int i=1; i<=2; i++) {
//			if(index+i > s.length()) break;// i=1 is okay but i=2 is not
//			String sub=s.substring(index,index+i);
//			int num=0;
//			for(int j=0; j<sub.length();j++) {
//				num=10*num+Integer.valueOf(sub.charAt(j) - '0');
//				if(num ==0) break;
//			}
//			if(num < 1 || num > 26) continue;// prune
//			dp[index]+=backtrack(s,index+i,dp);
//		}
//		return dp[index];
//	}
	public static void main(String[] args) {
		DecodeWays dw= new DecodeWays();
		assertEquals(2,(dw.numDecodings("12")));
		assertEquals(3,(dw.numDecodings("226")));
		assertEquals(0,(dw.numDecodings("0")));
		assertEquals(1,(dw.numDecodings("1")));
		assertEquals(0,(dw.numDecodings("01")));
		assertEquals(1,(dw.numDecodings("10")));
		assertEquals(0,(dw.numDecodings("10230234056")));// "30" causes 0
		assertEquals(2,(dw.numDecodings("10210232056")));
	}

}
