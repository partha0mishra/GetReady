package com.algods.leetcode.explore.september;
/***
 * Word Break
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
import java.util.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        for(String word: wordDict) {
        	boolean status=false;
        	if(s.startsWith(word)) status=wordBreak(s.substring(word.length()),wordDict);
        	if(status) return true;
        }
        return false;
    }
	public static void main(String[] args) {
		WordBreak instance= new WordBreak();
		assertTrue(instance.wordBreak("leetcode", Arrays.asList(new String[] {"leet", "code"})));
		assertTrue(instance.wordBreak("applepenapple", Arrays.asList(new String[] {"apple", "pen"})));
		assertFalse(instance.wordBreak("catsandog", Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"})));
	}

}
