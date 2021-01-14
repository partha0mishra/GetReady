package com.leetcode.design;
/** TODO Anki
 * 295. Find Median from Data Stream
 * Median is the middle value in an ordered integer list. If the size of the list is even, 
 * there is no middle value. So the median is the mean of the two middle value.
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
	/**
	 * Accepted version BUT worse in performance
	 * Although thought TreeSet will be more performant considering the removal is O(1) while
	 * removal is O(n) in PQ for java
	 * Probably tricks to keep duplicate elements were costly
	 */
	TreeSet<Integer> maxHeap, minHeap;
//  /** initialize your data structure here. */
	  public MedianFinder() {
	      maxHeap=new TreeSet<>((i1, i2) ->{
	    	  int diff=Integer.compare(i1,i2);
	    	  return diff==0? 1: diff;
	      });// forward order but keeping duplicate keys
	      minHeap=new TreeSet<>((i1,i2) ->{
	    	  int diff=Integer.compare(i2,i1);
	    	  return diff==0? 1: diff;
	      });// reverse order but keeping duplicate keys
	  }
	  /**
	   * Add it to the maxHeap
	   * Now take the maxHeap's max and offer to minHeap
	   * if maxHeap.size < minHeap, take the min from minHeap and offer to maxheap
	   */
	  public void addNum(int num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.pollFirst());
		while(maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.pollFirst());
		}
	  }
	  
	  public double findMedian() {
		double median= maxHeap.first();
	  	if(maxHeap.size() == minHeap.size())
	  		median=(median + minHeap.first())*0.5;
	  	return median;
	  }
	/** => FIRST ACCEPTED VERSION
	 * Trying to move O(n) towards O(logN) 
	 * using 2 heaps  <smallest [maxHeap][minHeap] largest>
	 * if there are 2n elements, they will have n each
	 * if there are 2n+1 elements, maxHeap will have n+1 an minHeap will have n
	 * the top=max in maxHeap and top=min in minHeap are the median candidates 
	 */
//	PriorityQueue<Integer> maxHeap, minHeap;
////  /** initialize your data structure here. */
//	  public MedianFinder() {
//	      maxHeap=new PriorityQueue<>();
//	      minHeap=new PriorityQueue<>(Collections.reverseOrder());
//	  }
//	  /**
//	   * Add it to the maxHeap
//	   * Now take the maxHeap's max and offer to minHeap
//	   * if maxHeap.size < minHeap, take the min from minHeap and offer to maxheap
//	   */
//	  public void addNum(int num) {
//		maxHeap.offer(num);
//		minHeap.offer(maxHeap.poll());
//		while(maxHeap.size() < minHeap.size()) {
//			maxHeap.offer(minHeap.poll());
//		}
//	  }
//	  
//	  public double findMedian() {
//		double median= maxHeap.peek();
//	  	if(maxHeap.size() == minHeap.size())
//	  		median=(median + minHeap.peek())*0.5;
//	  	return median;
//	  }
	// Tried with Insertion sort
	// but moving elements after insertion point is still too costly
//	LinkedList<Integer> elements;
////  /** initialize your data structure here. */
//	  public MedianFinder() {
//	      elements= new LinkedList<>();
//	  }
//	  // handling with Insertion sort
//	  // but moving the elements after insertion point is still too costly to get out of TLE
//	  public void addNum(int num) {
//		LinkedList<Integer> temp= new LinkedList<>();
//	  	boolean added=false;
//	  	for(int e: elements) {
//	  		if(!added && e>num) {
//	  			temp.add(num);
//	  			added=true;
//	  		}
//	  		temp.add(e);
//	  	}
//	  	if(!added) temp.add(num);
//	  	elements=temp;
//	  }
//	  
//	  public double findMedian() {
//	  	int n=elements.size();
//	  	double median=elements.get(n/2+1-1);
//	  	if(n%2 ==0 ) median=(median + elements.get(n/2-1))/2;
//	  	return median;
//	  }
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
