package Unique_Paths_II;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid = {
				{0,1,0,0},
				{0,0,0,0},
				{0,1,0,0},
				{0,0,0,0},
		};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));

	}
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // row
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        
        //process first row
        boolean foundObstacle = false; 
        for (int i=0;i<n; i++){
        	if (foundObstacle){
        		result[0][i] = 0;
        	}else if (obstacleGrid[0][i] == 0){
        		result[0][i] = 1;
        	}else {
        		result[0][i] = 0;
        		foundObstacle = true;
        	}
        }
        
        //process first col
/*        foundObstacle = false;
        for (int i=0;i<m; i++){
        	if (foundObstacle){
        		result[i][0] = 0;
        	}else if (obstacleGrid[i][0] == 0){
        		result[i][0] = 1;
        	}else {
        		result[i][0] = 0;
        		foundObstacle = true;
        	}
        }*/
        //this is better 
        //http://answer.ninechapter.com/solutions/unique-paths-ii/
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                result[i][0] = 1;
            } else {
                break;
            }
        }
        
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		result[i][j] = obstacleGrid[i][j] == 0 ? result[i-1][j] + result[i][j-1] : 0;
        	}
        }
        return result[m-1][n-1];    
    }
	
}
