package Spiral_Matrix_II;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	int n = 0;
	int[][] result = generateMatrix(n);	
		// TODO Auto-generated method stub
	for (int i = 0; i < n; i++){
		for (int j = 0; j < n; j++){
			System.out.print(result[i][j] + ",");
		}
		System.out.println();
	}
	}
	public static int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];
/*    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return result;*/
        int l = 0;
        int u = 0;
        int r = n-1;
		int d = n-1;
        int num = 0;
        int end = n*n;
        while(true){
        	//rightward
        	for(int i=l; i<= r; i++){
        		result[u][i] = ++num;
        	}   
        	if (num == end)
        		break;
        	//downward
        	for(int i=u+1; i<=d; i++){
        		result[i][r] = ++num;
        	}
        	if (num == end)
        		break;
        	//leftward
        	for(int i=r-1; i>=l; i--){
        		result[d][i] = ++num;
        	}  
        	if (num == end)
        		break;
        	//upward
        	for(int i=d-1; i>u; i--){
        		result[i][l] = ++num;
        	}
        	if (num == end)
        		break;
        	l++;
        	r--;
        	u++;
        	d--;
        }
        return result;
    }

}
