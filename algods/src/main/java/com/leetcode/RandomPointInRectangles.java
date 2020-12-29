package com.leetcode;
/*
 * Random Point in Non-overlapping Rectangles
Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

Note:

An integer point is a point that has integer coordinates. 
A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
Example 1:

Input: 
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output: 
[null,[4,1],[4,1],[3,3]]
Example 2:

Input: 
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output: 
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. 
Solution's constructor has one argument, the array of rectangles rects. 
pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
import java.util.*;
/* Approach 02: Copied - Cleaner 
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/discuss/155452/Java-TreeMap-solution-only-one-random-per-pick*/
class Solution {
    private int[][] rects;
    private Random r;
    private TreeMap<Integer, Integer> map;
    private int area;

    public Solution(int[][] rects) {
        this.rects = rects;
        r = new Random();
        map = new TreeMap<>();
        area = 0;
        for (int i = 0; i < rects.length; i++) {
            area += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            map.put(area, i);
        }
    }
    
    public int[] pick() {
        int randInt = r.nextInt(area);
        int key = map.higherKey(randInt);
        int[] rect = rects[map.get(key)];
        int x = rect[0] + (key - randInt - 1) % (rect[2] - rect[0] + 1);
        int y = rect[1] + (key - randInt - 1) / (rect[2] - rect[0] + 1);
        return new int[]{x, y};
    }
}
/* Approach 01: Copied
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/discuss/154130/Java-Solution.-Randomly-pick-a-rectangle-then-pick-a-point-inside.*/
//class Solution {
//	TreeMap<Integer, Integer> map;
//    int[][] rects;
//    int sum;
//    Random rnd= new Random();
//    
//    public Solution(int[][] rects) {
//        this.rects = rects;
//        map = new TreeMap<>();
//        sum = 0;
//        
//        for(int i = 0; i < rects.length; i++) {
//            int[] rect = rects[i];
//						
//            // the right part means the number of points can be picked in this rectangle
//            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
//			
//            map.put(sum, i);
//        }
//    }
//    
//    public int[] pick() {
//        // nextInt(sum) returns a num in [0, sum -1]. After added by 1, it becomes [1, sum]
//        int c = map.ceilingKey( rnd.nextInt(sum) + 1);
//        
//        return pickInRect(rects[map.get(c)]);
//    }
//    
//    private int[] pickInRect(int[] rect) {
//        int left = rect[0], right = rect[2], bot = rect[1], top = rect[3];
//        
//        return new int[]{left + rnd.nextInt(right - left + 1), bot + rnd.nextInt(top - bot + 1) };
//    }
//}
public class RandomPointInRectangles {

	public static void main(String[] args) {
		int[][] rects= new int[][]{{1,1,5,5}};
		 /* Your Solution object will be instantiated and called as such: */
		Solution obj = new Solution(rects);
		int[] param_1 = obj.pick(); System.out.println(Arrays.toString(param_1));
		int[] param_2 = obj.pick(); System.out.println(Arrays.toString(param_2));
		int[] param_3 = obj.pick(); System.out.println(Arrays.toString(param_3));
		
		int[][] rects1 = new int[][] {{-2,-2,-1,-1},{1,0,3,0}};
		Solution obj1 =  new Solution(rects1);
		int[] param_11 = obj1.pick(); System.out.println(Arrays.toString(param_11));
		int[] param_12 = obj1.pick(); System.out.println(Arrays.toString(param_12));
		int[] param_13 = obj1.pick(); System.out.println(Arrays.toString(param_13));
	}

}
