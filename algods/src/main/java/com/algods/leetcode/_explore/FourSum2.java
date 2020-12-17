package com.algods.leetcode._explore;

import java.util.HashMap;
import java.util.Iterator;
public class FourSum2 {
	/* Approach 01: Brute force O(n2) O(n2) */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Long,Integer> cdhm=new HashMap<>();
        HashMap<Long,Integer> abhm=new HashMap<>();
        for(int c=0; c< C.length; c++)
        	for(int d=0; d< D.length; d++) {
        		long key=-1* ((long)C[c]+(long)D[d]);
        		cdhm.put(key, cdhm.getOrDefault(key, 0)+1);
        	}
        
        for(int a=0; a< A.length; a++)
        	for(int b=0; b< B.length; b++) {
        		long key=(long)A[a]+(long)B[b];
        		abhm.put(key, abhm.getOrDefault(key, 0)+1);
        	}
        int count=0;
        
        Iterator<Long> it=abhm.keySet().iterator();
        while(it.hasNext()) {
        	long ab=it.next();
        	count+=abhm.get(ab) * cdhm.getOrDefault(ab, 0);
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
