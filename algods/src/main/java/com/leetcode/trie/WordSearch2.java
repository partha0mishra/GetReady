package com.leetcode.trie;
/**
 * 212. Word Search II
 * Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
 */
import java.util.*;
public class WordSearch2 {
	/** 
	 * Approach 01: keeping words in a trie and then searching using backtracking
	 */
	class TrieNode{
		TrieNode[] letters; boolean end;
		public TrieNode() {letters=new TrieNode[26];end=false;}
	}
	class Trie{
		TrieNode allWords;
		public Trie() {allWords=new TrieNode();}
		public void add(String word) {
			TrieNode current=allWords;
			for(char c: word.toCharArray()) {
				if(current.letters[c-'a'] == null)
					current.letters[c-'a']=new TrieNode();
				current=current.letters[c-'a'];
			}
			current.end=true;
		}
		public boolean search(String word) {
			TrieNode current=allWords;
			for(char c: word.toCharArray()) {
				if(current.letters[c-'a'] == null) return false;
				current=current.letters[c-'a'];
			}
			return current.end;
		}
		public boolean startsWith(String word) {
			TrieNode current=allWords;
			for(char c: word.toCharArray()) {
				if(current.letters[c-'a'] == null) return false;
				current=current.letters[c-'a'];
			}
			return true;// this is just a prefix search - used for pruning
		}
	}
	public List<String> findWords(char[][] board, String[] words) {
        List<String> result=new ArrayList<>();
        int rows=board.length, cols=board[0].length;
        Trie myTrie= new Trie();
        for(String word: words) {
        	myTrie.add(word);// all words added
        }
        for(int row=0; row< rows; row++)
        	for(int col=0; col< cols; col++) {
//        		System.out.println("starting with "+row+" "+col+" "+board[row][col]);
//        		if(myTrie.startsWith(""+board[row][col])) 
        		if(myTrie.allWords.letters[board[row][col] -'a'] != null)// trying the search myself
        		{
//        			System.out.println("starting with "+row+" "+col+" "+board[row][col]);
        			HashSet<Integer> visited= new HashSet<>();
        			visited.add(100*row+col);
        			backtrack(row,col,rows,cols,result,""+board[row][col]
        					, /*myTrie*/ myTrie.allWords.letters[board[row][col]-'a'] // let me carry only the relevant node
        					, visited, board);// row no, col no, rows, cols, result, partial, trie, visited
        		}
        	}
        return result;
    }
	int[][] dirs= {{0,1},{-1,0},{0,-1},{1,0}};
	// this time, walking through the Trie as well
	private void backtrack(int row, int col, int rows, int cols, List<String> result, String soFar, TrieNode trieNode,
			HashSet<Integer> visited, char[][] board) {
		if(trieNode.end && !result.contains(soFar)) result.add(soFar);
		for(int[] dir: dirs) {
			int newRow=row+dir[0], newCol=col+dir[1];
			if(newRow >=0 && newCol >=0 && newRow < rows && newCol < cols 
					&& !visited.contains(100*newRow+newCol) && trieNode.letters[board[newRow][newCol]-'a'] != null) {
//				System.out.println(row+" "+col+" "+dir[0]+" "+dir[1]+" "+newRow+" "+newCol+" "+soFar+board[newRow][newCol]);
				visited.add(100*newRow+newCol);
				backtrack(newRow, newCol, rows, cols, result, soFar+board[newRow][newCol], trieNode.letters[board[newRow][newCol]-'a'], visited, board);
				visited.remove(100*newRow+newCol);
			}
		}
		// what if I remove the trieNode if it doesn't have a child
		// since we don't need to use the same word anymore, also set the end to false
		trieNode.end=false;
		for(TrieNode tn: trieNode.letters) {
			if(tn != null) return;
		}
		trieNode=null;// no child
	}
	private void backtrack(int row, int col, int rows, int cols, List<String> result, String soFar, Trie myTrie, HashSet<Integer> visited, char[][] board) {
		if(myTrie.search(soFar) && !result.contains(soFar)) {result.add(soFar); /*System.out.println(soFar);*/}
		for(int[] dir: dirs) {
			int newRow=row+dir[0], newCol=col+dir[1];
			if(newRow >=0 && newCol >=0 && newRow < rows && newCol < cols 
					&& !visited.contains(100*newRow+newCol) && myTrie.startsWith(soFar+board[newRow][newCol])) {
//				System.out.println(row+" "+col+" "+dir[0]+" "+dir[1]+" "+newRow+" "+newCol+" "+soFar+board[newRow][newCol]);
				visited.add(100*newRow+newCol);
				backtrack(newRow, newCol, rows, cols, result, soFar+board[newRow][newCol], myTrie, visited, board);
				visited.remove(100*newRow+newCol);
			}
		}
	}
	public static void main(String[] args) {
		WordSearch2 ws2= new WordSearch2();
		System.out.println(ws2.findWords(new char[][] {{'o','a','a','n'}
													  ,{'e','t','a','e'}
													  ,{'i','h','k','r'}
													  ,{'i','f','l','v'}}
										, new String[] {"oath","pea","eat","rain"}));
		System.out.println(ws2.findWords(new char[][] {{'a','a'}},new String[] {"a"}));
		System.out.println(ws2.findWords(new char[][] {{'a','a'}},new String[] {"aaa"}));
	}

}
