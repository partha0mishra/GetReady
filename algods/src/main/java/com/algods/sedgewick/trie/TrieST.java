package com.algods.sedgewick.trie;

public class TrieST<Value> {
	public static final int R=256; // extended ASCII
	private Node root;
	private int n; // number of keys in the trie
	private static class Node{
		private Object val;
		private Node[] next= new Node[R];
	}
	public TrieST() {}
	public Value get(String key) {
		Node x= get(root, key, 0);
		if(x == null) return null;
		return (Value)x.val;
	}
	public boolean containsKey(String key) {
		return get(key) != null;
	}
	private Node get(Node node, String key, int d) {
		if(node == null) return null;
		if(d == key.length()) return node;
		char c= key.charAt(d);
		return get(node.next[c], key, d+1);
	}
	public void put(String key, Value val) {
		if(val == null) delete(key);
		else root= put(root, key, val,0);
	}
	private Node put(Node node, String key, Value val, int d) {
		if(node == null) node= new Node();// IMPORTANT
		if(d== key.length()) {
			if(node.val == null) n++;// a new string is added to the Trie
			node.val=val;
			return node;
		}
		char c=key.charAt(d);
		node.next[c]=put(node.next[c], key, val, d+1);
		return node;
	}
	public int size() {return n;}
	public boolean isEmpty() {return size()==0;}
	public void delete(String key) {
		root=delete(root, key,0);
	}
	private Node delete(Node node, String key, int d) {
		if(node == null) return null;
		if(d == key.length()) {
			if(node.val != null) n--;
			node.val=null;
		} else {
			char c= key.charAt(d);
			node.next[c]=delete(node.next[c],key, d+1);
		}
		// remove subtrie rooted at x if it is completely empty
        if (node.val != null) return node;
        for (int c = 0; c < R; c++)
        	if (node.next[c] != null)
        		return node;
        return null;
	}
	public String longestPrefixOf(String query) {
        if (query == null) throw new IllegalArgumentException("argument to longestPrefixOf() is null");
        int length = longestPrefixOf(root, query, 0, -1);
        if (length == -1) return null;
        else return query.substring(0, length);
    }

    // returns the length of the longest string key in the subtrie
    // rooted at x that is a prefix of the query string,
    // assuming the first d character match and we have already
    // found a prefix match of given length (-1 if no such match)
    private int longestPrefixOf(Node x, String query, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (d == query.length()) return length;
        char c = query.charAt(d);
        return longestPrefixOf(x.next[c], query, d+1, length);
    }
	public static void main(String[] args) {
		String[] words= {"she","sells","sea","shells","by","the","sea","shore"};
		TrieST<Integer> instance= new TrieST<Integer>();
		for(int i=0; i< words.length; i++) instance.put(words[i], i);
		for(int i=0; i< words.length; i++) instance.get(words[i]);
	}

}
