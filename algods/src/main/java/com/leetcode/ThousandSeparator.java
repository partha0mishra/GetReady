package com.leetcode;
/*
 * Given an integer n, add a dot (".") as the thousands separator and return it in string format.

 

Example 1:

Input: n = 987
Output: "987"
Example 2:

Input: n = 1234
Output: "1.234"
Example 3:

Input: n = 123456789
Output: "123.456.789"
Example 4:

Input: n = 0
Output: "0"
 

Constraints:

0 <= n < 2^31
 */
public class ThousandSeparator {
    public String thousandSeparator(int n) {
    	if(n < 1000)
    		return Integer.toString(n);
    	else {
    		String mod= Integer.toString(n%1000);
    		while(mod.length() <3) {
    			mod="0".concat(mod);
    		}
    		return thousandSeparator(n/1000).concat(".").concat(mod);
    	}
    }
    public static void main(String[] args) {
    	ThousandSeparator instance = new ThousandSeparator();
    	System.out.println(instance.thousandSeparator(0));
    	System.out.println(instance.thousandSeparator(123));
    	System.out.println(instance.thousandSeparator(1234));
    	System.out.println(instance.thousandSeparator(123456789));
    	System.out.println(instance.thousandSeparator(51040));
    }
}
