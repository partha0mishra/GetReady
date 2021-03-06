package com.leetcode._explore;

/*
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * 
 * Input: "USA"
 * Output: True
 * 
 * Input: "FlaG"
 * Output: False
 * 
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class DetectCapital {
	/** Approach 03 - Pattern matching : NOT OPTIMUM */
	public boolean detectCapitalUse(String word) {
		return word.matches("[A-Z]*|.[a-z]*");
    }
	
	/** Approach 02 using Characters: faster and less memory */
//	public boolean detectCapitalUse(String word) {
//        int n= word.length();// number of total words
//        int caps=0;
//        for(int i=0;i<n;i++)
//            if(word.charAt(i)-'A'<26)
//                caps++;// number of caps
//        
//        if(caps==n) return true;// all CAPS
//        else if(caps==1 && word.charAt(0)-'A'<26) return true;// Starting caps
//        else if(caps==0)  return true;// all lowercase
//        else return false;   
//    }
	/** Approach 01 easy one */
//	public boolean detectCapitalUse(String word) {
//		if(word.equals(word.toLowerCase())) return true;// All are lowercase
//		if(word.equals(word.toUpperCase())) return true;// All are uppercase
//		if(word.substring(0, 1).equals(word.substring(0, 1).toUpperCase()) // first letter is capitalized 
//				&& word.substring(1).equals(word.substring(1).toLowerCase())) return true;// rest all lowercase
//		
//		return false;// let's default to False
//    }
	public static void main(String[] args) {
		DetectCapital instance = new DetectCapital();
		System.out.println(instance.detectCapitalUse("USA"));// True
		System.out.println(instance.detectCapitalUse("FlaG"));// False
		System.out.println(instance.detectCapitalUse("leetcode"));// True
		System.out.println(instance.detectCapitalUse("A"));// True
		System.out.println(instance.detectCapitalUse("a"));// True
	}

}
