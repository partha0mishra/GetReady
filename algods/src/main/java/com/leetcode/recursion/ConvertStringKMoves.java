package com.leetcode.recursion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Given two strings s and t, your goal is to convert s into t in k moves or less.
 * During the ith (1 <= i <= k) move you can:
 * Choose any index j (1-indexed) from s, such that 1 <= j <= s.length and j has not been chosen in any previous move, 
 * and shift the character at that index i times.
 * Do nothing.
 * Shifting a character means replacing it by the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Shifting a character by i means applying the shift operations i times.
 * Remember that any index j can be picked at most once.
 * Return true if it's possible to convert s into t in no more than k moves, otherwise return false.
 * 
 * Input: s = "input", t = "ouput", k = 9
 * Output: true
 * Explanation: In the 6th move, we shift 'i' 6 times to get 'o'. And in the 7th move we shift 'n' to get 'u'.
 * 
 * Input: s = "abc", t = "bcd", k = 10
 * Output: false
 * Explanation: We need to shift each character in s one time to convert it into t. 
 * We can shift 'a' to 'b' during the 1st move. 
 * However, there is no way to shift the other characters in the remaining moves to obtain t from s.
 * 
 * Input: s = "aab", t = "bbb", k = 27
 * Output: true
 * Explanation: In the 1st move, we shift the first 'a' 1 time to get 'b'. 
 * In the 27th move, we shift the second 'a' 27 times to get 'b'.
 * 
 * 1 <= s.length, t.length <= 10^5
 * 0 <= k <= 10^9
 * s, t contain only lowercase English letters.
 */
import java.util.*;
public class ConvertStringKMoves {
	/* Approach 02: Accepted*/
	public boolean canConvertString(String s, String t, int k) {
		if(s.length() != t.length()) return false;
		int rotate=26;// a -> b = a -> 26+b
		ArrayList<Integer> diffList= new ArrayList<Integer>();
		
		for(int i=0; i<s.length(); i++) {
			int diff=t.charAt(i) - s.charAt(i);// Math.abs won't work
			if(diff == 0) continue;
			if(diff <0 ) diff=diff+rotate;
			if(diff > k) return false; // needs 100 shifts but allowed 10
			
			diffList.add(diff);// utilized
		}
		Collections.sort(diffList);
		Iterator<Integer> it=diffList.iterator();
		int prevNum=0, found=0;
		while(it.hasNext()){
			int num=it.next();
			if(num == prevNum) {
				found++;
				num=num+found*rotate;
			}else {
				found=0;
				prevNum=num;
			}
			if(num > k) return false;
		}
        return true;
    }
	/* Approach 01 - time limit exceeded */
//	public boolean canConvertString(String s, String t, int k) {
//		if(s.length() != t.length()) return false;
//		int rotate=26;// a -> b = a -> 26+b
//		HashSet<Integer> diffMap= new HashSet<Integer>();
//		
//		for(int i=0; i<s.length(); i++) {
//			int diff=t.charAt(i) - s.charAt(i);// Math.abs won't work
//			if(diff == 0) continue;
//			if(diff <0 ) diff=diff+rotate;
//			if(diff > k) return false; // needs 100 shifts but allowed 10
//			
//			while(diffMap.contains(diff)) {
//				diff=diff+rotate;
//				if(diff > k) return false;
//			}
//			
//			diffMap.add(diff);// utilized
//		}
//		
//        return true;
//    }
	public static void main(String[] args) {
		ConvertStringKMoves instance = new ConvertStringKMoves();
		assertFalse("01",instance.canConvertString("a", "ab", 10));
		assertTrue("02",instance.canConvertString("input", "ouput", 9));
		assertFalse("03",instance.canConvertString("abc", "bcd",10));
		assertTrue("04",instance.canConvertString("aab", "bbb", 27));
		assertFalse("05",instance.canConvertString("atmtxzjkz", "tvbtjhvjd", 35));
	}

}
