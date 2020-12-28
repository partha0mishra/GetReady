package com.leetcode.recursion;
/* 118. Pascal's Triangle
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
import java.util.*;
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result= new ArrayList<>();
        for(int r=0; r< numRows; r++){
            ArrayList<Integer> row=new ArrayList<>();
            for(int c=0; c<=r; c++){
                if(c==0 || c==r) row.add(1);
                else row.add(result.get(r-1).get(c)+result.get(r-1).get(c-1));
            }
            result.add(row);
        }
        return result;
    }
}
