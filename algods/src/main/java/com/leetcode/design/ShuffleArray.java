package com.leetcode.design;
/** TODO Anki
 * 384. Given an integer array nums, design an algorithm to randomly shuffle the array.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.
 

Example 1:

Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]

 

Constraints:

1 <= nums.length <= 200
-106 <= nums[i] <= 106
All the elements of nums are unique.
At most 5 * 104 calls will be made to reset and shuffle.
 */
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
public class ShuffleArray {
	class Solution {
		int[] n, temp;
	    public Solution(int[] nums) {
	        this.n=nums;
	        temp=new int[n.length];
	        for(int i=0; i< n.length; i++) temp[i]=n[i];
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return n;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {// O(n) per call 
	        Random random=ThreadLocalRandom.current();
	        for(int from=0; from< n.length; from++) {
	        	int to=random.nextInt(from+1);
	        	int t=temp[from]; temp[from]=temp[to]; temp[to]=t;
	        }
	        return temp;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
