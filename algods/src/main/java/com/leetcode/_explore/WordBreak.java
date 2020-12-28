package com.leetcode._explore;
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
	HashMap<String,Boolean> cache= new HashMap<String, Boolean>();
	/* Approach 01: Brute Force.
	 * Adding cache */
	public boolean wordBreak(String inputString, List<String> wordDict) {
        if(inputString.length() == 0) return true;
        if(cache.containsKey(inputString)) return cache.get(inputString);

        boolean status=false;
        for(String word: wordDict) {
        	if(inputString.startsWith(word)) {
        		status=wordBreak(inputString.substring(word.length()),wordDict);
        	}
        	if(status) break;
        }
        cache.put(inputString, status);
        return status;
    }
	public static void main(String[] args) {
		WordBreak instance= new WordBreak();
		assertTrue(instance.wordBreak("leetcode", Arrays.asList(new String[] {"leet", "code"})));
		assertTrue(instance.wordBreak("applepenapple", Arrays.asList(new String[] {"apple", "pen"})));
		assertFalse(instance.wordBreak("catsandog", Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"})));
		assertFalse(instance.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList(new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})));
	}

}
