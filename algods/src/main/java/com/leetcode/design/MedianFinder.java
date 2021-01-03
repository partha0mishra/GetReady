package com.leetcode.design;
/**
 * 295. Find Median from Data Stream
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
for example,
[2,3,4], the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it? 
 */
import java.util.*;
public class MedianFinder {
	TreeMap<Integer,Integer> numFrequencies;
	int n;
    /** initialize your data structure here. */
    public MedianFinder() {
        numFrequencies= new TreeMap<>();
        n=0;
    }
    
    public void addNum(int num) {
        numFrequencies.put(num, numFrequencies.getOrDefault(num, 0)+1);
        n+=1;
    }
    
//    public double findMedian() {
//    	int cumu=0, pFreq=0, cFreq=0, prevNum=0, currentNum=0;
//    	for(int key: numFrequencies.keySet()) {
//    		currentNum=key; cFreq=numFrequencies.get(key);
//    		if(pFreq == 0) {prevNum=key; pFreq=cFreq;}
//    		cumu+=cFreq;
//    		if(cumu > n/2) break;
//    	}
//    	// odd: send out (n/2+1)th entry.
//    	// even: send out 
//    	double median=currentNum;// has to be the (n/2 +1)th entry
//    	if(n%2 ==0) {
//    		//if(cumu - counts[i] < n/2) - then it's the current number once more and then avg. better not to do anything
//    		if(cumu - cFreq== n/2) median=(median+prevNum)/2;
//    	}
//    	return median;
//    }
    /*
     * Approach 01: keeping counts and calculating cumulatives : TLE
     */
    public double findMedian() {
    	int[] nums=new int[numFrequencies.size()+1];
    	int[] counts=new int[numFrequencies.size()+1];
    	int i=0, cumu=0;
    	for(int key: numFrequencies.keySet()) {
    		nums[i]=key;
    		counts[i]=numFrequencies.get(key);
    		cumu+=counts[i];
    		if(cumu > n/2) break;
    		i++;
    	}
    	// odd: send out (n/2+1)th entry.
    	// even: send out 
    	double median=nums[i];// has to be the (n/2 +1)th entry
    	if(n%2 ==0) {
    		//if(cumu - counts[i] < n/2) - then it's the current number once more and then avg. better not to do anything
    		if(cumu - counts[i] == n/2) median=(median+nums[i-1])/2;
    	}
    	return median;
    }
	public static void main(String[] args) {
		MedianFinder mf=new MedianFinder();
		mf.addNum(1);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
	}

}
