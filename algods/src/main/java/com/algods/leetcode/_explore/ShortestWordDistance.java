package com.algods.leetcode._explore;
/* 243. Shortest Word Distance
 * 
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
import java.util.*;
public class ShortestWordDistance {
	/* 02> Brute force
	 * O(n2)
	 * O(1) no extra space
	 */
	public int shortestDistance(String[] words, String word1, String word2) {
		int minDist=words.length;
		for(int i=0; i< words.length; i++) {
			if(words[i].equals(word1)) {
				for(int j=0; j< words.length; j++) {
					if(words[j].equals(word2)) {
						minDist=Math.min(minDist, Math.abs(i-j));
					}
				}
			}
		}
		return minDist;
	}
	/* 01> Brute force
	 * O(n2)
	 * O(n)
	 */
//	public int shortestDistance(String[] words, String word1, String word2) {
//		List<Integer> w1index= new ArrayList<>(), w2index= new ArrayList<>();
//		for(int i=0; i< words.length; i++) {
//			if(words[i].equals(word1)) w1index.add(i);
//			else if(words[i].equals(word2)) w2index.add(i);
//		}
//		Collections.sort(w1index);
//		Collections.sort(w2index);
//		int dist=Integer.MAX_VALUE;
//		for(int i=0; i< w1index.size(); i++)
//			for(int j=0; j< w2index.size(); j++) {
//				int d=Math.abs(w1index.get(i) - w2index.get(j));
//				if(d < dist) dist=d;
//			}
//		return dist;
//    }
}
