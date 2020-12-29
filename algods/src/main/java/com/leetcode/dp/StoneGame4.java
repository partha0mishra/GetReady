package com.leetcode.dp;
/* Stone Game IV
 * Alice and Bob take turns playing a game, with Alice starting first.

Initially, there are n stones in a pile.  On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.

Also, if a player cannot make a move, he/she loses the game.

Given a positive integer n. Return True if and only if Alice wins the game otherwise return False, assuming both players play optimally.

 

Example 1:

Input: n = 1
Output: true
Explanation: Alice can remove 1 stone winning the game because Bob doesn't have any moves.
Example 2:

Input: n = 2
Output: false
Explanation: Alice can only remove 1 stone, after that Bob removes the last one winning the game (2 -> 1 -> 0).
Example 3:

Input: n = 4
Output: true
Explanation: n is already a perfect square, Alice can win with one move, removing 4 stones (4 -> 0).
Example 4:

Input: n = 7
Output: false
Explanation: Alice can't win the game if Bob plays optimally.
If Alice starts removing 4 stones, Bob will remove 1 stone then Alice should remove only 1 stone and finally Bob removes the last one (7 -> 3 -> 2 -> 1 -> 0). 
If Alice starts removing 1 stone, Bob will remove 4 stones then Alice only can remove 1 stone and finally Bob removes the last one (7 -> 6 -> 2 -> 1 -> 0).
Example 5:

Input: n = 17
Output: false
Explanation: Alice can't win the game if Bob plays optimally.
 

Constraints:

1 <= n <= 10^5
 */
public class StoneGame4 {
	/* Approach 02: by khaufnak*/
//	Boolean[] dp = new Boolean[100000 + 1];
//    public boolean winnerSquareGame(int n) {
//        if (dp[n] != null) {
//            return dp[n];
//        }
//        Boolean answer = false;
//        for (int move = 1; n - move * move >= 0; ++move) {
//            if (n - move * move == 0) {
//                // current player won
//                answer = true;
//                break;
//            } else {
//                // Hand over turn to other player.
//                // If there is any subtree, where the other person loses. We use that subtree.
//                // 1. OR means we choose any winning subtree.
//                // 2. ! in !solve(n - move*move, dp) means we hand over turn to other player after reducing n by move*move
//                answer |= !winnerSquareGame(n - move * move);
//            }
//        }
//        return dp[n] = answer;
//    }
	/* Approach 01: Copied from Lee215*/
	public boolean winnerSquareGame(int n) {
		boolean[] dp= new boolean[n+1];
		for(int i=1; i<=n; i++) {
			for(int k=1; k*k <= i; k++) {
				if(!dp[i-k*k]) {
					dp[i]= true;
					break;
				}
			}
		}
		return dp[n];
    }
	public static void main(String[] args) {
		StoneGame4 instance= new StoneGame4();
		instance.winnerSquareGame(10000);
	}
}
