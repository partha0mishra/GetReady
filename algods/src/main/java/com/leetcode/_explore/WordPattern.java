package com.leetcode;
/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */
import java.util.HashMap;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		int patternLength= pattern.length();
		String[] strTokens=str.split(" ");
		int strTokensLength= strTokens.length;
		
		if(patternLength != strTokensLength) return false;
		HashMap<Character, String> hmCharStr= new HashMap<Character, String>();
		HashMap<String, Character> hmStrChar= new HashMap<String, Character>();
		for(int i=0; i< patternLength; i++) {
			char c=pattern.charAt(i);
			String correspondingString=strTokens[i];
//			System.out.println("char: "+c+" str: "+correspondingString);
			if(hmCharStr.containsKey(c)) {
//				System.out.println("Contains: "+hmCharStr.get(c));
				if(! (hmCharStr.get(c).equals(correspondingString) && hmStrChar.get(correspondingString) == c)) return false;
			}else {
				hmCharStr.put(c, correspondingString);
				if(hmStrChar.containsKey(correspondingString)) return false;
				hmStrChar.put(correspondingString, c);
			}
		}
		
		return true;
    }
	public static void main(String[] args) {
		WordPattern instance = new WordPattern();
		assertTrue(instance.wordPattern("abba", "dog cat cat dog"));
		assertFalse(instance.wordPattern("abba", "dog cat cat fish"));
		assertFalse(instance.wordPattern("aaaa", "dog cat cat dog"));
		assertFalse(instance.wordPattern("abba", "dog dog dog dog"));
	}

}
