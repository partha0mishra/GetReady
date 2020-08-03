package com.algods.leetcode;
/**
 * @author Partha.X.Mishra
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * Example 2:
 * Input: "race a car"
 * Output: false
 * 
 * Constraints:
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.trim().length() ==0) return true;
     // TODO to remove this as this takes one pass and some memory for sure
        s=s.toUpperCase(); 
        int left=0;
        int right=s.length()-1;
        
        while(left < right) {
        	char leftChar=s.charAt(left);
        	char rightChar=s.charAt(right);
        	// skip it if it's not a valid char
        	if(!isValid(leftChar)) {left++; continue;}
        	if(!isValid(rightChar)) {right--; continue;}
        	// if the characters are valid and same, check next chars
        	if(leftChar == rightChar) {left++; right--;}
        	else return false; // fail fast if they're not same
        }
        return true;
    }
    private boolean isValid(char c) {
    	if (c-'A' >=0 && c-'Z' <=0) return true;
    	else if(c-'0' >=0 && c-'9' <=0) return true;
    	
    	return false;
    }
	public static void main(String[] args) {
		ValidPalindrome instance = new ValidPalindrome();
		// Empty string - Valid
		System.out.println(instance.isPalindrome(""));
		// "A man, a plan, a canal: Panama" : True
		System.out.println(instance.isPalindrome("A man, a plan, a canal: Panama"));
		// "race a car" : False
		System.out.println(instance.isPalindrome("race a car"));
		System.out.println(instance.isPalindrome("0P"));// False
		System.out.println(instance.isPalindrome("P0"));// False
	}
}
