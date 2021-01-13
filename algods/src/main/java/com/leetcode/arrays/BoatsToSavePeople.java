package com.leetcode.arrays;

import java.util.Arrays;

/** TODO Anki
 * Boats to Save People
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)
Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
Note:

1 <= people.length <= 50000
1 <= people[i] <= limit <= 30000
 */
public class BoatsToSavePeople {
	/**
	 * Approach 01:
	 * Sort the array, take from right and if enough space left, take from left
	 * O(N logN)/ O(1)
	 */
	public int numRescueBoats(int[] people, int limit) {
        int left=0, right=people.length-1, boats=0;
        Arrays.sort(people);
        while(left <= right) {
        	int delta=limit-people[right];
        	if(people[left]<=delta) left+=1;
        	boats+=1;
        	right-=1;
        }
        return boats;
    }
	public static void main(String[] args) {
		assert 1==new BoatsToSavePeople().numRescueBoats(new int[] {1}, 5);
		assert 1==new BoatsToSavePeople().numRescueBoats(new int[] {1,2}, 5);
		assert 1==new BoatsToSavePeople().numRescueBoats(new int[] {1,4}, 5);
		assert 2==new BoatsToSavePeople().numRescueBoats(new int[] {1,5}, 5);
		assert 2==new BoatsToSavePeople().numRescueBoats(new int[] {1,2,5}, 5);
		assert 2==new BoatsToSavePeople().numRescueBoats(new int[] {1,2,4,5}, 5);
	}
}
