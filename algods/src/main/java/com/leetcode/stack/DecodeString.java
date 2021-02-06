package com.leetcode.stack;
/** 
 * 394. Decode String
 * Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
 */
import java.util.*;
public class DecodeString {
	/**
	 * Stack: 2 stacks - for count and for strings
	 * 
	 * Intuition

In the previous approach, we used a single character stack to store the digits(0-9) as well as letters (a-z). We could instead maintain 2 separate stacks.

countStack: The stack would store all the integer k.
stringStack: The stack would store all the decoded strings.
Also, instead of pushing the decoded string to the stack character by character, we could improve our algorithm by appending all the characters into the string first and then push the entire string into the stringStack. Let's look at the algorithm in detail.

Algorithm

Iterate over the string s and process each character as follows:

Case 1) If the current character is a digit (0-9), append it to the number k.

Case 2) If the current character is a letter (a-z), append it to the currentString.

Case 3) If current character is a opening bracket [, push k and currentString intocountStack and stringStack respectively.

Case 4) Closing bracket ]: We must begin the decoding process,

We must decode the currentString. Pop currentK from the countStack and decode the pattern currentK[currentString]

As the stringStack contains the previously decoded string, pop the decodedString from the stringStack. Update the decodedString = decodedString + currentK[currentString]
	 */
	String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                // push the number k to countStack
                countStack.push(k);
                // push the currentString to stringStack
                stringStack.push(currentString);
                // reset currentString and k
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                // decode currentK[currentString] by appending currentString k times
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
	
	/**
	 * Stack implementation
	 * 
	 * Approach 1: Using Stack
Intuition

We have to decode the result in a particular pattern. We know that the input is always valid. The pattern begins with a number k, followed by opening braces [, followed by string. Post that, there could be one of the following cases :

There is another nested pattern k[string k[string]]
There is a closing bracket k[string]
Since we have to start decoding the innermost pattern first, continue iterating over the string s, pushing each character to the stack until it is not a closing bracket ]. Once we encounter the closing bracket ], we must start decoding the pattern.

As we know that stack follows the Last In First Out (LIFO) Principle, the top of the stack would have the data we must decode.

Algorithm

The input can contain an alphabet (a-z), digit (0-9), opening braces [ or closing braces ]. Start traversing string s and process each character based on the following rules:

Case 1) Current character is not a closing bracket ].

Push the current character to stack.

Case 2) Current character is a closing bracket ].

Start decoding the last traversed string by popping the string decodedString and number k from the top of the stack.

Pop from the stack while the next character is not an opening bracket [ and append each character (a-z) to the decodedString.
Pop opening bracket [ from the stack.
Pop from the stack while the next character is a digit (0-9) and build the number k.
Now that we have k and decodedString , decode the pattern k[decodedString] by pushing the decodedString to stack k times.
	 */
//	public String decodeString(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ']') {
//                List<Character> decodedString = new ArrayList<>();
//                // get the encoded string
//                while (stack.peek() != '[') {
//                    decodedString.add(stack.pop());
//                }
//                // pop [ from the stack
//                stack.pop();
//                int base = 1;
//                int k = 0;
//                // get the number k
//                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
//                    k = k + (stack.pop() - '0') * base;
//                    base *= 10;
//                }
//                // decode k[decodedString], by pushing decodedString k times into stack
//                while (k != 0) {
//                    for (int j = decodedString.size() - 1; j >= 0; j--) {
//                        stack.push(decodedString.get(j));
//                    }
//                    k--;
//                }
//            }
//            // push the current character to stack
//            else {
//                stack.push(s.charAt(i));
//            }
//        }      
//        // get the result from stack
//        char[] result = new char[stack.size()];
//        for (int i = result.length - 1; i >= 0; i--) {
//            result[i] = stack.pop();
//        }
//        return new String(result);
//    }
//	
	/**
	 * Approach 01: recursion - copied
	 */
//	public String decodeString(String s) {
//        Deque<Character> queue = new ArrayDeque<>();
//        for (char c : s.toCharArray()) queue.offer(c);
//        return helper(queue);
//    }
//    
//    public String helper(Deque<Character> queue) {
//        StringBuilder sb = new StringBuilder();
//        int num = 0;
//        while (!queue.isEmpty()) {
//            char c= queue.poll();
//            if (Character.isDigit(c)) {
//                num = num * 10 + c - '0';
//            } else if (c == '[') {
//                String sub = helper(queue);
//                for (int i = 0; i < num; i++) sb.append(sub);   
//                num = 0;
//            } else if (c == ']') {
//                break;
//            } else {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }
    /* Approach 01: using stack - simulating recursion */
//	public String decodeString(String s) {
//        String res = "";
//        Stack<Integer> countStack = new Stack<>();
//        Stack<String> resStack = new Stack<>();
//        int idx = 0;
//        while (idx < s.length()) {
//            if (Character.isDigit(s.charAt(idx))) {
//                int count = 0;
//                while (Character.isDigit(s.charAt(idx))) {
//                    count = 10 * count + (s.charAt(idx) - '0');
//                    idx++;
//                }
//                countStack.push(count);
//            }
//            else if (s.charAt(idx) == '[') {
//                resStack.push(res);
//                res = "";
//                idx++;
//            }
//            else if (s.charAt(idx) == ']') {
//                StringBuilder temp = new StringBuilder (resStack.pop());
//                int repeatTimes = countStack.pop();
//                for (int i = 0; i < repeatTimes; i++) {
//                    temp.append(res);
//                }
//                res = temp.toString();
//                idx++;
//            }
//            else {
//                res += s.charAt(idx++);
//            }
//        }
//        return res;
//    }
	public static void main(String[] args) {
//		System.out.println(new DecodeString().decodeString("a"));
//		System.out.println(new DecodeString().decodeString("aa"));
		System.out.println(new DecodeString().decodeString("2[a]"));
	}

}
