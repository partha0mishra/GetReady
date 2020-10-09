package com.algods.leetcode.graph;
/* 959. Regions Cut By Slashes
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.
(Note that backslash characters are escaped, so a \ is represented as "\\".)
Return the number of regions.
Example 1:
Input:
[
  " /",
  "/ "
]
Output: 2
Explanation: The 2x2 grid is as follows:
Example 2:
Input:
[
  " /",
  "  "
]
Output: 1
Explanation: The 2x2 grid is as follows:
Example 3:
Input:
[
  "\\/",
  "/\\"
]
Output: 4
Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
The 2x2 grid is as follows:
Example 4:
Input:
[
  "/\\",
  "\\/"
]
Output: 5
Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
The 2x2 grid is as follows:
Example 5:
Input:
[
  "//",
  "/ "
]
Output: 3
Explanation: The 2x2 grid is as follows:
Note:
1 <= grid.length == grid[0].length <= 30
grid[i][j] is either '/', '\', or ' '.
 */
public class RegionsCutBySlashes {
	public int regionsBySlashes(String[] grid) {
        int[][] map=new int[grid.length*3][grid[0].length()*3];
        for(int i=0;i< grid.length; i++){
            char[] ca=grid[i].toCharArray();
            for(int j=0;j< ca.length; j++){
                if(ca[j] == '/'){
                    map[3*i]  [3*j+2] =-1;
                    map[3*i+1][3*j+1] =-1;
                    map[3*i+2][3*j]   =-1;
                }else if(ca[j] == '\\'){
                    map[3*i]  [3*j]   =-1;
                    map[3*i+1][3*j+1] =-1;
                    map[3*i+2][3*j+2] =-1;
                }
            }
        }
        printMap(map);
        int count=0;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        for(int row=0; row< map.length; row++)
            for(int col=0; col< map[0].length; col++)
                if(map[row][col] == 0)
                    dfs(map,row,col,++count,dir);
        return count;
    }
    private void dfs(int[][] map, int row, int col, int count, int[][] dir){
    	printMap(map);
        map[row][col]=count;
        for(int[] d: dir){
            int r=row+d[0], c=col+d[1];
            if(r>=0 && r<map.length && c>=0 && c<map[0].length && map[r][c]==0)
                dfs(map,r,c,count,dir);
        }
    }
    public static void main(String[] args) {
    	RegionsCutBySlashes instance= new RegionsCutBySlashes();
		String[] grid= new String[] {" /","/ "};
		System.out.println(instance.regionsBySlashes(grid));
	}
	private void printMap(int[][] map) {
		for(int i=0; i< map.length; i++) {
			for(int j=0; j< map[0].length; j++) 
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
}
