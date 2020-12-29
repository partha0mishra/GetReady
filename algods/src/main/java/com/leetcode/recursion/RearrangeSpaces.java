package com.leetcode.recursion;
/*
 * Rearrange Spaces Between Words
 * You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

 

Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.
Example 3:

Input: text = "hello   world"
Output: "hello   world"
Example 4:

Input: text = "  walks  udp package   into  bar a"
Output: "walks  udp  package  into  bar  a "
Example 5:

Input: text = "a"
Output: "a"
 

Constraints:

1 <= text.length <= 100
text consists of lowercase English letters and ' '.
text contains at least one word.
 */
import java.util.*;
public class RearrangeSpaces {
	public String reorderSpaces(String text) {
		if(text.trim().length() ==0) return text;
		int len=text.length();
		int spaces=0;
		StringBuffer tempWord= new StringBuffer();
		List<String> words= new ArrayList<String>(); 
		for(int i=0; i< len; i++) {
			char c= text.charAt(i);
			if(c == ' ') {
				spaces ++;
				if(tempWord.length() > 0) words.add(tempWord.toString());
				tempWord= new StringBuffer();
			}
			else {
				tempWord.append(c);
			}
		}
		if(tempWord.length() > 0) words.add(tempWord.toString());
		int numTokens=words.size();
		int spacesPerWord=0;
		if(numTokens > 1) spacesPerWord=spaces/(numTokens-1); 
		int spacesAtEnd=spaces - (spacesPerWord * (numTokens-1));
		
		StringBuffer result= new StringBuffer();
		int x=0;
		for( x=0; x< words.size()-1; x++) {
			result.append(words.get(x));
			for(int i=0; i< spacesPerWord; i++) {
				result.append(" ");
			}
		}
		result.append(words.get(x));
        for(int i=0; i< spacesAtEnd; i++) result.append(" ");
        System.out.println(" length: "+len+" spaces: "+spaces+" words: "+numTokens+" spacesPerWord: "+spacesPerWord+" spacesAtEnd: "+spacesAtEnd);
        return result.toString();
    }
	public static void main(String[] args) {
		RearrangeSpaces instance = new RearrangeSpaces();
		System.out.println(instance.reorderSpaces("  this   is  a sentence "));
		System.out.println(instance.reorderSpaces(" practice   makes   perfect"));
		System.out.println(instance.reorderSpaces("hello   world"));
		System.out.println(instance.reorderSpaces("  walks  udp package   into  bar a"));
		System.out.println(instance.reorderSpaces("a"));
		System.out.println(instance.reorderSpaces(" a"));
		System.out.println(instance.reorderSpaces(" a "));
	}

}
