package com.leetcode.recursion.backtracking;
// TODO Anki
/* Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
import java.util.*;
public class PhoneNumberLetterCombination {
	char[][] letters= {{'a','b','c'},{'d','e','f'}
				,{'g','h','i'},{'j','k','l'},{'m','n','o'}
				,{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
	public List<String> letterCombinations(String digits) {
        List<String> result= new ArrayList<String>();
        if(digits.length() < 1) return null;
        backtrack(digits,0,result,"");// digits, index, result, initial word
        return result;
    }
	private void backtrack(String digits, int index, List<String> result, String partial) {
		if(index == digits.length()) {
			result.add(partial);
			return;
		}
		char[] l=letters[digits.charAt(index) -'0' -2];
		for(char c: l) {
			backtrack(digits, index+1, result,partial+c);
		}
	}
	public static void main(String[] args) {
		PhoneNumberLetterCombination pnlc= new PhoneNumberLetterCombination();
		System.out.println(pnlc.letterCombinations(""));// 
		System.out.println(pnlc.letterCombinations("2"));// [a, b, c]
		System.out.println(pnlc.letterCombinations("23"));// [ad, ae, af, bd, be, bf, cd, ce, cf]
		System.out.println(pnlc.letterCombinations("4957"));// 
	}
}
