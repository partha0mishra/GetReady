package com.leetcode.recursion.binarySearch;
/**
 * 1552  Magnetic Force Between Two Balls - MEDIUM
 * 
 * In universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. 
 * Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that 
 * the minimum magnetic force between any two balls is maximum.
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 * Given the integer array position and the integer m. Return the required force.
 * Example 1:
 * Input: position = [1,2,3,4,7], m = 3
 * Output: 3
 * Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. 
 * The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
 * Example 2:
 * Input: position = [5,4,3,2,1,1000000000], m = 2
 * Output: 999999999
 * Explanation: We can use baskets 1 and 1000000000.
 * Constraints:
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * All integers in position are distinct.
 * 2 <= m <= position.length
 */
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
/**
 * While this template tries to minimize a maximum value, what we need is a template to maximize a minimum value. 
 * In fact, there's one such case discussed (with very much depth among @zhijun_liao and @youshen91 on this problem: 
 * https://leetcode.com/problems/divide-chocolate/ in this same thread on how we can utilize this same template 
 * (finding min of max values) to find (max of min values). The crux is (quoted), 
 * "The minimum k value satisfying condition(k) = True is the just maximum k value satisfying condition(k) = False plus 1. 
 * So, after the while loop, left is the minimum k satisfying condition(k) = True, 
 * and left - 1 is the maximum k satisfying condition(k) = False."
 * 
 * I used it this way.
 * We'd usually create a function to find whether we "Can" put m balls maintaining d (= mid) distance in the given positions. Then maximize it.
 * That's similar to, take a distance (=mid) and see if we "Can't" put m balls maintaining that distance. 
 * Minimize it (that's the template). Return left -1.
 */
public class MagneticForceBetweenTwoBalls {
	public int maxDistance(int[] position, int m) {
		Arrays.sort(position);
		int left=0;// min distance
		int right=position[position.length-1]+1;// max distance
		
        while(left < right) {
        	int mid=left+(right-left)/2;
        	if(canPut(mid, position, m)) right=mid;// can I put all the balls maintaining this distance??
        	else left=mid+1;
        }
        return left-1;
    }
	private boolean canPut(int d, int[] position, int m) {
		int count=0, lastp=0;
		for(int p: position) {
			if(lastp ==0 || (p-lastp) >=d) {
				lastp=p;
				count++;
			}
		}
		return count < m;
	}
	public static void main(String[] args) {
		MagneticForceBetweenTwoBalls instance= new MagneticForceBetweenTwoBalls();
		assertEquals(3,instance.maxDistance(new int[] {1,2,3,4,7},3));
		assertEquals(999999999,instance.maxDistance(new int[] {5,4,3,2,1,1000000000},2));
	}

}
