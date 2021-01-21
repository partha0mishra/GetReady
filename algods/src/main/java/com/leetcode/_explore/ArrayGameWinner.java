package com.leetcode;
/*
 * WEEKLY Contest 200
 * Given an integer array arr of distinct integers and an integer k.

A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]). In each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains at position 0 and the smaller integer moves to the end of the array. The game ends when an integer wins k consecutive rounds.

Return the integer which will win the game.

It is guaranteed that there will be a winner of the game.
 *
 * Input: arr = [2,1,3,5,4,6,7], k = 2
Output: 5
Explanation: Let's see the rounds of the game:
Round |       arr       | winner | win_count
  1   | [2,1,3,5,4,6,7] | 2      | 1
  2   | [2,3,5,4,6,7,1] | 3      | 1
  3   | [3,5,4,6,7,1,2] | 5      | 1
  4   | [5,4,6,7,1,2,3] | 5      | 2
So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.
 *
 * Input: arr = [3,2,1], k = 10
Output: 3
Explanation: 3 will win the first 10 rounds consecutively.
 * 
 * Input: arr = [1,9,8,2,3,7,6,4,5], k = 7
Output: 9
 * 
 * Input: arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
Output: 99
 * 
 * Constraints:
 * 2 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * arr contains distinct integers.
 * 1 <= k <= 10^9
 */
import java.util.*;
public class ArrayGameWinner {
    public int getWinner(int[] arr, int k) {
    	Queue<Integer> numsQueue=new LinkedList<Integer>();
    	for(int i=0; i<arr.length; i++) {
    		numsQueue.add(arr[i]);
    	}
    	int zeroeth=numsQueue.remove();
    	int wins=0;// Zeroeth element wins only after first comparison
    	int length=numsQueue.size();
    	while(length-- > 0) {
    		int first=numsQueue.remove();// we have to remove it anyway
    		if(zeroeth > first) {
    			numsQueue.add(first);// loser goes to the end
    			wins++;// Zeroeth adds to wins tally
    		}else {
    			wins=1;// first win for the New element
    			numsQueue.add(zeroeth);// loser goes to the end
    			zeroeth=first;// new Zeroeth
    		}
    		if(wins == k) return zeroeth;
    	}
    	return zeroeth;
    }
	public static void main(String[] args) {
		ArrayGameWinner instance= new ArrayGameWinner();
		int[] arr01= {2,1,3,5,4,6,7};
		System.out.println(instance.getWinner(arr01, 2));
		int[] arr02= {3,2,1};
		System.out.println(instance.getWinner(arr02, 10));
		int[] arr03= {1,9,8,2,3,7,6,4,5};
		System.out.println(instance.getWinner(arr03, 7));
		int[] arr04= {1,11,22,33,44,55,66,77,88,99};
		System.out.println(instance.getWinner(arr04, 1000000000));
	}

}
