package com.algods.leetcode.greedy;
/* 1217. Minimum Cost to Move Chips to The Same Position
 * 
 * We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:

position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.
 * */
public class MinCostMoveChips {
	/* Inuition: All even or all odd results in 0 cost
	 * */
	public int minCostToMoveChips(int[] position) {
        int even=0, odd=0;
        for(int p: position) {
        	if(p%2 ==0) even+=1;
        	else odd+=1;
        }
        return Math.min(even, odd);
    }
}
