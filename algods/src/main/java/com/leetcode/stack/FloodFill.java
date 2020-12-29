package com.leetcode.stack;
/* Flood Fill
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
import java.util.*;
public class FloodFill {
	/*BFS O(m*n) O(m+n) */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int rows=image.length, cols=image[0].length;
        int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
        HashSet<Integer> visited=new HashSet<>();
        Deque<int[]> queue= new ArrayDeque<>();
        int oldColor=image[sr][sc];
//        if(oldColor == newColor) return image;// to stop 
        queue.offerLast(new int[] {sr,sc});// equivalent to Offer()
        while(!queue.isEmpty()) {
        	int[] point=queue.pollFirst();// equivalent to poll()
        	if(visited.add(100*point[0]+point[1])) image[point[0]][point[1]]=newColor;
        	for(int[] d: dir) {
        		int r=d[0]+point[0];
        		int c=d[1]+point[1];
        		if(r <0 || c<0 || r >= rows || c>= cols || image[r][c] != oldColor || visited.contains(100*r+c)) continue;
        		else queue.offerLast(new int[] {r,c});
        	}
        }
        return image;
    }
	public static void main(String[] args) {
		new FloodFill().floodFill(new int[][] {{0,0,0},{0,1,1}},1, 1, 1);
	}
}
