package com.leetcode.dp;
/**
 * Number of corner rectangles
 * 
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.

 

Example 1:

Input: grid = 
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1
Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 

Example 2:

Input: grid = 
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9
Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 

Example 3:

Input: grid = 
[[1, 1, 1, 1]]
Output: 0
Explanation: Rectangles must have four distinct corners.
 

Note:

The number of rows and columns of grid will each be in the range [1, 200].
Each grid[i][j] will be either 0 or 1.
The number of 1s in the grid will be at most 6000.
* 
* Hint:
* For each pair of 1s in the new row (say at `new_row[i]` and `new_row[j]`), we could create more rectangles 
* where that pair forms the base. The number of new rectangles is the number of times some previous row had `row[i] = row[j] = 1`.
 */


import java.util.*;
public class NumberCornerRectangles {
	public int countCornerRectangles(int[][] grid) {
        List<List<Integer>> rows = new ArrayList();
        int N = 0;
        for (int r = 0; r < grid.length; ++r) {
            rows.add(new ArrayList());
            for (int c = 0; c < grid[r].length; ++c)
                if (grid[r][c] == 1) {
                    rows.get(r).add(c);
                    N++;
                }
        }

        int sqrtN = (int) Math.sqrt(N);
        int ans = 0;
        Map<Integer, Integer> count = new HashMap();

        for (int r = 0; r < grid.length; ++r) {
            if (rows.get(r).size() >= sqrtN) {
                Set<Integer> target = new HashSet(rows.get(r));

                for (int r2 = 0; r2 < grid.length; ++r2) {
                    if (r2 <= r && rows.get(r2).size() >= sqrtN)
                        continue;
                    int found = 0;
                    for (int c2: rows.get(r2))
                        if (target.contains(c2))
                            found++;
                    ans += found * (found - 1) / 2;
                }
            } else {
                for (int i1 = 0; i1 < rows.get(r).size(); ++i1) {
                    int c1 = rows.get(r).get(i1);
                    for (int i2 = i1 + 1; i2 < rows.get(r).size(); ++i2) {
                        int c2 = rows.get(r).get(i2);
                        int ct = count.getOrDefault(200*c1 + c2, 0);
                        ans += ct;
                        count.put(200*c1 + c2, ct + 1);
                    }
                }
            }
        }
        return ans;
    }
}
