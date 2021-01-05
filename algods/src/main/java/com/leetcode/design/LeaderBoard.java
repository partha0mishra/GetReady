package com.leetcode.design;
/**
 * 1244. Design A Leaderboard
 * Design a Leaderboard class, which has 3 functions:

addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
top(K): Return the score sum of the top K players.
reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.
Initially, the leaderboard is empty.

 

Example 1:

Input: 
["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
[[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
Output: 
[null,null,null,null,null,null,73,null,null,null,141]

Explanation: 
Leaderboard leaderboard = new Leaderboard ();
leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
leaderboard.top(1);           // returns 73;
leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
 

Constraints:

1 <= playerId, K <= 10000
It's guaranteed that K is less than or equal to the current number of players.
1 <= score <= 100
There will be at most 1000 function calls.
 */
import java.util.*;
class Leaderboard {
	/**
	 * Player(id, score) - comparable - descending on score
	 * HashMap<playerId, Player(id, score)> : players
	 * TreeSet<Player(id, score)> : leaders
	 */
	class Player implements Comparable<Player>{
		int id, score;
		public Player(int i, int s) {this.id=i; this.score=s;}
		public void reset() {this.score=0;}
		public void add(int s) {this.score+=s;}
		@Override
		public int compareTo(Player p) {
			int diff=Integer.compare(p.score, this.score);// reversing order
			return diff==0? Integer.compare(this.id, p.id): diff;
		}
	}
	TreeSet<Player> leaders;
	HashMap<Integer, Player> players; 
	public Leaderboard() {
		leaders= new TreeSet<Player>();
		players= new HashMap<Integer, Player>();
	}

	public void addScore(int playerId, int score) {
		int oldScore=0;
		if(players.containsKey(playerId)) {
			leaders.remove(players.get(playerId));
			oldScore+=players.get(playerId).score;
		}
		Player newP=new Player(playerId, oldScore+score);
		players.put(playerId, newP);
		leaders.add(newP);
	}

	public int top(int K) {
		Iterator<Player> it= leaders.iterator();
		int sum=0;
		for(int i=0; i<K && i< leaders.size(); i++) {
			sum+=it.next().score;
		}
		return sum;
	}

	public void reset(int playerId) {
		if(players.containsKey(playerId)) {
			leaders.remove(players.get(playerId));
			players.remove(playerId);
		}
	}

	/**
	 * Your Leaderboard object will be instantiated and called as such:
	 * Leaderboard obj = new Leaderboard();
	 * obj.addScore(playerId,score);
	 * int param_2 = obj.top(K);
	 * obj.reset(playerId);
	 */
	public static void main(String[] args) {
		Leaderboard lb = new Leaderboard();
		lb.addScore(1, 73);
		lb.addScore(2, 56);
		lb.addScore(3, 39);
		lb.addScore(4, 51);
		lb.addScore(5, 4);
		System.out.println(lb.top(1));
		lb.reset(1);
		lb.reset(2);
		lb.addScore(2, 51);
		System.out.println(lb.top(3));
	}

}
