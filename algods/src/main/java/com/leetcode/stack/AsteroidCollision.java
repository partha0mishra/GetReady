package com.leetcode.stack;
/**
 * 735. Asteroid Collision
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
import java.util.*;
public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Deque<Integer> stack= new ArrayDeque<>();
		for(int a: asteroids) {
			boolean destroyed=false;
			if(a < 0) {
				while(!stack.isEmpty()) {
					if(stack.peek() < 0) {
						stack.offerFirst(a);
						break;
					}
					else if(stack.peek() +a > 0) {
						break;
					}
					else if(stack.peek() +a == 0) {
						stack.pollFirst();
						destroyed=true;
						break;// both vanishes
					}
					else stack.pollFirst();// pop out the existing one
				}
				if(stack.isEmpty() && !destroyed) stack.offerFirst(a);// 
			}else stack.offerFirst(a);// a Positive
		}
		int[] result= new int[stack.size()];
		int i=stack.size() -1;
		while(i>=0) result[i--]=stack.pollFirst();
		return result;
	}
	/* Approach 01: Queue 
	 * 
	 */
//	public int[] asteroidCollision(int[] asteroids) {
//        Deque<Integer> list= new ArrayDeque<>();
//        for(int a: asteroids) {
//        	if(a < 0) {
//        		boolean survived=true;
//        		while(!list.isEmpty() && list.getLast() >= 0) {
//        			int t=list.removeLast();
//        			if(t+a ==0) {
//        				survived=false;
//        				break;// none survived
//        			}
//        			else if(t+a > 0) {
//        				list.addLast(t);// t survived. a destroyed
//        				survived=false;
//        				break;
//        			}
//        		}
//        		if(survived) list.addLast(a);// winner
//        	}else list.addLast(a);// positive number
//        }
//                
//        int[] result=new int[list.size()];
//        for(int i=0; i< result.length; i++) result[i]=list.removeFirst();
////        for(int i: result) System.out.println(i);
//        return result;
//    }
	public static void main(String[] args) {
		AsteroidCollision instance= new AsteroidCollision();
		printArray(instance.asteroidCollision(new int[] {5,10,-5}));
		printArray(instance.asteroidCollision(new int[] {8,-8}));
		printArray(instance.asteroidCollision(new int[] {10,2,-5}));
		printArray(instance.asteroidCollision(new int[] {-2,-1,1,2}));
	}
	public static void printArray(int[] result) {
		for(int i: result) System.out.printf("%3d",i);
		System.out.println();
	}
}
