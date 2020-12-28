package com.leetcode._explore;
/** Diagonal Traverse
 * Given a matrix of M x N elements (M rows, N columns), 
 * return all elements of the matrix in diagonal order as shown in the below image.
 * 
 * Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
Explanation:
Note:
The total number of elements of the given matrix will not exceed 10,000.
 */
import static org.junit.Assert.assertArrayEquals;
public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
		if(matrix == null || matrix.length ==0 || matrix[0].length==0) return new int[]{};
		final boolean UP=true;
		final boolean DOWN=false;
        int rows=matrix.length, cols=matrix[0].length, r=0,c=0, newRow, newCol;
        int[] result=new int[rows*cols];
        boolean dir=UP;
        for(int i=0; i< rows*cols; i++) {
        	System.out.println(r+", "+c);
        	result[i]=matrix[r][c];
        	if(dir == UP) {
        		newRow=r-1; newCol=c+1;
        		if(newRow < 0) {newRow=r; dir=DOWN;}
        		if(newCol == cols) {newCol=c; newRow=r+1; dir=DOWN;}
        	}else {
        		newRow=r+1; newCol=c-1;
        		if(newCol < 0) {newCol=c; dir=UP;}
        		if(newRow == rows) {newRow=r; newCol=c+1; dir=UP;}
        	}
        	r=newRow;
        	c=newCol;
        }
//        for(int res: result) System.out.printf("%3d", res);
        return result;
    }
	public static void main(String[] args) {
		DiagonalTraverse dt= new DiagonalTraverse();
		assertArrayEquals(new int[] {1},dt.findDiagonalOrder(new int[][] {{1}}));
		assertArrayEquals(new int[] {1,2},dt.findDiagonalOrder(new int[][] {{1},{2}}));
		assertArrayEquals(new int[] {1,2,3,4},dt.findDiagonalOrder(new int[][] {{1,2},{3,4}}));
		assertArrayEquals(new int[] {1,2,4,5,3,6},dt.findDiagonalOrder(new int[][] {{1,2,3},{4,5,6}}));
		assertArrayEquals(new int[] {1,2,4,7,5,3,6,8,9},dt.findDiagonalOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
		assertArrayEquals(new int[] {1,2,5,9,6,3,4,7,10,11,8,12},dt.findDiagonalOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
	}
}
