package com.algods.learn.trie;

import java.util.LinkedList;
import java.util.Queue;

public class TST<Value> {
	private int n; // size of tst
	private Node<Value> root;// root node of TST
	
	private static class Node<Value>{
		private char c;
		private Node<Value> left, mid, right;
		private Value val;
	}
	public TST() {}
	public int size() {return n;}
	public boolean contains(String key) {return get(key) !=null;}
	public Value get(String key) {
		if (key == null) {throw new IllegalArgumentException("calls get() with null argument");}
        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
        Node<Value> node= get(root,key,0);// root, key, level
        if(node == null) return null;
        return node.val;
	}
	public Node<Value> get(Node<Value> node, String key, int d){
		if(node == null) return null;
		if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
		char c=key.charAt(d);
		if 		(c < node.c) 			return get(node.left, key, d+1);
		else if	(c > node.c) 			return get(node.right, key, d+1);
		else if (d < key.length() -1) 	return get(node.mid, key, d+1);
		else return node;
	}
	public void put(String key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with null key");
        }
        if (!contains(key)) n++;
        else if(val == null) n--;       // delete existing key
        root = put(root, key, val, 0);
    }

    private Node<Value> put(Node<Value> x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node<Value>();
            x.c = c;
        }
        if      (c < x.c)               x.left  = put(x.left,  key, val, d);
        else if (c > x.c)               x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1)  x.mid   = put(x.mid,   key, val, d+1);
        else                            x.val   = val;
        return x;
    }
	public String longestPrefixOf(String query) {
        if (query == null) {
            throw new IllegalArgumentException("calls longestPrefixOf() with null argument");
        }
        if (query.length() == 0) return null;
        int length = 0;
        Node<Value> x = root;
        int i = 0;
        while (x != null && i < query.length()) {
            char c = query.charAt(i);
            if      (c < x.c) x = x.left;
            else if (c > x.c) x = x.right;
            else {
                i++;
                if (x.val != null) length = i;
                x = x.mid;
            }
        }
        return query.substring(0, length);
    }
	public Iterable<String> keys() {
        Queue<String> queue = new LinkedList<String>();
        collect(root, new StringBuilder(), queue);
        return queue;
    }
	public Iterable<String> keysWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }
        Queue<String> queue = new LinkedList<String>();
        Node<Value> x = get(root, prefix, 0);
        if (x == null) return queue;
        if (x.val != null) queue.add(prefix);
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
    }

    // all keys in subtrie rooted at x with given prefix
    private void collect(Node<Value> x, StringBuilder prefix, Queue<String> queue) {
        if (x == null) return;
        collect(x.left,  prefix, queue);
        if (x.val != null) queue.add(prefix.toString() + x.c);
        collect(x.mid,   prefix.append(x.c), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, queue);
    }
    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue = new LinkedList<String>();
        collect(root, new StringBuilder(), 0, pattern, queue);
        return queue;
    }
 
    private void collect(Node<Value> x, StringBuilder prefix, int i, String pattern, Queue<String> queue) {
        if (x == null) return;
        char c = pattern.charAt(i);
        if (c == '.' || c < x.c) collect(x.left, prefix, i, pattern, queue);
        if (c == '.' || c == x.c) {
            if (i == pattern.length() - 1 && x.val != null) queue.add(prefix.toString() + x.c);
            if (i < pattern.length() - 1) {
                collect(x.mid, prefix.append(x.c), i+1, pattern, queue);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        if (c == '.' || c > x.c) collect(x.right, prefix, i, pattern, queue);
    }
	public static void main(String[] args) {
		String[] words= {"she","sells","sea","shells","by","the","sea","shore"};
		TST<Integer> instance= new TST<>();
		for(int i=0; i< words.length; i++) instance.put(words[i], i);
		for(int i=0; i< words.length; i++) System.out.println(words[i]+" "+instance.get(words[i]));
		for(String k:instance.keys()) System.out.print(k+" ");
	}

}
