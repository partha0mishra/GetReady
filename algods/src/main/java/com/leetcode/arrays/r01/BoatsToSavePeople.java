package com.leetcode.arrays.r01;
// Just for the COUNT SORT
import java.util.Arrays;

/** TODO Anki
 * 881. Boats to Save People
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
import static org.junit.Assert.assertEquals;
public class BoatsToSavePeople {
	/**
	 * Approach 02:
	 * Since the sorting took O(N logN), replace it with count sort
	 * O(N)/ O(N)
	 */
	public int numRescueBoats(int[] people, int limit) {
       int[] count=new int[limit+1];// to keep the count
       for(int p: people) count[p]+=1;// populate counts [1,1,2,2,2,3,3,4,5,5,3,3] becomes [0, 2, 3, 4, 1, 2]
       for(int i=1; i< count.length; i++) count[i]+=count[i-1];// cumulative counts [0, 2, 5, 9, 10, 12] 
       // means 1 should be at position 0 and 1; 2 should be at 2, 3, 4;
//       for(int c: count) System.out.println(c);
       int[] sorted= new int[people.length];
       for(int i=0; i< people.length; i++) sorted[count[people[i]-1]++]=people[i];// now it's sorted. notice people[i]-1
//       for(int s: sorted) System.out.println(s);
       int left=0, right=people.length-1, boats=0;// same as Approach 01 from here on.
       while(left <= right) {
       	int delta=limit-sorted[right];
       	if(sorted[left]<=delta) left+=1;
       	boats+=1;
       	right-=1;
       }
       return boats;
    }
	/**
	 * Approach 01:
	 * Sort the array, take from right and if enough space left, take from left
	 * O(N logN)/ O(1)
	 */
//	public int numRescueBoats(int[] people, int limit) {
//        int left=0, right=people.length-1, boats=0;
//        Arrays.sort(people);// O(N logN)
//        while(left <= right) {// O(N)
//        	int delta=limit-people[right];// space left
//        	if(people[left]<=delta) left+=1;// small one can be accomodated
//        	boats+=1;// in any case
//        	right-=1;// in any case
//        }
//        return boats;
//    }
	public static void main(String[] args) {
//		assertEquals(1,new BoatsToSavePeople().numRescueBoats(new int[] {1}, 5));
//		assertEquals(1,new BoatsToSavePeople().numRescueBoats(new int[] {1,2}, 5));
//		assertEquals(1,new BoatsToSavePeople().numRescueBoats(new int[] {1,4}, 5));
//		assertEquals(2,new BoatsToSavePeople().numRescueBoats(new int[] {1,5}, 5));
//		assertEquals(2,new BoatsToSavePeople().numRescueBoats(new int[] {1,2,5}, 5));
		assertEquals(7,new BoatsToSavePeople().numRescueBoats(new int[] {1,1,2,2,2,3,3,4,5,5,3,3}, 5));
	}
}
