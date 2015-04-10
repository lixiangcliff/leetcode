package Number_of_Islands;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		//char[][] grid = {{'1','0','1','0','1','1'}};
		//char[][] grid = {{'1'},{'0'},{'1'},{'0'},{'1'},{'1'}};
		char[][] grid = {{'1'}};
		System.out.println(q.numIslands(grid));

	}
	
	/**
	 * https://leetcode.com/problems/number-of-islands/
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
	 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
	 * You may assume all four edges of the grid are all surrounded by water.
		Example 1:
		
		11110
		11010
		11000
		00000
		Answer: 1
		
		Example 2:
		
		11000
		11000
		00100
		00011
		Answer: 3
	 */
	
	//
    public int numIslands(char[][] grid) {
    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
    		return 0;
    	}
    	int m = grid.length;
    	int n = grid[0].length;
    	boolean[][] used = new boolean[m][n];
    	int[] res = new int[1];
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (!used[i][j] && grid[i][j] == '1') {
    				used[i][j] = true;
    				int pos = i * n + j;
    				LinkedList<Integer> queue = new LinkedList<Integer>();
    				queue.offer(pos);
    				while (!queue.isEmpty()) {
    					int size = queue.size();
    					for (int k = 0; k < size; k++) {
    						pos = queue.poll();
    						int row = pos / n;
    						int col = pos % n;
    						if (row > 0 && !used[row - 1][col] && grid[row - 1][col] == '1') {
    							queue.offer(pos - n); //【注】要减去一个列的长度
    							used[row - 1][col] = true;
    						}
    						if (row < m - 1 && !used[row + 1][col] && grid[row + 1][col] == '1') {
    							queue.offer(pos + n);
    							used[row + 1][col] = true;
    						}
    						if (col > 0 && !used[row][col - 1] && grid[row][col - 1] == '1') {
    							queue.offer(pos - 1);
    							used[row][col - 1] = true;
    						}
    						if (col < n - 1 && !used[row][col + 1] && grid[row][col + 1] == '1') {
    							queue.offer(pos + 1);
    							used[row][col + 1] = true;
    						}
    					}
    				}
    				res[0]++;
    			}
    		}
    	}
    	return res[0];
    }
    
}
