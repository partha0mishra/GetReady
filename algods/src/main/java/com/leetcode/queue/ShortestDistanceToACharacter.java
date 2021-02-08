package com.leetcode.queue;
/**
 * Shortest Distance to a Character
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
