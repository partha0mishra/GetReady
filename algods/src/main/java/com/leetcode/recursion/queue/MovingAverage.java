package com.leetcode.recursion.queue;
/* 346. Moving Average from Data Stream
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
import java.util.*;
public class MovingAverage {
	/* Sliding window - use DEQUE
	 * O(1) O(N)
	 * */
	Deque<Integer> q;
	int size,count;
	double sum;
	/** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.q=new ArrayDeque<>();
        this.size=size;
        this.sum=0;
        this.count=0;
    }
    
    public double next(int val) {
        q.addLast(val);
        sum+=val;
        count+=1;
        if(count > size) {
        	sum-=q.pollFirst();
        	count-=1;
        }
        return (double)sum/count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */