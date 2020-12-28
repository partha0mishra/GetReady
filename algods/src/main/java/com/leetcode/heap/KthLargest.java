package com.leetcode.heap;

import java.util.Arrays;

/* 703. Kth Largest Element in a Stream
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Returns the element representing the kth largest element in the stream.
 

Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
 

Constraints:

1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
 */
import java.util.*;
public class KthLargest {
	/* Approach 02: Using PriorityQueue */
	final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : nums)
            add(n);
    }

    public int add(int val) {
        if (q.size() < k)// not full yet
            q.offer(val);
        else if (q.peek() < val) {// full, with a value less than 'val'
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
	/* Approach 01: using Arrays.sort() */
//	Integer[] items;
//	int k;
//	
//	public KthLargest(int k, int[] nums) {
//		this.k=k;
//		items=new Integer[k+1];
//        Arrays.sort(nums);
//        for(int i=0; i<=k; i++) {// initializing items from back
//        	if(i < nums.length) items[k-i]=nums[nums.length -1-i];
//        	else items[k-i]=Integer.MIN_VALUE;
//        }
//    }
//    
//    public int add(int val) {
//    	if(val > items[0]) {
//    		items[0]=val;
//    	}
//        Arrays.sort(items);
//        return items[1];
//    }
    
	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
		System.out.println(kthLargest.add(3));   // return 4
		System.out.println(kthLargest.add(5));   // return 5
		System.out.println(kthLargest.add(10));  // return 5
		System.out.println(kthLargest.add(9));   // return 8
		System.out.println(kthLargest.add(4));   // return 8
		
		KthLargest k2 = new KthLargest(2, new int[] {0});
		System.out.println(k2.add(-1));
	}
}
