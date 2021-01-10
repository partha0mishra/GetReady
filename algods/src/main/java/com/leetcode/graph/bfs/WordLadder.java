package com.leetcode.graph.bfs;
/** TODO Anki
 * Word Ladder
 * Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 

Constraints:

1 <= beginWord.length <= 100
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique.
 */
import java.util.*;
public class WordLadder {
	/**
	 * Approach 01: BFS as 'production sequence' paradigm
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int dist=0; HashSet<String> dict= new HashSet<>(wordList);
        Deque<String> queue= new ArrayDeque<>();
        queue.offerLast(beginWord);
        while(!queue.isEmpty()) {
        	int size=queue.size();
        	for(int s=0; s< size; s++) {
        		String current=queue.pollFirst();
        		if(current.equals(endWord)) return dist;
        		int len=current.length();
        		for(int l=0; l< len; l++) {
        			String first= (l==0)? "": current.substring(0,l);
        			String last=  (l== len-1)? "": current.substring(l+1);
        			for(int i=0; i< 26; i++) {
        				char mid=(char)('a'+i);
        				String next=first+mid+last;
        				if(dict.remove(next)) queue.offerLast(next);
        			}
        		}
        	}
        	dist+=1;
        }
        return dist;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
