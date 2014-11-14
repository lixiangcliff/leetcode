package Search_a_2D_Matrix;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] matrix = new int[n][n];
		for (int i=0;i<n;i++){
			for (int j=0; j<n;j++){
				matrix[i][j] = i*n + j+1;
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println( "");
		}
		System.out.println( "==========");
		System.out.println( searchMatrix(matrix, 36));
		

	}
    public static boolean searchMatrix(int[][] matrix, int target) {
    	
    	int rowLen = matrix.length;
    	int colLen = matrix[0].length;
    	int up= 0;
    	int left = 0;
    	int down = rowLen-1;
    	int right = colLen-1;
    	int findRow = 0;
    	while(up <= down){
    		int mid = (up+down)/2;
    		if (target == matrix[mid][0]){
    			return true;
    		}else if(target < matrix[mid][0]){
    			down = mid-1;
    		}else{
    			findRow = mid;
    			up = mid+1;
    		}
    	}    	
    	while(left <= right){
    		int mid = (left+right)/2;
    		if (target == matrix[findRow][mid]){
    			return true;
    		}else if(target < matrix[findRow][mid]){
    			right = mid-1;
    		}else{
    			left = mid+1;
    		}
    	}
    	return false;
    }
}
