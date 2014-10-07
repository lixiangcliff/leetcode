package Unique_Paths;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(uniquePaths(100, 100)); 
	}
	//time out from leetcode...
   /* public static int uniquePaths(int m, int n) {
    	int[][] result = new int[m][n];
        return findUniquePaths(result,m-1,n-1);        
    }

    private static int findUniquePaths(int[][] result, int m, int n) { 
    	if (m < 0 || n < 0){
    		return 0;
    	}
    	if ( m ==0 && n ==0){
    		return 1;
    	}else{
    		result[m][n] = findUniquePaths(result, m-1, n) + findUniquePaths(result, m, n-1);
    		return result[m][n];
    	}
    }*/
	// a good way from http://answer.ninechapter.com/solutions/unique-paths/
	public static long uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
	            return 0;
	        }
		long[][] result = new long[m][n];
    	for (int i=0; i< m; i++){
    		result[i][0] = 1;
    	}
    	for (int i=1; i< n; i++){
    		result[0][i] = 1;
    	}
    	for (int i= 1; i<m; i++){
    		for (int j=1; j<n;j++){
    			result[i][j] = result[i-1][j] + result[i][j-1];
    		}
    	}
    	return result[m-1][n-1];
    }

}
