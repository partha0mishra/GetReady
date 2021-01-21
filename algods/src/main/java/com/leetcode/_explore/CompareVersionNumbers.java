package com.leetcode;
/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 * 
 * Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
Example 4:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
Example 5:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 

Note:

Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
Version strings do not start or end with dots, and they will not be two consecutive dots.
 */
import static org.junit.Assert.assertEquals;
public class CompareVersionNumbers {
	private static final String SEP="\\.";
	public int compareVersion(String version1, String version2) {
        String[] tokens1=version1.split(SEP);
        String[] tokens2=version2.split(SEP);
        int len1=tokens1.length, len2=tokens2.length, i=0;
        for(i=0; i< tokens1.length && i< tokens2.length; i++) {
        	int val1=Integer.valueOf(tokens1[i]);
        	int val2=Integer.valueOf(tokens2[i]);
        	if(val1==val2) continue;
        	else return val1 > val2? 1:-1;
        }
        return len1> len2? checkAllZeroes(tokens1,i, len1): -1*checkAllZeroes(tokens2,i, len2);
    }
	private int checkAllZeroes(String[] tokens, int i, int len) {
		for(int x=i; x< len; x++) {
			int val=Integer.valueOf(tokens[x]);
			if(val > 0) return 1;
		}
		return 0;
	}
	public static void main(String[] args) {
		CompareVersionNumbers instance = new CompareVersionNumbers();
		assertEquals(-1,instance.compareVersion("0.1"  ,	"1.1"));
		assertEquals( 1,instance.compareVersion("1.0.1",	"1"));
		assertEquals(-1,instance.compareVersion("7.5.2.4",	"7.5.3"));
		assertEquals( 0,instance.compareVersion("1.01",		"1.001"));
		assertEquals( 0,instance.compareVersion("1.0", 		"1.0.0"));
		assertEquals(-1,instance.compareVersion("1.0", 		"1.1"));// tricky case
//		assertEquals( 1,instance.compareVersion("2.10000000000000000000000000000.0", "2.1"));// this case is not handled here
	}
}
