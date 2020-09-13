package com.algods.leetcode;
import java.util.*;
import static org.junit.Assert.assertEquals;
public class SpecialPositionBinaryMatrix {
	public int numSpecial(int[][] mat) {
        HashMap<Integer,Integer> rowPossible= new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> columnPossible= new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> rowImpossible= new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> columnImpossible= new HashMap<Integer, Integer>();
        for(int row=0; row<mat.length; row++)
        	for(int col=0;col<mat[0].length; col++) {
        		if(mat[row][col] ==0) continue;
        		if(rowImpossible.containsKey(row) && columnImpossible.containsKey(col))
        			continue;
        			
    			if(rowPossible.containsKey(row) && !rowImpossible.containsKey(row)){
    				rowPossible.remove(row);
    				rowImpossible.put(row, col);
    			}else {
    				rowPossible.put(row, col);
    			}
        			
    			if(columnPossible.containsKey(col) && !columnImpossible.containsKey(col)) {
    				columnPossible.remove(col);
    				columnImpossible.put(col, row);
    			}else {
    				columnPossible.put(col, row);
    			}
        	}
        int result=0;
        for(int r: rowPossible.keySet()) {
        	if(columnPossible.containsKey(rowPossible.get(r)) && !rowImpossible.containsKey(r)) result++;
        }
        return result;
    }
	public static void main(String[] args) {
		SpecialPositionBinaryMatrix instance = new SpecialPositionBinaryMatrix();
		int[][] matrix1=new int[][]{{1,0,0},
									{0,0,1},
									{1,0,0}};
//		assertEquals(1,instance.numSpecial(matrix1));
		int[][] matrix2=new int[][] {{1,0,0},
									 {0,1,0},
									 {0,0,1}};
//	    assertEquals(3,instance.numSpecial(matrix2));
	    int[][] matrix3=new int[][] {{0,0,0,1},
			 						 {1,0,0,0},
			 						 {0,1,1,0},
			 						 {0,0,0,0}};
//	    assertEquals(2,instance.numSpecial(matrix3));
	    int[][] matrix4=new int[][] {{0,0,0,0,0},
									 {1,0,0,0,0},
									 {0,1,0,0,0},
									 {0,0,1,0,0},
									 {0,0,0,1,1}};
//		assertEquals(3,instance.numSpecial(matrix4));
		int[][] matrix5=new int[][] {{0,0,0,0,0,1,0,0}
									,{0,0,0,0,1,0,0,1}
									,{0,0,0,0,1,0,0,0}
									,{1,0,0,0,1,0,0,0}
									,{0,0,1,1,0,0,0,0}};
		assertEquals(1,instance.numSpecial(matrix5));
		assertEquals(0,instance.numSpecial(new int[][] {
			{0,0,0,0},
			{0,1,0,0},
			{0,0,0,0},
			{0,0,0,0},
			{0,1,0,0},
			{0,0,0,0},
			{0,0,0,0},
			{0,1,1,0}}));
	}

}
