/*
Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and 
is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

import java.io.*;
import java.util.*;

class Islands {
	private int x, y;

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, 
						  { '1', '1', '0', '1', '0' }, 
						  { '1', '1', '0', '0', '0' }, 
						  { '0', '0', '0', '0', '0'} };

		System.out.println("Number of islands is " + new Islands().numIslands(grid));
	}
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        
        x = grid.length;
        
        if(x==0) return 0;
        
        y = grid[0].length;
        
        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                if(grid[i][j]=='1') {
                    markVisit(grid, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    
    public void markVisit(char[][] grid, int a, int b) {
        if(a<0 || b<0) return;
        if(a>=x||b>=y||grid[a][b]=='0') return;
        //visited[a][b] = true;
        grid[a][b] = '0';
        markVisit(grid, a, b+1);
        markVisit(grid, a+1, b);
        markVisit(grid, a-1, b);
        markVisit(grid, a, b-1);
    }
}