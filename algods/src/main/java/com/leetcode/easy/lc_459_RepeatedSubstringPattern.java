package com.leetcode.easy;
/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and 
 * appending multiple copies of the substring together. You may assume the given string consists of 
 * lowercase English letters only and its length will not exceed 10000.
 * 
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class lc_459_RepeatedSubstringPattern {
	/* Approach 02: COPIED
	 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3447/discuss/94344/Simple-Java-solution-2-lines*/
//	public boolean repeatedSubstringPattern(String s) {
//		String s2=s+s;
////		System.out.println(s);
////		System.out.println(s2);
////		System.out.println(s2.substring(1, s2.length()-1));
//		return s2.substring(1, s2.length()-1).contains(s);
//    }
	/* Approach 01: Brute and Naive but it seems this is regular at a high performance zone of submissions */
	public boolean repeatedSubstringPattern(String s) {
//		if(s.length() < 2) return false;// not needed as skipThisLength is initialized to True.
//		System.out.println("Length: "+s.length());
		boolean skipThisLength=true;
		for(int subLen=1; subLen<= s.length()/2; subLen ++) {
//			System.out.println("substring length:"+subLen);
			if(s.length() % subLen !=0) continue;// need it to be a factor
//			System.out.println("considered");
			skipThisLength=false;
			for(int start=subLen; start <= s.length() -subLen; start+=subLen) {
//				System.out.println("start: "+start);
				for(int i=0; i< subLen; i++) {
//					System.out.println("left: "+i+" right: "+(start+i));
//					System.out.println("left: "+s.charAt(i)+" right: "+s.charAt(start+i));
					if(s.charAt(i) != s.charAt(start+i)) {skipThisLength=true; break;}
				}
				if(skipThisLength) break;
			}
			if(! skipThisLength) break;
		}
		return !skipThisLength;
    }
	
	public static void main(String[] args) {
		lc_459_RepeatedSubstringPattern instance = new lc_459_RepeatedSubstringPattern();
		System.out.println(instance.repeatedSubstringPattern("abab"));// true
		System.out.println(instance.repeatedSubstringPattern("aba"));// false
		System.out.println(instance.repeatedSubstringPattern("abcabcabcabc"));// true
		System.out.println(instance.repeatedSubstringPattern("x"));// false
	}

}
