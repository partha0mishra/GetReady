package com.algods.leetcode;
/*
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 

 

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 

Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.
 */
import java.util.*;
public class GoatLatin {
	private HashSet<Character> vowels= new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String toGoatLatin(String S) {
    	if(S.length() <1) return S;
    	String[] tokens=S.split(" ");
    	StringBuffer result= new StringBuffer();
    	StringBuffer suffix= new StringBuffer("a");
    	for(String t:tokens) {
    		if(!vowels.contains(t.charAt(0))) {
    			result.append(t.substring(1)).append(t.charAt(0));
    		}else {
    			result.append(t);
    		}
    		result.append("ma");
    		result.append(suffix).append(" ");// spacing between words
    		suffix.append('a');
    	}
    	return result.substring(0, result.length()-1).toString();
    }
    public static void main(String[] args) {
    	GoatLatin instance = new GoatLatin();
    	System.out.println(instance.toGoatLatin("apple"));
    	System.out.println(instance.toGoatLatin("I speak Goat Latin"));
    	System.out.println(instance.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
