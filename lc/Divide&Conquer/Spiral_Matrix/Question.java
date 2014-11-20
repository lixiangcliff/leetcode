package Spiral_Matrix;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix =  {{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }};
		ArrayList<Integer> result  = spiralOrder(matrix);
		for (int i = 0; i < result.size(); i++){
			System.out.print(result.get(i) + ",");
		}
	}
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return result;
        int l = 0;
        int r = matrix[0].length - 1;
        int u = 0;
        int d = matrix.length - 1;
        int size = matrix.length * matrix[0].length;
        while(true){
        	//rightward
        	for(int i=l; i<= r; i++){
        		result.add(matrix[u][i]);
        	}   
        	if (result.size() == size )
        		break;
        	//downward
        	for(int i=u+1; i<=d; i++){
        		result.add(matrix[i][r]);
        	}
        	if (result.size() == size )
        		break;
        	//leftward
        	for(int i=r-1; i>=l; i--){
        		result.add(matrix[d][i]);
        	}  
        	if (result.size() == size )
        		break;
        	//upward
        	for(int i=d-1; i>u; i--){
        		result.add(matrix[i][l]);
        	}
        	if (result.size() == size )
        		break;
        	l++;
        	r--;
        	u++;
        	d--;
        }
        return result;
    }
}
