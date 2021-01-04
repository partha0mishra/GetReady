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
	LinkedList<Integer> elements;
//  /** initialize your data structure here. */
	  public MedianFinder() {
	      elements= new LinkedList<>();
	  }
	  // handling with Insertion sort
	  // but moving the elements after insertion point is still too costly to get out of TLE
	  public void addNum(int num) {
		LinkedList<Integer> temp= new LinkedList<>();
	  	boolean added=false;
	  	for(int e: elements) {
	  		if(!added && e>num) {
	  			temp.add(num);
	  			added=true;
	  		}
	  		temp.add(e);
	  	}
	  	if(!added) temp.add(num);
	  	elements=temp;
	  }
	  
	  public double findMedian() {
	  	int n=elements.size();
	  	double median=elements.get(n/2+1-1);
	  	if(n%2 ==0 ) median=(median + elements.get(n/2-1))/2;
	  	return median;
	  }
	/* More streamlined but still brute
	 * using Collections.sort() not going to cut through TLE
	 */
//	LinkedList<Integer> elements;
//    /** initialize your data structure here. */
//    public MedianFinder() {
//        elements= new LinkedList<>();
//    }
//    
//    public void addNum(int num) {
//    	elements.add(num);
//    	Collections.sort(elements);
//    }
//    
//    public double findMedian() {
//    	int n=elements.size();
//    	double median=elements.get(n/2+1-1);
//    	if(n%2 ==0 ) median=(median + elements.get(n/2-1))/2;
//    	return median;
//    }
	
	// Bruter approaches
//	TreeMap<Integer,Integer> numFrequencies;
//	int n;
//    /** initialize your data structure here. */
//    public MedianFinder() {
//        numFrequencies= new TreeMap<>();
//        n=0;
//    }
//    
//    public void addNum(int num) {
//        numFrequencies.put(num, numFrequencies.getOrDefault(num, 0)+1);
//        n+=1;
//    }
//    
//    /**
//     * Approach 02: keeping only previous num is enough
//     * Memory consumption is less but O(T) is still O(N) for each call
//     * that makes it O(N2)
//     */
//    public double findMedian() {
//    	int cumu=0, pFreq=0, cFreq=0, prevNum=0, currentNum=0;
//    	for(int key: numFrequencies.keySet()) {
//    		currentNum=key; cFreq=numFrequencies.get(key);
//    		if(pFreq == 0) {prevNum=currentNum; pFreq=cFreq;}
//    		cumu+=cFreq;
//    		if(cumu > n/2) break;
//    		prevNum=currentNum; pFreq=cFreq;
//    	}
//    	// odd: send out (n/2+1)th entry.
//    	// even: send out 
//    	double median=currentNum;// has to be the (n/2 +1)th entry
//    	if(n%2 ==0) {
//    		if(cumu - cFreq== n/2) median=(median+prevNum)/2;
//    	}
//    	return median;
//    }
    /*
     * Approach 01: keeping counts and calculating cumulatives : TLE
     */
//    public double findMedian() {
//    	int[] nums=new int[numFrequencies.size()+1];
//    	int[] counts=new int[numFrequencies.size()+1];
//    	int i=0, cumu=0;
//    	for(int key: numFrequencies.keySet()) {
//    		nums[i]=key;
//    		counts[i]=numFrequencies.get(key);
//    		cumu+=counts[i];
//    		if(cumu > n/2) break;
//    		i++;
//    	}
//    	// odd: send out (n/2+1)th entry.
//    	// even: send out 
//    	double median=nums[i];// has to be the (n/2 +1)th entry
//    	if(n%2 ==0) {
//    		//if(cumu - counts[i] < n/2) - then it's the current number once more and then avg. better not to do anything
//    		if(cumu - counts[i] == n/2) median=(median+nums[i-1])/2;
//    	}
//    	return median;
//    }
	public static void main(String[] args) {
		MedianFinder mf=new MedianFinder();
//		mf.addNum(1);
//		System.out.println(mf.findMedian());
//		mf.addNum(2);
//		System.out.println(mf.findMedian());
//		mf.addNum(3);
//		System.out.println(mf.findMedian());
//		===
		mf=new MedianFinder();
		mf.addNum(-1);
//		System.out.println(mf.findMedian());
		mf.addNum(-2);
//		System.out.println(mf.findMedian());
		mf.addNum(-3);
//		System.out.println(mf.findMedian());
		mf.addNum(-4);
		System.out.println(mf.findMedian());
		mf.addNum(-5);
		System.out.println(mf.findMedian());
	}

}
