package com.leetcode.recursion.strings;
/* 8. String to Integer (atoi)
 * Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered a whitespace character.
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 

Example 1:

Input: str = "42"
Output: 42
Example 2:

Input: str = "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: str = "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: str = "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: str = "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer. Thefore INT_MIN (−231) is returned.
 

Constraints:

0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits, ' ', '+', '-' and '.'.
 */
public class StringToInteger {
	private static final int INT_MAX=Integer.MAX_VALUE;
    private static final int INT_MIN=Integer.MIN_VALUE;
    private static final char SPACE=' ';
    private static final char PLUS= '+';
    private static final char MINUS='-';
    private boolean negative=false;
    public int myAtoi(String s) {
        long result=0; int index=0;
        for(index=0; index< s.length() && s.charAt(index)==SPACE; index++);//spaces done
        if(index == s.length()) return 0;// only spaces
        if(s.charAt(index)==MINUS){negative = true; index++;}
        else if(s.charAt(index)==PLUS){index++;}
        if(index == s.length()) return 0;// no real numbers
        while(index < s.length()){
            char c=s.charAt(index++);
            // if(c == DOT) continue;
            if(c - '0'>= 0 && c- '0' <=9) result=result*10+(c-'0');
            else break;
            // breakout
            if(negative && result*-1 <= INT_MIN) return INT_MIN;
            else if(result > INT_MAX) return INT_MAX;
        }
        
        if(negative) result*=-1;
        return (int)result;
    }
	public static void main(String[] args) {
		StringToInteger instance = new StringToInteger();
		System.out.println(instance.myAtoi("42"));// 42
		System.out.println(instance.myAtoi("-42"));// -42
		System.out.println(instance.myAtoi("4193 with words"));// 4193
		System.out.println(instance.myAtoi("words and 987"));// 0
		System.out.println(instance.myAtoi("-91283472332"));// INT_MIN -2147483648
		System.out.println(instance.myAtoi("  +42"));// 42
		System.out.println(instance.myAtoi("  -42 "));// -42
		System.out.println(instance.myAtoi("  + 4 2"));// 0
		System.out.println(instance.myAtoi("1.2"));// 1
		System.out.println(instance.myAtoi("-91283472332 "));// INT_MIN -2147483648
		System.out.println(instance.myAtoi("1.2 "));// 1
		System.out.println(instance.myAtoi(" 1.2"));// 1
		System.out.println(instance.myAtoi("+1.2"));// 1
		System.out.println(instance.myAtoi("-1.2"));// -1
		System.out.println(instance.myAtoi(".1.2"));// 0
		System.out.println(instance.myAtoi("-912834.72332"));// -912834
		System.out.println(instance.myAtoi(""));// 0
		System.out.println(instance.myAtoi(" "));// 0
		System.out.println(instance.myAtoi(" ."));// 0
		System.out.println(instance.myAtoi(" +"));// 0
		System.out.println(instance.myAtoi(" -"));// 0
		System.out.println(instance.myAtoi(" +.123"));// 0
		System.out.println(instance.myAtoi(" +.123 "));// 0
		System.out.println(instance.myAtoi(" +.-1"));// 0
	}
}
