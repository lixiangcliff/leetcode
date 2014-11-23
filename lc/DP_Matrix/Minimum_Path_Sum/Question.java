package Minimum_Path_Sum;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//quite similar to unique path: https://oj.leetcode.com/problems/unique-paths/
	//http://fisherlei.blogspot.com/2012/12/leetcode-minimum-path-sum.html
   /* public int minPathSum(int[][] grid) {
    	if (grid.length == 0){
    		return 0;
    	}
    	int row  = grid.length;
    	int col = grid[0].length;
        int min[][] = new int[row][col];
        min[0][0] = grid[0][0];
        //initialize left most col
        for (int i=1; i<row; i++){
        	min[i][0] = min[i-1][0] + grid[i][0];
        }
      //initialize upper most row
        for (int i=1; i<col; i++){
        	min[0][i] = min[0][i-1] + grid[0][i];
        }
        
        for (int i=1; i<row;i++ ){
        	for(int j=1;j<col;j++){
        		min[i][j] =  Math.min(min[i-1][j], min[i][j-1]) + grid[i][j];
        	}
        }
        return min[row-1][col-1];
    }*/
	
	//row by row to update grid, only maintain the scroll array
	//http://joycelearning.blogspot.com/2013/10/leetcode-minimum-path-sum.html
	public int minPathSum(int[][] grid) {
       if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
		int row = grid.length;
		int col = grid[0].length;
		int scroll[] = new int[col];
		Arrays.fill(scroll, Integer.MAX_VALUE);
		//wrong!
		//scroll[0] = grid[0][0];
		scroll[0] = 0;
		for (int i=0; i < row;i++){
			scroll[0] += grid[i][0];
			for(int j=1;j<col;j++){
				scroll[j] = grid[i][j] + Math.min(scroll[j-1], scroll[j]);
			}
		}
		return scroll[col-1];
	}

}
