package com.leetcode.recursion.binarySearch;
/*
 * 278. First Bad Version [EASY]
 * 
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version. 
 */
import static org.junit.Assert.assertEquals;
/**
 * CLASSIC Binary Search
 * First, we initialize left = 1 and right = n to include all possible values. 
 * Then we notice that we don't even need to design the condition function. 
 * It's already given by the isBadVersion API. 
 * Finding the first bad version is equivalent to finding the minimal k satisfying isBadVersion(k) is True. 
 * Our template can fit in very nicely.
 */
public class FirstBadVersion {
	int firstBadVersion;
	public FirstBadVersion(int first) {this.firstBadVersion=first;}
	private boolean isBadVersion(int n) {return n>=firstBadVersion? true: false;}
	public int firstBadVersion(int n) {
		int left=1, right=n;
		while(left<right) {
			int mid=left+(right-left)/2;
			if (isBadVersion(mid)) right=mid;
			else left=mid+1;
		}
		return left;
    }
	public static void main(String[] args) {
		FirstBadVersion instance = new FirstBadVersion(4);
		assertEquals(4,instance.firstBadVersion(5));
		assertEquals(4,instance.firstBadVersion(10));
		instance = new FirstBadVersion(1);
		assertEquals(1,instance.firstBadVersion(0));
		assertEquals(1,instance.firstBadVersion(5));
		assertEquals(1,instance.firstBadVersion(10));
	}

}
