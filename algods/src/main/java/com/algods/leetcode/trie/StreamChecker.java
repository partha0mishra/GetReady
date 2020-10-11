package com.algods.leetcode.trie;
/*
 * Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 

Note:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000.
 */
import java.util.*;

import org.junit.Assert;
public class StreamChecker {
	/* Approach 04: Trie Based - more performant*/
    class TrieNode {
        boolean isWord;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        createTrie(words);
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            char c = sb.charAt(i);
            node = node.next[c - 'a'];
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }

    private void createTrie(String[] words) {
        for (String s : words) {
            TrieNode node = root;
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isWord = true;
        }
    }
	/* Approach 03: Trie based*/
//	private StringBuilder sb;
//	private TrieNode root;
//	public StreamChecker(String[] words) {
//       sb= new StringBuilder();
//       root = new TrieNode();
//       for(String w: words) insert(w);
//    }
//    
//    public boolean query(char letter) {
//    	sb.append(letter);
//    	TrieNode node=root;
//    	for(int i=sb.length()-1; i>=0 && node != null; i--) {
//    		char c=sb.charAt(i);
//    		node=node.next.get(c);
//    		if(node != null && node.isWord) {
//    			return true;
//    		}
//    	}
//    	return false;
//    }
//    class TrieNode{
//    	Map<Character, TrieNode> next;
//    	boolean isWord;
//    	public TrieNode() {
//    		next= new HashMap<Character, TrieNode>();
//    	}
//    }
// // insert in Tried in REVERSE order
//    public void insert(String word) {
//    	TrieNode current=root;
//    	for(int i=word.length() -1; i>=0; i--) {
//    		char c=word.charAt(i);
//    		TrieNode node=current.next.getOrDefault(c, new TrieNode());
//    		current.next.put(c, node);
//    		current=node;
//    	}
//    	current.isWord=true;
//    }
	/* Approach 02: Brute force*/
//	private HashSet<String> hsWords;
//	private StringBuilder queries;
//	public StreamChecker(String[] words) {
//        hsWords = new HashSet<String>();
//        for(String w: words) hsWords.add(w);
//        queries=new StringBuilder();
//    }
//    
//    public boolean query(char letter) {
//    	queries.append(letter);
//    	for(int index=queries.length()-1; index >= 0; index--) {
//    		if(hsWords.contains(queries.substring(index))) return true;
//    	}
//    	return false;
//    }
	/* Approach 01: Brute force - TLE*/
//	private HashSet<String> hsWords;
//	private ArrayList<Character> queries;
//	public StreamChecker(String[] words) {
//        hsWords = new HashSet<String>();
//        for(String w: words) hsWords.add(w);
//        queries=new ArrayList<Character>();
//    }
//    
//    public boolean query(char letter) {
//    	queries.add(letter);
//    	StringBuilder searchString= new StringBuilder();
//    	for(int index=queries.size()-1; index >= 0; index--) {
//    		StringBuilder tempString=new StringBuilder(queries.get(index).toString());
//    		searchString= tempString.append(searchString);
//    		if(hsWords.contains(searchString.toString())) return true;
//    	}
//    	return false;
//    }
	public static void main(String[] args) {
		String[] words={"cd","f","kl"};
		StreamChecker streamChecker = new StreamChecker(words); // init the dictionary.
		Assert.assertFalse(streamChecker.query('a'));          // return false
		Assert.assertFalse(streamChecker.query('b'));          // return false
		Assert.assertFalse(streamChecker.query('c'));          // return false
		Assert.assertTrue(streamChecker.query('d'));          // return true, because 'cd' is in the wordlist
		Assert.assertFalse(streamChecker.query('e'));          // return false
		Assert.assertTrue(streamChecker.query('f'));          // return true, because 'f' is in the wordlist
		Assert.assertFalse(streamChecker.query('g'));          // return false
		Assert.assertFalse(streamChecker.query('h'));          // return false
		Assert.assertFalse(streamChecker.query('i'));          // return false
		Assert.assertFalse(streamChecker.query('j'));          // return false
		Assert.assertFalse(streamChecker.query('k'));          // return false
		Assert.assertTrue(streamChecker.query('l'));          // return true, because 'kl' is in the wordlist
	}

}
