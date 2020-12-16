package com.java.udemy.jp;

public class MultiDimensionalArrays {
	public static void main(String[] args) {
		int[][] grid= {{1,2,3},
				{1,2},
				{1,2,3,4}};
		for(int i=0; i< grid.length; i++) {
			int[] temp=grid[i];
			for(int j=0; j< temp.length; j++)
				System.out.println(grid[i][j]);
		}
	}
}
