package com.leetcode.arrays;
/**
 * Determine if Two Strings Are Close
 * Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

 

Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
Example 4:

Input: word1 = "cabbba", word2 = "aabbss"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any amount of operations.
 

Constraints:

1 <= word1.length, word2.length <= 105
word1 and word2 contain only lowercase English letters.
* Hints:
* Operation 1 allows you to freely reorder the string.
* Operation 2 allows you to freely reassign the letters' frequencies.
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.*;
public class TwoCloseStrings {
	/**
	 * Keeping counts in a map <char, count>
	 * O(N)/ O(1) but obviously better than the rough implementation
	 */
	public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int word1Map[] = new int[26];
        int word2Map[] = new int[26];
        for (char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((word1Map[i] == 0 && word2Map[i] > 0) ||
                (word2Map[i] == 0 && word1Map[i] > 0)) {
                return false;
            }
        }
        Arrays.sort(word1Map);
        Arrays.sort(word2Map);
        return Arrays.equals(word1Map, word2Map);
    }
	/**
	 * Rough implementation
	 * O(N)/ O(1)
	 */
	public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] count1= new int[26], count2=new int[26];
        HashSet<Character> letters1=new HashSet<>(), letters2= new HashSet<>();
        for(char c: word1.toCharArray()) {
        	count1[c-'a']+=1;
        	letters1.add(c);
        }
        for(char c: word2.toCharArray()) {
        	count2[c-'a']+=1;
        	if(!letters1.contains(c)) return false; // character sets are different
        	letters2.add(c);
        }
        if(letters1.size() != letters2.size()) return false;
        Arrays.sort(count1);
        Arrays.sort(count2);
//        for(int i=0; i<26; i++) {
//        	if(count1[i] != count2[i]) return false;
//        }
        return Arrays.equals(count1, count2);
    }
	public static void main(String[] args) {
		assertTrue(new TwoCloseStrings().closeStrings("abc", "bca"));
		assertFalse(new TwoCloseStrings().closeStrings("a", "aa"));
		assertTrue(new TwoCloseStrings().closeStrings("cabbba", "cabbba"));
		assertFalse(new TwoCloseStrings().closeStrings("cabbba", "aabbss"));
	}

}
