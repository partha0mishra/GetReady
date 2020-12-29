package com.leetcode.recursion;

import static org.junit.Assert.assertEquals;

/**
 * Given two positive integers n and k, the binary string  Sn is formed as follows:

S1 = "0"
Si = Si-1 + "1" + reverse(invert(Si-1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first 4 strings in the above sequence are:

S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
 * 
 * Example 01
 * Input: n = 3, k = 1
 * Output: "0"
 * Explanation: S3 is "0111001". The first bit is "0".
 * 
 * Example 02
 * Input: n = 4, k = 11
 * Output: "1"
 * Explanation: S4 is "011100110110001". The 11th bit is "1".
 * 
 * Example 03
 * Input: n = 1, k = 1
 * Output: "0"
 * 
 * Example 04
 * Input: n = 2, k = 3
 * Output: "1"
 * 
 * Constraints:
 * 1 <= n <= 20
 * 1 <= k <= 2^n - 1
 */
public class KthBitNthBinaryString {
	public char findKthBit(int n, int k) {
		if(k == 1) return '0';
		int last=0;
		int[] capacities=new int[n+1];
		for(int i=1; i<=n; i++) {
			last=2*last+1;
			capacities[i]=last;// that's the end
			if(last > k) n=i;// don't go too far
//			System.out.println(i+" "+last);
		}
		StringBuilder sb= new StringBuilder();
		sb.append('0');
		for(int i=1; i<n; i++) {
			StringBuilder sb1= inverse(sb.toString());
			sb.append('1');
			sb.append(sb1);
		}
		
		return sb.charAt(k-1);
    }
	private StringBuilder inverse(String s) {
		StringBuilder sbIn= new StringBuilder(s);
		StringBuilder sb= new StringBuilder();
		for(char c: sbIn.reverse().toString().toCharArray()) {
			if(c=='0') sb.append('1');
			else sb.append('0');
		}
		
		return sb;
	}
	public static void main(String[] args) {
		KthBitNthBinaryString instance = new KthBitNthBinaryString();
		assertEquals("01",'0',instance.findKthBit(3, 1));
		assertEquals("02",'1',instance.findKthBit(4, 11));
		assertEquals("03",'0',instance.findKthBit(1, 1));
		assertEquals("04",'1',instance.findKthBit(2, 3));
		assertEquals("05",'1',instance.findKthBit(20, 3));
		assertEquals("05",'1',instance.findKthBit(20, 11));
	}

}
