package Search_a_2D_Matrix;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
/*		int n = 6;
		int[][] matrix = new int[n][n];*/
		//int[][] matrix = {{1},{3}};
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		
		for (int i=0;i<matrix.length;i++){
			for (int j=0; j<matrix[0].length;j++){
				//matrix[i][j] = i*n + j+1;
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println( "");
		}
		System.out.println( "==========");
		System.out.println( q.searchMatrix(matrix, -5));
		

	}
	
	/**
	 * https://oj.leetcode.com/problems/search-a-2d-matrix/
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. 
	 * The first integer of
	 * each row is greater than the last integer of the previous row. For
	 * example,
	 * Consider the following matrix:
	 * 
	 * [ 
	 * 	[1, 3, 5, 7], 
	 * 	[10, 11, 16, 20], 
	 * 	[23, 30, 34, 50] 
	 * ] 
	 * 
	 * Given target = 3, return true.
	 */
	
	//BST模板。看【注】！
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length==0 || matrix[0].length==0)  
            return false; 
    	//处理所有行的第0个元素
    	int start= 0;
    	int end = matrix.length-1;
    	//用模板。即求第0列中，等于target值的，或者比target小的最大值   	
    	while ( start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (matrix[mid][0] == target) {//求比target小的最大值，所以窗口尽量左移
    			return true;
    		} else if (matrix[mid][0] < target){
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	int row;
    	//【注】BST的模板的核心就在这里了！要找的是等于target或者比target小的里面最大的，两个候选start和end，end肯定比start的值大，所以先试end
    	if (matrix[end][0] <= target) {
    		row = end;
    	}else {
    		row = start;
    	}
    	if (matrix[row][0] > target) {//【注】由上面可知，matrix[row][0]小于等于target的。即使这样如果仍有matrix[row][0] > target，则说明matrix里不包含target
    		return false;
    	}
    	//处理这一行(row)的所有列
    	start = 0;
    	end = matrix[0].length-1;
    	//用模板。
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (matrix[row][mid] == target) {
    			return true;
    		}else if(matrix[row][mid] < target){
    			start = mid;
    		}else{
    			end = mid;
    		}
    	}
    	if (matrix[row][start] == target || matrix[row][end] == target) {
    		return true;
    	}
    	return false;
    }
}
