package com.algods.leetcode;

public class MinDelCost {
    public int minCost(String s, int[] cost) {
    	int result=0;
        if(s.length() > 1) {
        	for(int i=0; i< s.length()-1; ) {
        		char thisChar=s.charAt(i);
        		if(thisChar == s.charAt(i+1)) {// starting of a duplicate block
        			int maxCost=cost[i];
        			int maxIndex=i;
        			int j;
        			for(j=i+1; j< s.length() && s.charAt(j)==thisChar; j++) {
        				if(cost[j] > maxCost) {
        					maxCost=cost[j];
        					maxIndex=j;
        				}
        			}
        			for(int k=i; k< j; k++) {
        				if(k != maxIndex) result+=cost[k];
        			}
        			i=j;
        		}else {
        			i++;
        		}
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		MinDelCost instance= new MinDelCost();
//		System.out.println(instance.minCost("abc", new int[]{1,2,3}));//0
//		System.out.println(instance.minCost("a", new int[]{1}));// 0
//		System.out.println(instance.minCost("abaac", new int[]{1,2,3,4,5}));
		System.out.println(instance.minCost("aabaa", new int[]{1,2,3,4,1}));
//		System.out.println(instance.minCost("abc", new int[]{1,2,3}));
//		System.out.println(instance.minCost("abc", new int[]{1,2,3}));
	}

}
