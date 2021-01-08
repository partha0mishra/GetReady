package com.leetcode.arrays;
/** TODO Anki
 * Check If Two String Arrays are Equivalent
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

 

Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false
Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true
 

Constraints:

1 <= word1.length, word2.length <= 103
1 <= word1[i].length, word2[i].length <= 103
1 <= sum(word1[i].length), sum(word2[i].length) <= 103
word1[i] and word2[i] consist of lowercase letters.
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class CheckTwoStringArraysEquivalent {
	public static final char HASH='#';
	class ArrayIterate{
		String[] word;
		int arrayNo, elementNo;
		public ArrayIterate(String[] w) {
			this.word=w;
			arrayNo=0; elementNo=0;
		}
		public char getNext() {
			while(arrayNo < word.length && elementNo==word[arrayNo].length()) {
				arrayNo+=1;
				elementNo=0;
			}
			if(arrayNo == word.length) return HASH;
			return word[arrayNo].charAt(elementNo++);
		}
	}
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        ArrayIterate a1=new ArrayIterate(word1), a2= new ArrayIterate(word2);
        char a1c, a2c;
        while(true) {
        	a1c=a1.getNext(); a2c=a2.getNext();
        	if(a1c != a2c) return false;
        	if(a1c == HASH || a2c == HASH) break;
        }
        return true;
    }
	public static void main(String[] args) {
		CheckTwoStringArraysEquivalent ct= new CheckTwoStringArraysEquivalent();
//		ArrayIterate ai= ct.new ArrayIterate(new String[] 
//				{"a","b","cd","efg","hijk","","l"}
//				{"ab","c"}
//		);
//		while(true) {
//			char c=ai.getNext();
//			if(c==HASH) break;
//			System.out.println(c);
//		}
		
		
		assertTrue(ct.arrayStringsAreEqual(new String[] {"ab","c"}, new String[] {"a","bc"}));
		assertFalse(ct.arrayStringsAreEqual(new String[] {"a", "cb"},new String[] {"ab","c"}));
		assertTrue(ct.arrayStringsAreEqual(new String[] {"abc","d","defg"}, new String[] {"abcddefg"}));
	}
}
