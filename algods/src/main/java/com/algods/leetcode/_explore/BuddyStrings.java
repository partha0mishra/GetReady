package com.algods.leetcode._explore;
/*
 * Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 

Example 1:

Input: A = "ab", B = "ba"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
Example 2:

Input: A = "ab", B = "ab"
Output: false
Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
Example 3:

Input: A = "aa", B = "aa"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
 

Constraints:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist of lowercase letters.
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.*;
public class BuddyStrings {
	public boolean buddyStrings(String A, String B) {
		HashSet<Character> hs=new HashSet<Character>();
        if(A.length() != B.length()) return false;
        
        int[] misIndex=new int[2];
        int count=0;
        boolean hasDuplicate=false;
        for(int i=0; i< A.length(); i++) {
        	if(!hasDuplicate) {
        		if(hs.contains(A.charAt(i))) {
        			hasDuplicate=true;// useful when count==0
        		}else hs.add(A.charAt(i));
        	}
        	if(A.charAt(i) != B.charAt(i)) {
        		if(count == 2) return false;
        		else misIndex[count++]=i;
        	}
        }
        if(count == 1) return false;
        else if(count ==0) return hasDuplicate;
        else return (A.charAt(misIndex[0]) == B.charAt(misIndex[1])
        		&& A.charAt(misIndex[1]) == B.charAt(misIndex[0]));
    }
	public static void main(String[] args) {
		BuddyStrings instance= new BuddyStrings();
		assertTrue(instance.buddyStrings("ab", "ba"));
		assertFalse(instance.buddyStrings("ab", "ab"));
		assertTrue(instance.buddyStrings("aaaaaaabc", "aaaaaaacb"));
		assertFalse(instance.buddyStrings("", "aa"));
		assertTrue(instance.buddyStrings("aa", "aa"));
	}
}
