package com.algods.leetcode;
/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
 *
 *Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
 *
 *Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
 *
 *Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */

import java.util.*;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordFinder(s,wordDict,new HashMap<String,List<String>>());
    }
    /*
     * APPROACH:
     * Take the words from the dictionary, and check if the target String starts with that.
     * If it does, we will generate all the valid substrings, and simply add that to our result.
     */
    private List<String> wordFinder(String inputString, List<String> dictionary, Map<String,List<String>> cache){
    	if(cache.containsKey(inputString)) return cache.get(inputString); // Already know the result
    	List<String> result= new ArrayList<String>(); //
    	if(inputString.length()==0) {
    		result.add("");
    		return result;
    	}
    	for(String word: dictionary) {
    		if(inputString.startsWith(word)) {
    			List<String> substrings= wordFinder(inputString.substring(word.length()),dictionary,cache);
    			for(String eachSub: substrings) {
    				if(eachSub.isEmpty()) {
    					result.add(word);
    				}else {
    					result.add(word+" "+eachSub);
    				}
        		}
    		}
    	}
    	cache.put(inputString, result);
    	return result;
    }
	public static void main(String[] args) {
		WordBreak2 instance= new WordBreak2();
		String[] wordDict01= {"cat", "cats", "and", "sand", "dog"};
		System.out.println(instance.wordBreak("catsanddog", Arrays.asList(wordDict01)));
		String[] wordDict02= {"apple", "pen", "applepen", "pine", "pineapple"};
		System.out.println(instance.wordBreak("pineapplepenapple", Arrays.asList(wordDict02)));
		String[] wordDict03= {"cats", "dog", "sand", "and", "cat"};
		System.out.println(instance.wordBreak("catsandog", Arrays.asList(wordDict03)));
		
		System.out.println(instance.wordBreak2("catsanddog", Arrays.asList(wordDict01)));
		System.out.println(instance.wordBreak2("pineapplepenapple", Arrays.asList(wordDict02)));
		System.out.println(instance.wordBreak2("catsandog", Arrays.asList(wordDict03)));
	}
	/*
	 * Approach 2: regular DFS with StringBuilder
	 */
	public List<String> wordBreak2(String s, List<String> wordDict) {
//		if (s.length() > 100) return new ArrayList();

		List<String> result = new ArrayList<String> ();
		wordBreakUtil(s, wordDict, result, new StringBuilder());
		return result;
	}
	public void wordBreakUtil(String s, List<String> wordDict, List<String> result, StringBuilder subList) {
        // add " " between 2 words in subList
		if (subList.length() != 0) {
			subList.append(" ");
		}
		// iterate over all the words in wordDict
        for (String word: wordDict) {
			
			if (s.startsWith(word)) {
				StringBuilder sb = new StringBuilder(subList);
			    // append current match in sb
				sb.append(word); 
			    // if this is last word to be matched
				if (s.equals(word)) {
					result.add(new String(sb));
				} else {
					wordBreakUtil(s.substring(word.length()), wordDict, result, sb);
				}
            }
		}
	}
}
