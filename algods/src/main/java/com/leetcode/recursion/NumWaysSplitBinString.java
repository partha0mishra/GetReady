package com.leetcode.recursion;

public class NumWaysSplitBinString {
	static final char ONE='1';
	static final char ZERO='0';
	int mod=10^9+7;
	public int numWays(String s) {
		int countOnes=0;
		int countZeroes=0;
		        for(char c: s.toCharArray()) {
        	if(c==ONE) countOnes++;
        	if(c==ZERO) countZeroes++;
        }
        if(countOnes==0) {
        	return (int)((((long)(countZeroes-1))*(countZeroes-2)/2)%1000000007);
        }
        
        if(countOnes %3 !=0) return 0;
        int firstStop=countOnes/3;
        int secondStop=2*countOnes/3;
        int firstStopZeroes=0;
        int secondStopZeroes=0;
        int ones=0;
        for(char c: s.toCharArray()) {
        	if(c == ONE) {
        		ones++;
        	} else if(ones == firstStop) {
        		firstStopZeroes++;
        	} else if(ones == secondStop) {
        		secondStopZeroes++;
        	}
        }
//        System.out.println("fs:  "+firstStop+" ss:  "+secondStop+" countones: "+countOnes);
//        System.out.println("fsz: "+firstStopZeroes+" ssz: "+secondStopZeroes);
            
        return (int)((((long)(firstStopZeroes+1))*(secondStopZeroes+1)) %1000000007);
    }
	public static void main(String[] args) {
		NumWaysSplitBinString instance= new NumWaysSplitBinString();
		System.out.println(instance.numWays("10101"));// 4
		System.out.println(instance.numWays("1001"));// 0
		System.out.println(instance.numWays("100100010100110"));// 12
		System.out.println(instance.numWays("010010000000001000"));// 30
		System.out.println(instance.numWays("0000000000000000000000100000000000000000000000000000001000000110000000000100000011000000001010000001000000000010000000000100001000000001000000000000001000000000010000000000000000000000000000000001010000000000000000000000000000000000110000000000000000000000000000011000000000001000000010110000000110100001000000000000100000100100000000000000100010000000010000000000000000000000000000101001000000001000000000000000000000000000000000000000000000010000000001010000000000000000000000000000001000000000000000000000010000010000000000000000000000010000000000000000000000100000000"));
		System.out.println(instance.numWays("000"));// 1
		System.out.println(instance.numWays("0000"));// 4
		System.out.println(instance.numWays("00000"));// 6
		System.out.println(instance.numWays("000000"));// 10
		System.out.println(instance.numWays("00000000"));// 21
	}

}
