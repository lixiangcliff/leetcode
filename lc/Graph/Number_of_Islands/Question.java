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
	
	//如果不可以改变原数组的话，就需要一个bool used[m][n]的辅助矩阵。
	//如果可以改变数组，则可以把所有已发现的陆地标记为‘2’， 然后最后再恢复为1.这样不需要额外空间，但是时间近似多一倍。
    public int numIslands(char[][] grid) {
    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
    		return 0;
    	}
    	int m = grid.length;
    	int n = grid[0].length;
    	boolean[][] used = new boolean[m][n];
    	int res = 0;
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (!used[i][j] && grid[i][j] == '1') { // 【注】每找到一个“陆地”，就开始做bfs穷尽和其相邻的陆地
    				used[i][j] = true;
    				int pos = i * n + j; //【注】技巧：用一个int表示x，y的坐标
    				LinkedList<Integer> queue = new LinkedList<Integer>();
    				queue.offer(pos);
    				while (!queue.isEmpty()) {
						pos = queue.poll(); // 每次拿到一个位置pos, 然后根据pos 恢复出row和col，然后上下左右分别试探。
						int row = pos / n;
						int col = pos % n;
						if (row > 0 && !used[row - 1][col] && grid[row - 1][col] == '1') { //可以往上走的三个条件：1往上走不越界；2上面一个没用过；3上面一个是陆地
							queue.offer(pos - n); //【注】要减去“列数”
							used[row - 1][col] = true; //该位置标记为访问过
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
    				res++; // 完成该块陆地的遍历。
    			}
    		}
    	}
    	return res;
    }
    
}
