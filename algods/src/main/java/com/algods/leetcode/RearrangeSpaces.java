package com.algods.leetcode;

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
