package com.leetcode._explore;
/*
 * Minimum Deletion Cost to Avoid Repeating Letters
 * Given a string s and an array of integers cost where cost[i] is the cost of deleting the character i in s.

Return the minimum cost of deletions such that there are no two identical letters next to each other.

Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change.

 

Example 1:

Input: s = "abaac", cost = [1,2,3,4,5]
Output: 3
Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
Example 2:

Input: s = "abc", cost = [1,2,3]
Output: 0
Explanation: You don't need to delete any character because there are no identical letters next to each other.
Example 3:

Input: s = "aabaa", cost = [1,2,3,4,1]
Output: 2
Explanation: Delete the first and the last character, getting the string ("aba").
 

Constraints:

s.length == cost.length
1 <= s.length, cost.length <= 10^5
1 <= cost[i] <= 10^4
s contains only lowercase English letters.

 */
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
		System.out.println(instance.minCost("abc", new int[]{1,2,3}));//0
		System.out.println(instance.minCost("a", new int[]{1}));// 0
		System.out.println(instance.minCost("abaac", new int[]{1,2,3,4,5}));//3
		System.out.println(instance.minCost("aabaa", new int[]{1,2,3,4,1}));//2
	}

}
