package com.algods.epi._05primitive;

public class NumBitsSetTo1 {
	// Lazy - Integer.bitCount()
//	public static short countBits(int i) {
//		return (short)Integer.bitCount(i);
//	}
	// Bit shifting
//	public static short countBits(int i) {
//		short result=0;
//		while(i > 0) {
//			result+=(i & 1);
//			i>>>=1;
//		}
//		return result;
//	}
	// x&(x-1) flips the rightmost set bit
	// more performant to check just that O(no of bits set to 1)
	public static short countBits(int i) {
		short result=0;
		while(i != 0) {
			result +=1;
			i &=(i-1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(NumBitsSetTo1.countBits(758));
	}

}
