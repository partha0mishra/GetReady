package com.algods.leetcode;

public class ReplaceToAvoidRepeatedChars {
	char toReplace='?';
    char startChar='a';
    char endChar='z';
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
