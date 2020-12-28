package com.leetcode.bfs;
/* 752. Open the Lock
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

 

Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:

Input: deadends = ["0000"], target = "8888"
Output: -1
 

Constraints:

1 <= deadends.length <= 500
deadends[i].length == 4
target.length == 4
target will not be in the list deadends.
target and deadends[i] consist of digits only.
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class OpenTheLock {
	/* BFS with Queue as the usual pattern 
	 * O(Time) = N^2 + A^N + D  => N= length= 4, A=number of digits= 10 (0-9), D= deadEnd Size 
	 * O(space) = A^N (for queue) + D (deadEnd set) */
	public int openLock(String[] deadends, String target) {
		String start="0000";
		HashSet<String> considered=new HashSet<>(Arrays.asList(deadends));
		Queue<String> q=new ArrayDeque<>();
		q.offer(start);
		int count=-1;
		while(!q.isEmpty()) {
			int size=q.size();
			count+=1;
			for(int i=0; i< size; i++) {
				String e=q.poll();
//				System.out.printf("Level: %3d %s \n", count,e);
				if(e.equals(target)) return count;
				if(!considered.add(e)) continue;
				for(int j=0; j< 4; j++) {
					String eStart= j==0? "": e.substring(0,j);
					char c1= e.charAt(j) == '9'? '0': (char)(e.charAt(j)+1);
					char c2= e.charAt(j) == '0'? '9': (char)(e.charAt(j)-1);
					String eEnd=   j==3? "": e.substring(j+1);
					q.offer(eStart+c1+eEnd);
					q.offer(eStart+c2+eEnd);
				}
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		assertEquals(-1,new OpenTheLock().openLock(new String[] {"0000"}, "8888"));
		assertEquals(6,new OpenTheLock().openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
		assertEquals(1,new OpenTheLock().openLock(new String[] {"8888"}, "0009"));// REVERSE
		assertEquals(-1,new OpenTheLock().openLock(new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
	}

}
