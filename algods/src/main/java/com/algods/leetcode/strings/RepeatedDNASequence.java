package com.algods.leetcode.strings;
/* Repeated DNA Sequences
 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". 
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * Example 1:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 * Constraints:
 * 0 <= s.length <= 105
 * s[i] is 'A', 'C', 'G', or 'T'.
 */
import java.util.*;
public class RepeatedDNASequence {
	public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hs= new HashSet<>(), result=new HashSet<>();
        for(int i=0; i+9 < s.length(); i++) {// 0123456789
        	String sub=s.substring(i,i+10);
        	if(!hs.add(sub)) result.add(sub);// hs returns false for duplicates
        }
        return new ArrayList<String>(result);
    }
}
