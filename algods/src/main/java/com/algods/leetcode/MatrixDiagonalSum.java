package com.algods.leetcode;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
    	if(mat.length == 1) return mat[0][0];
    	int first=0, result=0;
    	int last=mat[0].length -1;
        for(int row=0; row < mat.length; row++) {
        	System.out.println("Row: "+row+" first: "+first+" last: "+last);
        	if(mat.length %2 !=0 && last==mat.length/2) {
        		// do nothing
        		System.out.println("done nothing");
        		result+=mat[row][first];
        	}else {
        		result+=mat[row][first]+mat[row][last];
        	}
        	System.out.println("elements: "+mat[row][first]+" "+mat[row][last]+" result: "+result);
        	first++;
        	last--;
        }
        return result;
    }
	public static void main(String[] args) {
		MatrixDiagonalSum instance= new MatrixDiagonalSum();
		int[][] input01= {{1,2,3},
		                  {4,5,6},
		                  {7,8,9}};
		System.out.println(instance.diagonalSum(input01));
		int[][] input02= {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		System.out.println(instance.diagonalSum(input02));
		int[][] input03= {{5}};
		System.out.println(instance.diagonalSum(input03));
	}

}
