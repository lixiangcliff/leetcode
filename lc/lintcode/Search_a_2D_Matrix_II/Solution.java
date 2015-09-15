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
	 * http://lintcode.com/en/problem/search-a-2d-matrix-ii/
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix, return the occurrence of it.
	 * This matrix has the following properties:
	 * Integers in each row are sorted from left to right.
	 * Integers in each column are sorted from up to bottom.
	 * No duplicate integers in each row or column.
	 * 
	 * Example Consider the following matrix:
	 * [
	 * 	[1, 3, 5, 7],
	 * 	[2, 4, 7, 8],
	 * 	[3, 5, 9, 10]
	 * ]
	 * Given target = 3, return 2.
	 * 
	 * Challenge O(m+n) time and O(1) extra space
	 */
	
    public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
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
