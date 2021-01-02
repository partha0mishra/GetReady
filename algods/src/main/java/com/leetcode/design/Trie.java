package com.leetcode.design;
/** TODO Anki
 * Implement Trie (prefix tree)
 * Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class Trie {
	class TrieNode{
		TrieNode[] letters;// a-z - if I initialize in constructor, it will be null otherwise
		boolean end;// delineates words
		public TrieNode() {letters=new TrieNode[26]; end=false;}
	}
	TrieNode trie;
	/** Initialize your data structure here. */
    public Trie() {
        trie=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode current=trie;
        for(char c: word.toCharArray()) {
        	if(current.letters[c-'a'] == null)
        		current.letters[c-'a'] = new TrieNode();
        	current=current.letters[c-'a'];
        }
        current.end=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return find(word, false);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix, true);
    }
    private boolean find(String word, boolean startsWith) {
    	TrieNode current=trie;
    	if(current == null) return false;
    	for(char c: word.toCharArray()) {
    		if(current.letters[c-'a'] == null) return false;
    		current=current.letters[c-'a'];
    	}
    	return current.end || startsWith;// delineation indicator || not needed
    }
	public static void main(String[] args) {
		Trie trie= new Trie();
		trie.insert("apple");
		assertTrue(trie.search("apple"));
		assertFalse(trie.search("app"));
		assertTrue(trie.startsWith("app"));
		trie.insert("app");
		assertTrue(trie.search("app"));
	}

}
