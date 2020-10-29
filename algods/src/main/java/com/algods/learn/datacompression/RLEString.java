package com.algods.learn.datacompression;

/* Need a better RLE example than what's there in RS course 
 * Ref: com.algods.leetcode.strings.StringCompression => this only looks at the number of chars in output
 * Modified to provide the "actual" RLE Compressed string.
 * */
public class RLEString {
	public String compress(String s) {
		return compress(s.toCharArray());
	}
	public String compress(char[] chars) {
		StringBuilder result= new StringBuilder();
		if(chars == null) return result.toString();
//		if(chars == null || chars.length <2) return chars.length;
		char current=chars[0];
		int count=1;
		result.append(current);
		for(int i=1; i< chars.length; i++) {
			if(chars[i] == current) count+=1;
			else {
				result.append(count);
				current=chars[i];
				result.append(current);
				count=1;
			}
		}
		result.append(count);
		System.out.println("Imput Length: "+chars.length+" Output Length: "+result.length());
		return result.toString();
    }
	public static void main(String[] args) {
		System.out.println(new RLEString().compress(new char[] {'a','a','b','b','c','c','c'}));
		System.out.println(new RLEString().compress("aaaaaaaaaaaaaaaaaaaaaaaaaaabbbbaaaaaaaaaaaaaaaaaaaaaaaaaabbbbccccccccccccccccccccccccccaaaaaaaaaaaaaaaaaaaaaaaaaajjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkknnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeaaaaaaaaakkkkkkkkkkkkkkkkkkkkkkaaaaaakkkkkkkkkkkkkkkkkkkkkkkkkkkkkhkhkhkkkkkkkkkkkkkkkkkkkk"));
		System.out.println(new RLEString().compress("                                            "
												  + "                     xxxx                   "
												  + "                    xx xx                   "
												  + "                   xx  xx                   "
												  + "                       xx                   "
												  + "                       xx                   "
												  + "                       xx                   "
												  + "                       xx                   "
												  + "                       xx                   "
												  + "                   xxxxxxxxxx               "
												  + "                                            "
												  + "                                            "));
	}
}
