package com.algods.leetcode.strings;
/* 345. Reverse Vowels of a String
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
 */
public class ReverseVowelsInString {
	public String reverseVowels(String s) {
        int i=0, n=s.length(), j=n;
        StringBuilder result=new StringBuilder();
        while(i<n){
            while(!isVowel(s.charAt(i))) {
                result.append(s.charAt(i));
                i++;
                if(i ==n) return result.toString();
            }
            while(!isVowel(s.charAt(--j)));
            result.append(s.charAt(j));
            i++;
        }
        return result.toString();
    }
    private boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}
