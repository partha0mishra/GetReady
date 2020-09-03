package com.algods.leetcode;
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
public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		if(s.length() < 2) return false;
//		System.out.println("Length: "+s.length());
		boolean skipThisLength=false;
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
		RepeatedSubstringPattern instance = new RepeatedSubstringPattern();
		System.out.println(instance.repeatedSubstringPattern("abab"));// true
		System.out.println(instance.repeatedSubstringPattern("aba"));// false
		System.out.println(instance.repeatedSubstringPattern("abcabcabcabc"));// true
		System.out.println(instance.repeatedSubstringPattern("x"));// true
	}

}
