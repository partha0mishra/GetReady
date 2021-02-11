package com.leetcode.hashTable;
/**
 * 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.
 */
import java.util.*;
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map= new HashMap<>();
        for(String str: strs) {
        	char[] ca=str.toCharArray(); Arrays.sort(ca); String key= new String(ca);
//        	System.out.println(key);
        	if(map.containsKey(key)) {
        		map.get(key).add(str);// The Value List is referenced. so, add to it.
        		continue;
        	}
        	map.put(key, new ArrayList<String>(Arrays.asList(str)));
        }
        return new ArrayList<List<String>>(map.values());// YEP
    }
}
