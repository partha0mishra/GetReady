package com.algods.leetcode;
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
 * 1 <= s.length <= 7
 * s consists only of uppercase English letters.
 * s is between "A" and "FXSHRXW".
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
    	if(s==null || s.length()==0) return 0;
    	char c=s.charAt(s.length()-1);
    	// base 26 BUT starting at 1 (A=0 >> 1)
    	return (c-'A'+1)+26*titleToNumber(s.substring(0, s.length()-1));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
