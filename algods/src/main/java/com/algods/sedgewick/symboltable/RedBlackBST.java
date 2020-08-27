package com.algods.sedgewick.symboltable;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/*
 * LLRB implementation
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private Node root;// root of BST
	private class Node{
		private Key key;
		private Value val;
		private boolean color;
		private int size;
		private Node left, right;
		
		public Node(Key key, Value val, boolean color, int size) {
			this.key=key;
			this.val=val;
			this.color=color;
			this.size=size;
		}
	}
	public RedBlackBST() {}
	private boolean isRed(Node node) {// null is black
		return node == null? false:node.color == RED;
	}
	private int size(Node node) {
		return node == null? 0: node.size;
	}
	public int size() {return size(root);}
	public boolean isEmpty() {return root==null;}
	public Value get(Key key) {return get(root, key);}
	private Value get(Node node, Key key) {
		while(node != null) {
			int cmp=key.compareTo(node.key);
			if(cmp < 0) node=node.left;
			else if(cmp > 0) node=node.right;
			else return node.val;
		}
		return null;
	}
	public boolean contains(Key key) { return get(key) != null;}
	public void put(Key key, Value val) {
		if(key == null) throw new IllegalArgumentException("Key is null");
		if(val == null) {delete(key); return;}
		root=put(root, key, val);
		root.color=BLACK;
	}
	private RedBlackBST<Key, Value>.Node put(RedBlackBST<Key, Value>.Node node, Key key, Value val) {
		if(node == null) return new Node(key, val, RED, 1);
		int cmp= key.compareTo(node.key);
		
		if(cmp <0 ) node.left=put(node.left, key, val);
		else if(cmp >0) node.right=put(node.right, key, val);
		else node.val=val;
		
		// fix-up any right-leaning links
        if (isRed(node.right) && !isRed(node.left))      node = rotateLeft(node);
        if (isRed(node.left)  &&  isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left)  &&  isRed(node.right))     flipColors(node);
        node.size = size(node.left) + size(node.right) + 1;
		return node;
	}
	public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }
	// delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h) { 
        if (h.left == null)
            return null;

        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }
 // delete the key-value pair with the maximum key rooted at h
    private Node deleteMax(Node h) { 
        if (isRed(h.left))
            h = rotateRight(h);

        if (h.right == null)
            return null;

        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);

        h.right = deleteMax(h.right);

        return balance(h);
    }
    public void delete(Key key) { 
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    // delete the key-value pair with the given key rooted at h
    private Node delete(Node h, Key key) { 
        // assert get(h, key) != null;

        if (key.compareTo(h.key) < 0)  {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        }
        else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.val = x.val;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right, key);
        }
        return balance(h);
    }
    /***************************************************************************
     *  Red-black tree helper functions.
     ***************************************************************************/

     // make a left-leaning link lean to the right
     private Node rotateRight(Node h) {
         // assert (h != null) && isRed(h.left);
         Node x = h.left;
         h.left = x.right;
         x.right = h;
         x.color = x.right.color;
         x.right.color = RED;
         x.size = h.size;
         h.size = size(h.left) + size(h.right) + 1;
         return x;
     }

     // make a right-leaning link lean to the left
     private Node rotateLeft(Node h) {
         // assert (h != null) && isRed(h.right);
         Node x = h.right;
         h.right = x.left;
         x.left = h;
         x.color = x.left.color;
         x.left.color = RED;
         x.size = h.size;
         h.size = size(h.left) + size(h.right) + 1;
         return x;
     }

     // flip the colors of a node and its two children
     private void flipColors(Node h) {
         // h must have opposite color of its two children
         // assert (h != null) && (h.left != null) && (h.right != null);
         // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
         //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
         h.color = !h.color;
         h.left.color = !h.left.color;
         h.right.color = !h.right.color;
     }

     // Assuming that h is red and both h.left and h.left.left
     // are black, make h.left or one of its children red.
     private Node moveRedLeft(Node h) {
         // assert (h != null);
         // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

         flipColors(h);
         if (isRed(h.right.left)) { 
             h.right = rotateRight(h.right);
             h = rotateLeft(h);
             flipColors(h);
         }
         return h;
     }

     // Assuming that h is red and both h.right and h.right.left
     // are black, make h.right or one of its children red.
     private Node moveRedRight(Node h) {
         // assert (h != null);
         // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
         flipColors(h);
         if (isRed(h.left.left)) { 
             h = rotateRight(h);
             flipColors(h);
         }
         return h;
     }

     // restore red-black tree invariant
     private Node balance(Node h) {
         // assert (h != null);

         if (isRed(h.right))                      h = rotateLeft(h);
         if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
         if (isRed(h.left) && isRed(h.right))     flipColors(h);

         h.size = size(h.left) + size(h.right) + 1;
         return h;
     }
     /***************************************************************************
      *  Utility functions.
      ***************************************************************************/

      /**
       * Returns the height of the BST (for debugging).
       * @return the height of the BST (a 1-node tree has height 0)
       */
      public int height() {
          return height(root);
      }
      private int height(Node x) {
          if (x == null) return -1;
          return 1 + Math.max(height(x.left), height(x.right));
      }
      public Key min() {
          if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
          return min(root).key;
      } 

      // the smallest key in subtree rooted at x; null if no such key
      private Node min(Node x) { 
          // assert x != null;
          if (x.left == null) return x; 
          else                return min(x.left); 
      }
      public Key max() {
          if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
          return max(root).key;
      } 

      // the largest key in the subtree rooted at x; null if no such key
      private Node max(Node x) { 
          // assert x != null;
          if (x.right == null) return x; 
          else                 return max(x.right); 
      }
      public Iterable<Key> keys() {
          if (isEmpty()) return new LinkedList<Key>();
          return keys(min(), max());
      }

      public Iterable<Key> keys(Key lo, Key hi) {
          if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
          if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

          Queue<Key> queue = new LinkedList<Key>();
          // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
          keys(root, queue, lo, hi);
          return queue;
      } 

      // add the keys between lo and hi in the subtree rooted at x
      // to the queue
      private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
          if (x == null) return; 
          int cmplo = lo.compareTo(x.key); 
          int cmphi = hi.compareTo(x.key); 
          if (cmplo < 0) keys(x.left, queue, lo, hi); 
          if (cmplo <= 0 && cmphi >= 0) queue.add(x.key); 
          if (cmphi > 0) keys(x.right, queue, lo, hi); 
      } 
	public static void main(String[] args) {
		RedBlackBST<String, Integer> instance= new RedBlackBST<>();
		String[] data=new String[] {"S","E","A","R","C","H","E","X","A","M","P","L","E"};
		for(int i=0; i< data.length; i++) {
			instance.put(data[i], i);
		}
		System.out.println("-----Keys     -------");
		for(String s: instance.keys()) {
			System.out.println(s+ " "+instance.get(s));
		}
	}
}
