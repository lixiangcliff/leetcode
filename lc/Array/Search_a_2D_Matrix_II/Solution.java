package Search_a_2D_Matrix_II;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
	/*
	 * 例子：to find count of 7
	 * [

	    [1, 3, 5, 7],
	
	    [2, 4, 7, 8],
	
	    [3, 5, 9, 10]

		]
	 */
    public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // write your code
    	if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) {
    		return 0;
    	}
    	//【注】之所以把起始点放在左下角，是为了使其处在整个matrix大致的中间值，这样根据遇到的值或更大或更小，可上（找更小的）可右（找更大的）。
    	int row = matrix.size() - 1;
    	int col = 0;
    	int count = 0;
    	while (row >= 0 && col <= matrix.get(0).size()-1){
    		if (matrix.get(row).get(col) == target) {
    			count++;
    			row--;
    		} else if (matrix.get(row).get(col) < target) {
    			col++;
    		} else {
    			row--;
    		}
    	}
    	
    	return count;
    }

}
