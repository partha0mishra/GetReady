package com.leetcode.contest;

import java.util.*;
public class BestTeamNoConflict {
	public int bestTeamScore(int[] scores, int[] ages) {
        int[][] scoreAges=new int[scores.length][2];
        for(int i=0; i< scores.length; i++) scoreAges[i]=new int[] {scores[i],ages[i]};
        Arrays.sort(scoreAges, (s1,s2) -> compare(s1,s2));
        int max=0, local=0, age=1001,score=0;
        for(int i=0; i< scoreAges.length; i++) {
        	if(scoreAges[i][1] > age ) {
        		// don't do anything
        	}else local+=scoreAges[i][0];
            System.out.println(scoreAges[i][0]+" "+scoreAges[i][1]+" "+local+" "+max);
        	score=scoreAges[i][0];
        	age=scoreAges[i][1];
        }
        return Math.max(max,local);
    }
	
	private int compare(int[] s1, int[] s2) {
		int diff=Integer.compare(s2[0], s1[0]);
		if(diff == 0) {
			return Integer.compare(s2[1], s1[1]);
		}
		return diff;
	}

	public static void main(String[] args) {
		BestTeamNoConflict instance = new BestTeamNoConflict();
		instance.bestTeamScore(new int[] {1,3,5,10,15}, new int[] {1,2,3,4,5});
	}
}
