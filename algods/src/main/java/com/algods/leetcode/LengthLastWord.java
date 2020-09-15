package com.algods.leetcode;
/**
 * Length of Last Word
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
import static org.junit.Assert.assertEquals;
public class LengthLastWord {
	public int lengthOfLastWord(String s) {
        if(s.trim().length() <1) return 0;
        String[] tokens=s.split(" ");
        return tokens[tokens.length-1].length();
    }
	public static void main(String[] args) {
		LengthLastWord instance = new LengthLastWord();
		assertEquals(5,instance.lengthOfLastWord("Hello World"));
		assertEquals(5,instance.lengthOfLastWord("Hello"));
		assertEquals(1,instance.lengthOfLastWord("H"));
		assertEquals(1,instance.lengthOfLastWord("H  "));
		assertEquals(0,instance.lengthOfLastWord(""));
		assertEquals(0,instance.lengthOfLastWord(" "));
		assertEquals(5,instance.lengthOfLastWord("Hello  World"));
	}

}
