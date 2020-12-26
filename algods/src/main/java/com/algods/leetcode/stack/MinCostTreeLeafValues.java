package com.algods.leetcode.stack;
/**
 * 1130. Minimum Cost Tree From Leaf Values
 * Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.

 

Example 1:

Input: arr = [6,2,4]
Output: 32
Explanation:
There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.

    24            24
   /  \          /  \
  12   4        6    8
 /  \               / \
6    2             2   4
 

Constraints:

2 <= arr.length <= 40
1 <= arr[i] <= 15
It is guaranteed that the answer fits into a 32-bit signed integer (ie. it is less than 2^31).
Accepted
44,464
Submissions
66,257
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class MinCostTreeLeafValues {
	/**
	 * This is not a 'tree' question at all.
	 * for every c,b,b where b is the smallest, multiply it with the minimum(c,a) and add that to the result, and b vanishes.
	 * we can use a Monotonic, decreasing stack and
	 * whenever a bigger value is encountered, pop out (b)
	 * then check if c or a is smaller
	 * multiply smaller(c,a) with b and add to result
	 * b vanishes. 'a' gets pushed in, unless a is <= c in which case c is the new b.
	 * IMPORTANT to have Integer.MAX_VALUE in the beginning of the stack.
	 * 
	 * O(N)/ O(N)
	 */
	public int mctFromLeafValues(int[] arr) {
        int result=0;
        Stack<Integer> stack= new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for(int a: arr) {
        	while(stack.peek() <=a) {
        		int mid=stack.pop();
        		result+=mid*Math.min(stack.peek(),a);
        	}
        	stack.push(a);
        }
        while(stack.size() > 2) {// it's now monotonic Decreasing. keep multiplying from right.
        	result+=stack.pop()*stack.peek();
        }
        return result;
    }
	public static void main(String[] args) {
		assertEquals(32,new MinCostTreeLeafValues().mctFromLeafValues(new int[] {6,2,4}));
	}

}
