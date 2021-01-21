package com.leetcode;
/*
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

public class AddBinary {
	private static final char ZERO = '0';
	
	public String addBinary(String a, String b) {
        String result = "";
        int lenA = a.length() -1, lenB = b.length() -1;
        int sum = 0;
        
        while(lenA >=0 || lenB >= 0) {
        	sum += ((lenA >= 0)? a.charAt(lenA) - ZERO: 0); 
            sum += ((lenB >= 0)? b.charAt(lenB) - ZERO: 0);
            
            result=(char)(sum % 2 + ZERO) + result;// modulo for what's remaining
            sum /=2; // carry over
            
            lenA --;
            lenB --;
        }
        if(sum > 0) {
        	result =(char)(sum + ZERO) + result;
        }
        
        return result;
    }
	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("11", "1"));// 100
		System.out.println(new AddBinary().addBinary("1010", "1011"));// 10101
		System.out.println(new AddBinary().addBinary("0", "0"));// 0
	}
}
