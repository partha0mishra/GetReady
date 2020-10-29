package com.algods.learn.symboltable;

import java.util.NoSuchElementException;

/**
 * BST where left node < root < right node 
 */
import java.util.*;
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root; // root of BST
	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int size;
		public Node(Key key, Value val, int size) {
			this.key=key;
			this.val=val;
			this.size=size;
		}
	}
	public BinarySearchTree() {}
	public boolean isEmpty() {return size()==0;}
	public int size() {return size(root);}
	public int size(Node node) {return node== null ? 0:node.size;}
	public boolean contains(Key key) {return get(key)!=null;}
	public Value get(Key key) {return get(root,key);}
	private Value get(Node node, Key key) {
		if(key == null) throw new IllegalArgumentException("Key is Null");
		if(node == null) return null;
		int cmp=key.compareTo(node.key);
		if(cmp < 0) return get(node.left, key);
		else if(cmp > 0) return get(node.right, key);
		else return node.val;
	}
	public void put(Key key, Value val) {
		if(key == null) throw new IllegalArgumentException("Key is Null");
		if(val == null) {
			delete(key);
			return;
		}
		root = put(root, key, val);
	}
	private Node put(Node node, Key key, Value val) {
		if(node == null) return new Node(key, val, 1);// it's the leaf/ root
		int cmp= key.compareTo(node.key);
		if (cmp < 0) node.left= put(node.left, key, val);
		else if(cmp > 0) node.right= put(node.right, key, val);
		else node.val=val;
		node.size= 1+ size(node.left) + size(node.right);
		return node;
	}
	public void delete(Key key) {
		if(key == null) throw new IllegalArgumentException("Key is Null");
		root = delete(root, key);
	}
	private Node delete(Node node, Key key) {
		if(node == null) return null;
		int cmp= key.compareTo(node.key);
		if (cmp < 0) node.left=delete(node.left, key);
		else if (cmp > 0) node.right=delete(node.right, key);
		else {
			if(node.left == null) return node.right;
			if(node.right == null) return node.left;
			Node temp = node;
			node=min(temp.right);
			node.right=deleteMin(temp.right);
			node.left=temp.left;
		}
		node.size=1+ size(node.left)+size(node.right);
		return node;
	}
	public Key min() {return min(root).key;}
	private Node min(Node node) {
		if(node.left == null) 	return node;
		else					return min(node.left);
	}
	public void deleteMin() {
		root= deleteMin(root);
	}
	private Node deleteMin(Node node) {
		if(node.left == null) return node.right;
		node.left=deleteMin(node.left);
		node.size=1+ size(node.left)+size(node.right);
		return node;
	}
	public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }
	public Key select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + rank);
        }
        return select(root, rank);
    }

    // Return key in BST rooted at x of given rank.
    // Precondition: rank is in legal range.
    private Key select(Node x, int rank) {
        if (x == null) return null;
        int leftSize = size(x.left);
        if      (leftSize > rank) return select(x.left,  rank);
        else if (leftSize < rank) return select(x.right, rank - leftSize - 1); 
        else                      return x.key;
    }
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    } 

    // Number of keys in the subtree less than key.
    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    }
    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new LinkedList<Key>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node x = queue.remove();
            if (x == null) continue;
            keys.add(x.key);
            queue.add(x.left);
            queue.add(x.right);
        }
        return keys;
    }
    public Iterable<Key> inOrder(){
    	Queue<Key> keys=new LinkedList<Key>();
    	inOrder(root, keys);
    	return keys;
    }
    private void inOrder(Node node, Queue<Key> keys) {
    	if(node == null) return;
    	inOrder(node.left, keys);
    	keys.add(node.key);
    	inOrder(node.right, keys);
    }
    /* checking for validity of the tree*/
    private boolean check() {
        if (!isBST())            System.out.println("Not in symmetric order");
        if (!isSizeConsistent()) System.out.println("Subtree counts not consistent");
//        if (!isRankConsistent()) System.out.println("Ranks not consistent");
		return isBST() && isSizeConsistent()  && isRankConsistent() ;
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    } 
    public Iterable<Key> keys() {
        if (isEmpty()) return new LinkedList<Key>();
        return keys(min(), max());
    }
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    }
    /**
     * Returns the height of the BST (for debugging).
     */
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    /**
     * Returns all keys in the symbol table in the given range,
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 
    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(root); }
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }
 // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }
	public static void main(String[] args) {
		BinarySearchTree<String, Integer> instance= new BinarySearchTree<>();
		String[] data=new String[] {"S","E","A","R","C","H","E","X","A","M","P","L","E"};
		for(int i=0; i< data.length; i++) {
			instance.put(data[i], i);
		}
		System.out.println("-----Level Order -------");
		for(String s: instance.levelOrder()) {
			System.out.println(s+" "+instance.get(s));
		}
		System.out.println("-----Keys     -------");
		for(String s: instance.keys()) {
			System.out.println(s+ " "+instance.get(s));
		}
		System.out.println("-----In Order -------");
		for(String s: instance.inOrder()) {
			System.out.println(s+ " " +instance.get(s));
		}
	}
}
