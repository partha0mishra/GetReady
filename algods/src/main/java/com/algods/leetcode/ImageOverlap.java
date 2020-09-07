package com.algods.leetcode;
/*
 * Two images A and B are given, represented as binary, square matrices of the same size.  
 * (A binary matrix has only 0s and 1s as values.)
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), 
 * and place it on top of the other image.  
 * After, the overlap of this translation is the number of positions that have a 1 in both images.
 * (Note also that a translation does not include any kind of rotation.)
 * What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1
 */
public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
    	int maxOverlap=0;
        int n=A.length;
        for(int row=1; row<=n; row++) {// how many rows I'm considering in each pass
        	for(int col=1; col<=n; col++) {// how many columns I'm considering in each pass
        		int overlap=getOverLap(A,B,row,col,n);
        		System.out.println(row+" "+col+" "+overlap);
        		if(overlap > maxOverlap) maxOverlap=overlap;
        	}
        }
        return maxOverlap;
    }
	private int getOverLap(int[][] a, int[][] b, int row, int col, int n) {
		int overlap1=0;
		int overlap2=0;
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				if(a[n-row+r][n-col+c] ==1 && b[r][c] ==1) overlap1+=1;
				if(b[n-row+r][n-col+c] ==1 && a[r][c] ==1) overlap2+=1;
			}
		}
		System.out.println("overlap1: "+overlap1+" overlap2: "+overlap2);
		return Math.max(overlap1, overlap2);
	}
	public static void main(String[] args) {
		int[][] input01= {  {1,1,0},
							{0,1,0},
							{0,1,0}};
		int[][] input02= {  {0,0,0},
							{0,1,1},
							{0,0,1}};
		ImageOverlap instance = new ImageOverlap();
		System.out.println(instance.largestOverlap(input01, input02));
	}

}
