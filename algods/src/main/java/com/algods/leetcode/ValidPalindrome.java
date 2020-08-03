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
	char leftChar;
	char rightChar;
	int diff;
    public boolean isPalindrome(String s) {
        if(s.trim().length() ==0) return true;
        int left=0;
        int right=s.length()-1;
        diff='a'-'A';// that's needed to change a lower-case to an upper-case
        
        while(left < right) {
        	leftChar=s.charAt(left);
        	rightChar=s.charAt(right);
        	// skip it if it's not a valid char
        	if(!isValid(leftChar,true)) {left++; continue;}
        	if(!isValid(rightChar,false)) {right--; continue;}
        	// if the characters are valid and same, check next chars
        	if(leftChar == rightChar) {left++; right--;}
        	else return false; // fail fast if they're not same
        }
        return true;
    }
    private boolean isValid(char c,boolean left) {
    	if (c-'A' >=0 && c-'Z' <=0) return true;
    	else if(c-'0' >=0 && c-'9' <=0) return true;
    	else if(c-'a' >=0 && c-'z' <=0) {
    		if(left) leftChar=(char) (leftChar - diff);
    		else rightChar=(char) (rightChar - diff);
    		return true;
    	}
    	
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
