package com.leetcode;
/*
 * Given an input string, reverse the string word by word.
 * 
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * 
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * 
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class ReverseWords {

    public String reverseWords(String s) {
    	String[] tokens=s.trim().split(" ");
    	int numTokens= tokens.length;
    	StringBuilder sb= new StringBuilder();
    	for(int i=numTokens-1; i >= 0; i--) {
    		if(tokens[i] !=null) {
    			if(tokens[i].trim().length() != 0) {
	    			sb.append(tokens[i]);
	    			if(i>0) {
	    				sb.append(" ");
	    			}
    			}
    		}
    	}
    	
    	return sb.toString();
    }
    
    public static void main(String[] sentence) {
    	String sentence1="the sky is blue";
    	System.out.println("Output 01: "+new ReverseWords().reverseWords(sentence1));
    	String sentence2="  hello world!  ";
    	System.out.println("Output 02: "+new ReverseWords().reverseWords(sentence2));
    	String sentence3="a good   example";
    	System.out.println("Output 03: "+new ReverseWords().reverseWords(sentence3));
    }
}
