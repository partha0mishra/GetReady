package com.leetcode;
/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * Zum Beispiel
 *     A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
 * 
 * Example:
 * Input: "A"
 * Output: 1
 * 
 * Input: "AB"
 * Output: 28
 * 
 * Input: "ZY"
 * Output: 701
 * 
 * "ABCDE" : 494265
 * "FXSHRXW" : 2147483647
 * 
 * 1 <= s.length <= 7
 * s consists only of uppercase English letters.
 * s is between "A" and "FXSHRXW".
 */
public class ExcelSheetColumnNumber {
	// Approach 03: using Loop PLUS String.charAt() - less memory footprint than String.toCharArray
    public int titleToNumber(String s) {
    	int result=0;
    	// base 26 BUT starting at 1 (A=0 >> 1)
    	for(int i=0; i< s.length(); i++) {
    		result=26*result+(s.charAt(i)-'A'+1);
    	}
    	return result;
    }	
	// Approach 02: using Loop - less memory footprint than approach 01
//    public int titleToNumber(String s) {
//    	int result=0;
//    	// base 26 BUT starting at 1 (A=0 >> 1)
//    	for(char c: s.toCharArray()) {
//    		result=26*result+(c-'A'+1);
//    	}
//    	return result;
//    }
	// Approach 01: Recursive
//    public int titleToNumber(String s) {
//    	if(s==null || s.length()==0) return 0;
//    	char c=s.charAt(s.length()-1);
//    	// base 26 BUT starting at 1 (A=0 >> 1)
//    	return (c-'A'+1)+26*titleToNumber(s.substring(0, s.length()-1));
//    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
