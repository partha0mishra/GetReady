package com.algods.leetcode;

import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, 
 * we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 * 
 * Example 01:
 * 
 *   3
 *  / \
 * 9  20
 *    / \
 *  15   7
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation: 
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 * 
 * Example 02:
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4   5 6   7
 * Input: [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation: 
 * The node with value 5 and the node with value 6 have the same position according to the given scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 * 
 * Note:
 * The tree will have between 1 and 1000 nodes.
 * Each node's value will be between 0 and 1000.
 */
public class BinaryTreeVerticalOrderTraversal {
/** Definition for a binary tree node. */
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
    /** Approach 02: works
	public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
        Queue<TreeNode> q = new LinkedList<>();
		
		//while traversing we are storing values in below format
		//<HorizonalDistFromRoot, <VerticalLevel, List<Integer>>
		//At the end while storing result in a List<> we are sorting the List<>
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
		
		//We are storing the horizinal position from root, so we know which vertical
		//line this node will corresponds to.
        Map<String, Integer> horizPosMap = new HashMap<>();
        q.offer(root);
        int level = 0;
        //level order traversal so we can keep track of height of a node from root
        while(!q.isEmpty())  {
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode t = q.poll();
                String key = t.val+"|"+level;
                int horizPos = 0;
                int newlevel = level + 1;
                if(horizPosMap.get(key) != null)    {
                    horizPos = horizPosMap.get(key);
                    horizPosMap.remove(key);  //Key is removed to handle duplicate key if any 
                }
                Map<Integer, List<Integer>> lm = map.get(horizPos);
                if(lm==null) {
                    lm = new HashMap<>();
                    List<Integer> l = new ArrayList<>();
                    l.add(t.val);
                    lm.put(newlevel, l);
                    map.put(horizPos,lm);

                } else {
                    List<Integer> l = lm.get(newlevel);
                    if(l == null)   {
                        l = new ArrayList<>();
                        l.add(t.val);
                        lm.put(newlevel,l);
                    }   else {
                        l.add(t.val);
                        Collections.sort(l);
                    }
                }
                if(t.left != null) {
                    horizPosMap.put(t.left.val+"|"+newlevel,horizPos-1);
                    q.offer(t.left);
                }
                if(t.right != null) {
                    horizPosMap.put(t.right.val + "|" + newlevel, horizPos + 1);
                    q.offer(t.right);
                }
            }
            level++;
        }
		//To find out maximum left side span of the tree and right side span of the tree
		//min refers to left and max refers to right
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Integer r : map.keySet())   {
            if(r < min) min = r;
            if(r > max) max = r;
        }
        for(int i=min;i<=max;i++)   {
            if(map.get(i) == null)  continue;
            Map<Integer, List<Integer>> hm1 = map.get(i);
            List<Integer> lo = new ArrayList<>();
            for(int j=0;j<level+1;j++)    {
                if(hm1.get(j) != null)
                    lo.addAll(hm1.get(j));
            }
            res.add(lo);
        }
        return res;
    }
    */
    //** Approach 01: doesn't sort the inner array lists as needed :(
	public List<List<Integer>> verticalTraversal(TreeNode root) { 	
    	TreeMap<Integer, ArrayList<Integer>> tmap= new TreeMap<Integer, ArrayList<Integer>>();
    	traverse(root,tmap);
    	List<List<Integer>> result= new ArrayList<>();
    	result.addAll(tmap.values());
		return result;
    }
	private void traverse(TreeNode root, TreeMap<Integer, ArrayList<Integer>> tmap) {
		if(root == null) return;
		LinkedList<TreeNode> levelOrderList= new LinkedList<TreeNode>();
		LinkedList<Integer> orderList= new LinkedList<Integer>();
		levelOrderList.offer(root);
		orderList.offer(0);
		
		while(!levelOrderList.isEmpty()) {// level order traversal
			TreeNode node=levelOrderList.poll();
			int order=orderList.poll();
			
			// Add to Map
			ArrayList<Integer> list= tmap.get(order);
			if(list == null) {
				list= new ArrayList<Integer>();
				tmap.put(order, list);
			}
			list.add(node.val);
			
			if(node.left !=null ) {
				levelOrderList.offer(node.left);
				orderList.offer(order -1);
			}
			if(node.right != null) {
				levelOrderList.offer(node.right);
				orderList.offer(order +1);
			}
			//Collections.sort(list);
		}
	}
	//*/
	public static void main(String[] args) {
		BinaryTreeVerticalOrderTraversal instance= new BinaryTreeVerticalOrderTraversal();
		// Input: [3,9,20,null,null,15,7]
		// Output: [[9],[3,15],[20],[7]]
		TreeNode root=instance.new TreeNode(3);
		root.left=instance.new TreeNode(9);
		root.right=instance.new TreeNode(20);
		root.right.left=instance.new TreeNode(15);
		root.right.right=instance.new TreeNode(7);
		System.out.println(instance.verticalTraversal(root));
		// Input: [1,2,3,4,5,6,7]
		// Output: [[4],[2],[1,5,6],[3],[7]]
		root=instance.new TreeNode(1);
		root.left=instance.new TreeNode(2);
		root.right=instance.new TreeNode(3);
		root.left.left=instance.new TreeNode(4);
		root.left.right=instance.new TreeNode(5);
		root.right.left=instance.new TreeNode(6);
		root.right.right=instance.new TreeNode(7);
		System.out.println(instance.verticalTraversal(root));
		// Input: [0,2,1,3,null,null,null,4,5,null,7,6,null,10,8,11,9]
		// Output: [[4,10,11],[3,6,7],[2,5,8,9],[0],[1]]
		// Note: 3,6,7 => 7 and 6 are in the same x,y
		root=instance.new TreeNode(0);
		root.left=instance.new TreeNode(2);
		root.right=instance.new TreeNode(1);
		root.left.left=instance.new TreeNode(3);
		root.left.left.left=instance.new TreeNode(4);
		root.left.left.right=instance.new TreeNode(5);
		root.left.left.left.right=instance.new TreeNode(7);
		root.left.left.right.left=instance.new TreeNode(6);
		root.left.left.left.right.left=instance.new TreeNode(10);
		root.left.left.left.right.right=instance.new TreeNode(8);
		root.left.left.right.left.left=instance.new TreeNode(11);
		root.left.left.right.left.right=instance.new TreeNode(9);
		System.out.println(instance.verticalTraversal(root));
		// Input: [0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,7]
		// Output: [[9,7],[5,6],[0,2,4],[1,3],[8]]
		// Note: 9,7 => 9 is at an earlier level
		root= instance.new TreeNode(0);
		root.left= instance.new TreeNode(5);
		root.right= instance.new TreeNode(1);
		root.left.left= instance.new TreeNode(9);
		root.right.left= instance.new TreeNode(2);
		root.right.left.right= instance.new TreeNode(3);
		root.right.left.right.left= instance.new TreeNode(4);
		root.right.left.right.right= instance.new TreeNode(8);
		root.right.left.right.left.left= instance.new TreeNode(6);
		root.right.left.right.left.left.left= instance.new TreeNode(7);
		System.out.println(instance.verticalTraversal(root));
	}

}
