package com.algods.leetcode;
/*
 * Replace All ?'s to Avoid Consecutive Repeating Characters
 * Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters into lower case letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.

It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.

Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.

 

Example 1:

Input: s = "?zs"
Output: "azs"
Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
Example 2:

Input: s = "ubv?w"
Output: "ubvaw"
Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".
Example 3:

Input: s = "j?qg??b"
Output: "jaqgacb"
Example 4:

Input: s = "??yw?ipkj?"
Output: "acywaipkja"
 

Constraints:

1 <= s.length <= 100

s contains only lower case English letters and '?'.
 */
public class ReplaceToAvoidRepeatedChars {
	char toReplace='?';
    public String modifyString(String s) {
    	StringBuffer result= new StringBuffer();
        for(int i=0; i< s.length(); i++) {
        	char c=s.charAt(i);
        	if(c==toReplace) {
        		if(i == 0) {// starting
        			if(s.length() ==1) {// single character
        				result.append('a');
        			}else {
        				result.append(getValidChar(s.charAt(i+1)));
        			}
        		}else if(i == s.length()-1) {// last character
        				result.append(getValidChar(result.charAt(i-1)));
        		}else {
        			if(s.charAt(i+1) == toReplace) {
        				result.append(getValidChar(result.charAt(i-1)));
        			}else {
        				result.append(getValidChar(result.charAt(i-1),s.charAt(i+1)));
        			}
        		}
        		
        	}else {
        		result.append(c);
        	}
        	
        }
        return result.toString();
    }
	private char getValidChar(char charAt) {
		for(char x='a'; x<='z'; x++) {
			if(x != charAt) return x;
		}
		return 'a';
	}
	private char getValidChar(char charAt, char charAt2) {
		for(char x='a'; x<='z'; x++) {
			if(x != charAt && x!= charAt2) return x;
		}
		return 'a';
	}
	public static void main(String[] args) {
		ReplaceToAvoidRepeatedChars instance = new ReplaceToAvoidRepeatedChars();
		System.out.println(instance.modifyString("?zs"));
		System.out.println(instance.modifyString("ubv?w"));
		System.out.println(instance.modifyString("j?qg??b"));
		System.out.println(instance.modifyString("??qw?ipkj"));
		System.out.println(instance.modifyString("?"));
		System.out.println(instance.modifyString("a"));
		System.out.println(instance.modifyString("??"));
		System.out.println(instance.modifyString("a??"));
	}

}
