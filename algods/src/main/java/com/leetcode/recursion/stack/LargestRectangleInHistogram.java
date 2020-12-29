package com.leetcode.recursion.stack;
// TODO Anki
/* 84. Largest Rectangle in Histogram
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * Example:
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class LargestRectangleInHistogram {
	/* Approach: Monotonic Stack keeping indices
	 * REF: https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	 * 
	 * when we peek() a bar greater than the current one, we pop it. Keep popping this way.
	 * Which means, all the ones that are getting popped were Smaller in order (from right to left)
	 * 
	 * Key Points:
	 * When a bar is popped, we calculate the area with the popped bar at index tp as shortest bar. 
	 * Now we know the rectangle height is heights[tp], we just need rectangle width to calculate the area.
	 * How to determine rectangle width? The maximum width we can have here would be made of all connecting bars with 
	 * height greater than or equal to heights[tp]. heights[s.peek() + 1] >= heights[tp] because the index on top of 
	 * the stack right now s.peek() is the first index left of tp with height smaller than tp's height 
	 * (if s.peek() was greater then it should have already been poped out of the stack). heights[i - 1] >= heights[tp] 
	 * because index i is the first index right of tp with height smaller than tp's height (if i was greater then tp would 
	 * have remained on the stack). Now we multiply height heights[tp] by width i - 1 - s.peek() to get the area.
	 * */
	public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
	public static void main(String[] a) {
		LargestRectangleInHistogram lrh= new LargestRectangleInHistogram();
		assertEquals(1,lrh.largestRectangleArea(new int[] {1}));
		assertEquals(2,lrh.largestRectangleArea(new int[] {1,2}));
		assertEquals(4,lrh.largestRectangleArea(new int[] {1,2,3}));
		assertEquals(6,lrh.largestRectangleArea(new int[] {1,2,3,2}));
		assertEquals(8,lrh.largestRectangleArea(new int[] {1,2,3,2,7}));
		assertEquals(10,lrh.largestRectangleArea(new int[] {1,2,3,2,7,5}));
		assertEquals(20,lrh.largestRectangleArea(new int[] {1,2,3,2,7,5,6,6}));
		assertEquals(25,lrh.largestRectangleArea(new int[] {1,2,3,2,7,5,6,6,5}));
	}
}
