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
import static org.junit.Assert.assertEquals;
public class WordLadder {
	/**
	 * Approach 02: Bi-directional BFS
	 * "The idea behind bidirectional search is to run two simultaneous searches—one forward from
	 * the initial state and the other backward from the goal—hoping that the two searches meet inthe middle. 
	 * The motivation is that b^(d/2) + b^(d/2) is much less than b^d. b is branch factor, d is depth. "
	 * ----- section 3.4.6 in Artificial Intelligence - A modern approach by Stuart Russel and Peter Norvig
	 */
//	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//		Set<String> beginSet= new HashSet<>(), endSet= new HashSet<>(), dict=new HashSet<>(wordList);
//		int dist=1;
//		HashSet<String> visited= new HashSet<>();
//		beginSet.add(beginWord);
//		endSet.add(endWord);
//		while(!beginSet.isEmpty() && !endSet.isEmpty()) {
//			if(beginSet.size() > endSet.size()) {// swap
//				Set<String> tempSet=beginSet;
//				beginSet=endSet;
//				endSet=tempSet;
//			}
//			Set<String> temp= new HashSet<>();
//			for(String word: beginSet) {// this is the reason for swap so that we iterate min(beginSet, endSet) times
//				char[] chs= word.toCharArray();
//				for(int i=0; i< chs.length; i++) {
//					for(char c='a'; c<'z'; c++) {
//						char origChar=chs[i]; chs[i]=c;
//						String next=String.valueOf(chs);
//						if(endSet.contains(next)) return dist+1;// since we changed the chars, it's one level down
//						
//						if(!visited.contains(next) && wordList.contains(next)) {
//							temp.add(next);
//							visited.add(next);
//						}
//						chs[i]=origChar;
//					}
//				}
//			}
//			beginSet=temp;
//			dist+=1;
//		}
//		return 0;
//	}
	/**
	 * Approach 02: replacing the substring functions as they consume O(M)
	 * O(T) = O(M * N), O(Memory) = O(M) to keep the HashSet and Queue;
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int dist=1; HashSet<String> dict= new HashSet<>(wordList);
        Deque<String> queue= new ArrayDeque<>();
        queue.offerLast(beginWord);
        while(!queue.isEmpty()) {// Worst case: N times, Best case: 1 time
        	int size=queue.size();
        	for(int s=0; s< size; s++) {// If the outer loop is N times, this goes 1 time. If outer is 1 time, this is N times.
        		String current=queue.pollFirst();
        		if(current.equals(endWord)) return dist;
        		char[] chs= current.toCharArray();
        		for(int l=0; l< chs.length; l++) {// M times
        			char origChar=chs[l];
        			for(char c='a'; c<= 'z'; c++) {
        				chs[l]=c;
        				String next=String.valueOf(chs);
        				if(dict.remove(next)) queue.offer(next);
        			}
        			chs[l]=origChar;
        		}
        	}
        	dist+=1;
        }
        return 0;
    }
	/**
	 * Approach 01: BFS as 'production sequence' paradigm
	 * O(T) ? -> if the word length is M, we're iterating length: 0 -> M ( x 26) in each iteration.
	 * if N = number of word. worst case when each word has only one neighbor/ next word. the bfs loop will iterate for N times.
	 * 
	 * O(T) should be O(M^2 * N) as the substring() takes O(M)
	 * 
	 */
//	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int dist=1; HashSet<String> dict= new HashSet<>(wordList);
//        Deque<String> queue= new ArrayDeque<>();
//        queue.offerLast(beginWord);
//        while(!queue.isEmpty()) {// Worst case: N times, Best case: 1 time
//        	int size=queue.size();
//        	for(int s=0; s< size; s++) {// If the outer loop is N times, this goes 1 time. If outer is 1 time, this is N times.
//        		String current=queue.pollFirst();
//        		if(current.equals(endWord)) return dist;
//        		int len=current.length();
//        		for(int l=0; l< len; l++) {// M times
//        			String first= (l==0)? "": current.substring(0,l);// substring takes O(M)
//        			String last=  (l== len-1)? "": current.substring(l+1);//
//        			for(int i=0; i< 26; i++) {
//        				char mid=(char)('a'+i);
//        				String next=first+mid+last;
//        				if(dict.remove(next)) {
//        					System.out.println(next);
//        					queue.offerLast(next);
//        				}
//        			}
//        		}
//        	}
//        	dist+=1;
//        }
//        return 0;
//    }
	public static void main(String[] args) {
		WordLadder wl= new WordLadder();
		assertEquals(10,wl.ladderLength("ymain", "oecij", 
				Arrays.asList(new String[] {"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"})));
	}

}
