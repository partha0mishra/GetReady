package com.algods.leetcode._explore;
/* Pairs of Songs With Total Durations Divisible by 60
 * You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 

Constraints:

1 <= time.length <= 6 * 104
1 <= time[i] <= 500
* Hints:
* We only need to consider each song length modulo 60.
* We can count the number of songs with (length % 60) equal to r, and store that in an array of size 60.
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class SongsDurationDivisibleBy60 {
	/* Count[ num % 60] way.
	 * O(n) O(1) */
	public static final Integer SIXTY=60;
	public int numPairsDivisibleBy60(int[] time) {
		int[] modCounts= new int[SIXTY];
        for(int t: time) {
        	int mod=t%SIXTY;
        	modCounts[mod]+=1;
        }
        int result=modCounts[0]*(modCounts[0] -1)/2;// these are already n*60 durations. number of pairs= n(n-1)/2
        result+=modCounts[30]*(modCounts[30]-1)/2;// n*60 + 30 mins. number of pairs= n(n-1)/2
        for(int i=1; i< SIXTY/2; i++) {
        	int x=modCounts[i];
        	int y=modCounts[SIXTY-i];
        	result+=x*y;
        }
        return result;
    }
	public static void main(String[] args) {
		assertEquals(3,new SongsDurationDivisibleBy60().numPairsDivisibleBy60(new int[] {30,20,150,100,40}));
		assertEquals(3,new SongsDurationDivisibleBy60().numPairsDivisibleBy60(new int[] {60,60,60}));
	}

}
