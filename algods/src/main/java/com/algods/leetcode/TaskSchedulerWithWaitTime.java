package com.algods.leetcode;

import java.util.Arrays;

/*
 * You are given a char array representing tasks CPU need to do. 
 * It contains capital letters A to Z where each letter represents a different task. 
 * Tasks could be done without the original order of the array. 
 * Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 * You need to return the least number of units of times that the CPU will take to finish all the given tasks.
 * 
 *  *Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
 *
 *Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 *
 * Constraints
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
// frequency[25] denotes repeat time of F (F is the max-frequency char)
// Each chunk, FXXXX has length (n+1)
// The last chunk doesn't need to be fulfilled
// so, length (frequency[25] -1) times of chunk => (f[25] -1)*(n+1) PLUS
// last remaining would be the f[25] term and if there's any other of same frequency
public class TaskSchedulerWithWaitTime {
    public int leastInterval(char[] tasks, int n) {
        if(n <= 0) return tasks.length;
        // let's get the frequency of each task
        int[] frequencies= new int[26];
        for(char c: tasks) {
        	frequencies[c-'A']++;
        }
        // Sort
        Arrays.sort(frequencies);
        // how many has max frequencies?
        int i = 25;
        while( i>=0 && frequencies[i] == frequencies[25]) i--;
        
        return Math.max(tasks.length,(frequencies[25] -1)*(n+1)+(25 -i));// Math.max is super-important
    }
	public static void main(String[] args) {
		TaskSchedulerWithWaitTime instance= new TaskSchedulerWithWaitTime();
		char[] tasks= {'A','A','A','B','B','B'};
		int pause=0;
		System.out.println(instance.leastInterval(tasks, pause));// 6
		pause=2;
		System.out.println(instance.leastInterval(tasks, pause));// 8
		char[] tasks1= {'A','A','A','A','A','A','B','C','D','E','F','G'};
		System.out.println(instance.leastInterval(tasks1, pause));// 16
		System.out.println(instance.leastInterval(tasks1, 1));// 12
		char[] tasks2= {'A','A','A'};
		System.out.println(instance.leastInterval(tasks2, 1));// 5
	}

}
