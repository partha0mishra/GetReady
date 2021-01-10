package com.leetcode.graph.bfs;

/*
 * Let s and t be strings and D a dictionary, i.e., a set of strings. Define s to produce t if
there exists a sequence of strings from the dictionary P = (so,Si,...,s„_i ) such that the
first string is s, the last string is f, and adjacent strings have the same length and differ
in exactly one character. The sequence P is called a production sequence. For example,
if the dictionary is {bat, cot,dog,dag,dot, cat), then (cat, cot, dot,dog) is production
sequence.

Given a dictionary D and two strings s and f, write a program to determine if s
produces t. Assume that all characters are lowercase alphabets. If s does produce f,
output the length of a shortest production sequence; otherwise, output -1.
Hint: Treat strings as vertices in an undirected graph, with an edge between u and v if and only
if the corresponding strings differ in one character.
*/
import java.util.*;
public class EpiProductionSequence {
	class StringWithDistance{
		String candidateString;
		Integer distance;
		public StringWithDistance(String cs, int d) {
			this.candidateString=cs;
			this.distance=d;
		}
	}
	private Set<String> dict;
	// Using BFS to find least steps for transformation
	public int transformString(Set<String> d, String start, String target) {
		dict=d;
		Queue<StringWithDistance> q=new LinkedList<>();
		dict.remove(start);
		q.add(new StringWithDistance(start,0));
		StringWithDistance f;
		while((f= q.poll()) != null) {
			// return if we find a match
			if(f.candidateString.equals(target)) return f.distance;
			// tries all possible combinations of changing each character in the word
			// quite like backtracking, but this one is limiting to the valid combinations in the dictionary
			String str=f.candidateString;
			for(int i=0; i< str.length(); ++i) {
				String firstPart= (i == 0)? "":str.substring(0,i);
				String lastPart=  (i+1 < str.length()) ? str.substring(i+1):"";
				for(int mid=0; mid< 26; mid++) {// try all characters
					String newString=firstPart+(char)('a'+mid)+lastPart;
					if(dict.remove(newString)) {// Considering only if it exists in the dictionary
//						System.out.println(newString);
						q.add(new StringWithDistance(newString,f.distance+1));
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		String[] words= {"bat","cot","dog","dag","dot","cat"};
		System.out.println(new EpiProductionSequence().transformString(new HashSet<>(Arrays.asList(words)), "bat", "cat"));// 1
		System.out.println(new EpiProductionSequence().transformString(new HashSet<>(Arrays.asList(words)), "cat", "cot"));// 1
		System.out.println(new EpiProductionSequence().transformString(new HashSet<>(Arrays.asList(words)), "bat", "dot"));// 3
		System.out.println(new EpiProductionSequence().transformString(new HashSet<>(Arrays.asList(words)), "bat", "dog"));// 4
		System.out.println(new EpiProductionSequence().transformString(new HashSet<>(Arrays.asList(words)), "bat", "dag"));// 5
	}
}
