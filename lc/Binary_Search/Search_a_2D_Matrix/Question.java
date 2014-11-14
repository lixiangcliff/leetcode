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
	//http://blog.csdn.net/linhuanmars/article/details/24216235
    public static boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length==0 || matrix[0].length==0)  
            return false; 
    	//处理所有行的第0个元素
    	int l= 0;
    	int r = matrix.length-1;
    	while(l <= r){
    		int mid = (l+r)/2;
    		if (target == matrix[mid][0]){
    			return true;
    		}else if(target > matrix[mid][0]){//target在右半边，所以重置左窗口
    			l = mid+1;
    		}else{
    			r = mid-1; //找的是比target小的最大值
    		}
    	}
    	int row = r;
    	if (r < 0){//r越界，代表target比matrix[0][0]还要小，所以matrix里不包含target
    		return false;
    	}
    	//处理这一行(row)的所有列
    	l = 0;
    	r = matrix[0].length-1;
    	while(l <= r){
    		int mid = (l+r)/2;
    		if (target == matrix[row][mid]){
    			return true;
    		}else if(target > matrix[row][mid]){
    			l = mid+1;
    		}else{
    			r = mid-1;
    		}
    	}
    	return false;
    }
}
