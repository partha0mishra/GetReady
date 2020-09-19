package com.algods.leetcode;

public class SumOddLengthSubarrays {
	public int sumOddLengthSubarrays(int[] arr) {
		int len=arr.length;
		if(len ==1) return arr[0];
		int sum=0;
		for(int sublen=1; sublen <= len; sublen+=2) {
			System.out.println("sublen:"+sublen);
			for(int i=0; i<= (len - sublen); i+=1) {
				System.out.println("i:"+i);
				for(int j=0; j< sublen; j++) {
					System.out.println("j:"+j);
					sum+=arr[i+j];
					System.out.println("pos "+(i+j)+" num:"+arr[i+j]+" sum: "+sum);
				}
			}
		}
		return sum;
    }
	public static void main(String[] args) {
		SumOddLengthSubarrays instance = new SumOddLengthSubarrays();
		System.out.println(instance.sumOddLengthSubarrays(new int[] {1,4,2,5,3}));
	}

}
