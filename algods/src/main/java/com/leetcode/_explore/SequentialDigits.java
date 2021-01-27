package com.leetcode._explore;
/*
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 * Example 1:
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 * Constraints:
 * 10 <= low <= high <= 10^9
 */
import java.util.*;
public class SequentialDigits {
	public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result=new ArrayList<Integer>();
        HashSet<Integer> hs= new HashSet<Integer>();
        for(int i=1; i<= 9; i++) {
        	generateNumbers(low, high, i,0,hs);
        }
        Iterator<Integer> it=hs.iterator();
        while(it.hasNext()) result.add(it.next());
        Collections.sort(result);
        return result;
    }
	private void generateNumbers(int low, int high, int digit,int num, HashSet<Integer> hs) {
		if(num >= low && num <=high) hs.add(num);
		if(num > high || digit > 9) return;
		generateNumbers(low, high, digit+1,10*num+digit,hs);
	}
	public static void main(String[] args) {
		SequentialDigits instance= new SequentialDigits();
		System.out.println(instance.sequentialDigits(100, 300));
		System.out.println(instance.sequentialDigits(123, 300));
		System.out.println(instance.sequentialDigits(1000, 13000));
		System.out.println(instance.sequentialDigits(58, 155));
	}

}
