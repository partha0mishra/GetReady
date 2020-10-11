package com.algods.leetcode.trie;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * 
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . 
 * means it can represent any one letter.
 * 
 * Example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
public class WordDictionaryTrie {
	class Trie{
		Trie[] letters;
		boolean end;
		Trie(){
			letters=new Trie[26];
			end=false;
		}
	}
	Trie allWords;
	/** Initialize your data structure here. */
    public WordDictionaryTrie() {
        allWords=new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
//    	System.out.println("add: "+word);
    	Trie currentPos=allWords;
        for(char c: word.toCharArray()) {
        	if(currentPos.letters[c-'a'] == null)// first occurrence, need to create
        		currentPos.letters[c-'a'] = new Trie();
        	currentPos=currentPos.letters[c-'a'];
        }
        currentPos.end=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
//        System.out.println("search: "+word);
        return findWord(word, allWords);  
    }
    // find a word in any subTrie
    private boolean findWord(String word, Trie trie) {
//    	System.out.println("word in: "+word);
    	if(trie == null) return false;// has no children
    	if(word == null || word.length() ==0) {
    		return trie.end;
    	}
//    	if(word.length() == 0) return false;
    	char currentChar = word.charAt(0);
    	String restOfWord = word.substring(1);
    	if(currentChar == '.') {// ending with a . is true
//    		if(trie.end) return true; // I probably need the chain to END next
    		for(Trie t: trie.letters) {
    			if(t == null) continue;
    			// True: if it's found in any subtree
    			if(findWord(restOfWord,t)) return true;
    		}
    		return false;
    	}else if(trie.letters[currentChar - 'a'] == null ) {
    		return false;// node doesn't exist
    	}else {
    		return findWord(restOfWord,trie.letters[currentChar - 'a']);
    	}
    }
    
	public static void main(String[] args) {
		WordDictionaryTrie instance = new WordDictionaryTrie();
		assertFalse(instance.search("a"));//false
		assertFalse(instance.search("."));//false
		assertFalse(instance.search("a."));//false
		assertFalse(instance.search("a.."));//false
		assertFalse(instance.search(".a."));//false
		assertFalse(instance.search("..a"));//false
		assertFalse(instance.search(".."));//false
		instance.addWord("bad");
		instance.addWord("dad");
		instance.addWord("mad");
		assertFalse(instance.search("pad"));//false
		assertTrue(instance.search("bad"));//true
		assertTrue(instance.search(".ad"));//true
		assertTrue(instance.search("b.."));//true
		assertTrue(instance.search(".a."));//true
		assertFalse(instance.search("."));//false
		assertFalse(instance.search(".."));//false
		assertTrue(instance.search("..."));//true
	}

}
