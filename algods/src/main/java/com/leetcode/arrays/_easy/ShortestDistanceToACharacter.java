package com.leetcode.arrays._easy;
/**
 * 821. Shortest Distance to a Character
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.
Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
 

Constraints:

1 <= s.length <= 104
s[i] and c are lowercase English letters.
c occurs at least once in s.
 */
import java.util.*;
public class ShortestDistanceToACharacter {
	/**
	 * Easy: could have just done Array Scan.
	 * Go from left to right and populate distance using i-prev where prev= index of 'c'
	 * Then go from right to left and populate distance using next-i where next=index of 'c' 
	 * and when this is a lower value than previous distance.
	 * 
	 * The first approach below is keeping the instances of 'c' in a queue 
	 * and then referring to those while going from left to right.
	 * Takes a little more memory for the queue.
	 * 
	 * Complexity of both solutions would be O(N)/ O(N)
	 * *** The first solution seems to be equivalent/ better :D
	 */
//	public int[] shortestToChar(String S, char C) {
//        int N = S.length();
//        int[] ans = new int[N];
//        int prev = Integer.MIN_VALUE / 2;
//
//        for (int i = 0; i < N; ++i) {
//            if (S.charAt(i) == C) prev = i;
//            ans[i] = i - prev;
//        }
//
//        prev = Integer.MAX_VALUE / 2;
//        for (int i = N-1; i >= 0; --i) {
//            if (S.charAt(i) == C) prev = i;
//            ans[i] = Math.min(ans[i], prev - i);
//        }
//
//        return ans;
//    }
	public int[] shortestToChar(String s, char c) {
        Deque<Integer> queue= new ArrayDeque<>();
        for(int i=0; i< s.length(); i++) if(s.charAt(i)==c) queue.offerLast(i);// indices of occurences
        int left=queue.pollFirst();
        int right=(!queue.isEmpty())? queue.pollFirst(): left;
        int[] result= new int[s.length()];
        for(int i=0; i< s.length(); i++) {
        	if(i==left) result[i]=0;
        	else if(i==right) {
        		result[i]=0;
        		left=right;
        		if(!queue.isEmpty()) right=queue.pollFirst();
        	}else {
        		result[i]=Math.min(Math.abs(left-i), Math.abs(right-i));
        	}
        }
        return result;
    }
}
