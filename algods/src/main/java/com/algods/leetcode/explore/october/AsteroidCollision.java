package com.algods.leetcode.explore.october;
/* Asteroid Collision
 * We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
Example 4:

Input: asteroids = [-2,-1,1,2]
Output: [-2,-1,1,2]
Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
 

Constraints:

1 <= asteroids <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */
import java.util.Deque;
import java.util.ArrayDeque;
public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> list= new ArrayDeque<>();
        for(int a: asteroids) {
        	if(a < 0) {
        		boolean survived=true;
        		while(!list.isEmpty() && list.getLast() >= 0) {
        			int t=list.removeLast();
        			if(t+a ==0) {
        				survived=false;
        				break;// none survived
        			}
        			else if(t+a > 0) {
        				list.addLast(t);// t survived. a destroyed
        				survived=false;
        				break;
        			}
        		}
        		if(survived) list.addLast(a);// winner
        	}else list.addLast(a);// positive number
        }
                
        int[] result=new int[list.size()];
        for(int i=0; i< result.length; i++) result[i]=list.removeFirst();
//        for(int i: result) System.out.println(i);
        return result;
    }
	public static void main(String[] args) {
		AsteroidCollision instance= new AsteroidCollision();
		System.out.println(instance.asteroidCollision(new int[] {5,10,-5}));
		System.out.println(instance.asteroidCollision(new int[] {8,-8}));
		System.out.println(instance.asteroidCollision(new int[] {10,2,-5}));
		System.out.println(instance.asteroidCollision(new int[] {-2,-1,1,2}));
	}

}
