package com.leetcode.recursion.strings;
/* 38. Count and Say
 * 
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
 
Constraints:

1 <= n <= 30
 */
public class CountAndSay {
	public String countAndSay(int n) {
        StringBuilder prev=new StringBuilder("1");
        for(int i=1; i< n; i++) {
        	StringBuilder sb=new StringBuilder();
        	int read=0, count=1;
        	char current= prev.charAt(0);
        	for(read=1; read< prev.length(); read++) {
        		if(current == prev.charAt(read)) count+=1;
        		else {
        			sb.append(count);
        			sb.append(current);
        			current=prev.charAt(read);
        			count=1;
        		}
        	}
        	sb.append(count);
        	sb.append(current);
        	prev=sb;
        }
        return prev.toString();
    }
	public static void main(String[] args) {
		CountAndSay instance = new CountAndSay();
//		System.out.println(instance.countAndSay(1));
		for(int i=1; i< 10; i++) {
			System.out.println(instance.countAndSay(i));
		}
	}

}
