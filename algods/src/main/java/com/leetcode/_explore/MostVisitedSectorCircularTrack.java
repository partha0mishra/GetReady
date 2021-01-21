package com.leetcode;
/*
 * Given an integer n and an integer array rounds. We have a circular track which consists of n sectors labeled from 1 to n. A marathon will be held on this track, the marathon consists of m rounds. The ith round starts at sector rounds[i - 1] and ends at sector rounds[i]. For example, round 1 starts at sector rounds[0] and ends at sector rounds[1]

Return an array of the most visited sectors sorted in ascending order.

Notice that you circulate the track in ascending order of sector numbers in the counter-clockwise direction (See the first example).

 

Example 1:


Input: n = 4, rounds = [1,3,1,2]
Output: [1,2]
Explanation: The marathon starts at sector 1. The order of the visited sectors is as follows:
1 --> 2 --> 3 (end of round 1) --> 4 --> 1 (end of round 2) --> 2 (end of round 3 and the marathon)
We can see that both sectors 1 and 2 are visited twice and they are the most visited sectors. Sectors 3 and 4 are visited only once.
Example 2:

Input: n = 2, rounds = [2,1,2,1,2,1,2,1,2]
Output: [2]
Example 3:

Input: n = 7, rounds = [1,3,5,7]
Output: [1,2,3,4,5,6,7]
 

Constraints:

2 <= n <= 100
1 <= m <= 100
rounds.length == m + 1
1 <= rounds[i] <= n
rounds[i] != rounds[i + 1] for 0 <= i < m
 */
import java.util.*;
import java.util.stream.Collectors;
public class MostVisitedSectorCircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
    	HashMap<Integer,Integer> result= new HashMap<Integer,Integer>();
        int start=rounds[0];
        result.put(start, 1);
        int max=0;
        for(int x=1; x< rounds.length; x++) {
        	int end=rounds[x];
        	for(int i: getSectors(start,end,n)) {
        		int newVal=result.getOrDefault(i, 0)+1;
        		result.put(i, newVal);
        		if(newVal > max) max=newVal;
//        		if(i==n) i=1;
        	}
        	start=end;
        }
        ArrayList<Integer> res= new ArrayList<Integer>();
        Iterator<Integer> it= result.keySet().iterator();
        while(it.hasNext()) {
        	Integer nxt= it.next();
        	if(result.get(nxt) == max) res.add(nxt);
        }
        Collections.sort(res);
        
        return res;
    }
	private int[] getSectors(int start, int end, int numSectors) {
		int size= (start > end)? (numSectors - start + end): (end - start);
		int[] result= new int[size];
		for(int i=0, val=start+1; i<size; i++) {
			if(val > numSectors) val=1;
			result[i]=val++;
		}
		return result;
	}
	public static void main(String[] args) {
		MostVisitedSectorCircularTrack instance = new MostVisitedSectorCircularTrack();
		System.out.println(instance.mostVisited(4, new int[]{1,3,1,2}));
		System.out.println(instance.mostVisited(4, new int[]{}));

	}

}
