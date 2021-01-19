package com.leetcode.sort;
/* NOT DONE YET
 * 
 */
import java.util.*;
public class SmallerNumbersAfterSelf {
	class NumIndex implements Comparable<NumIndex>{
        int num, index;
        public NumIndex(int n, int i){this.num=n; this.index=i;}
        public int compareTo(NumIndex ni){
            return Integer.compare(this.num, ni.num);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int len=nums.length;
        NumIndex[] nis= new NumIndex[len];
        for(int i=0; i< len; i++) nis[i]=new NumIndex(nums[i],i);
        Arrays.sort(nis);
        Integer[] result=new Integer[len];
        for(int i=0; i< len; i++) result[nis[i].index]= (i-nis[i].index <=0)? 0: (i-nis[i].index);
        return Arrays.asList(result);
    }
	public static void main(String[] args) {
		SmallerNumbersAfterSelf snas= new SmallerNumbersAfterSelf();
		System.out.println(snas.countSmaller(new int[] {5,2,6,1}));
	}

}
