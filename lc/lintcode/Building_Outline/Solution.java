package Building_Outline;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * http://www.lintcode.com/en/problem/building-outline/
	 * Given N buildings in a x-axis，each building is a rectangle and can be represented by a triple (start, end, height)，
	 * where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building. 
	 * Buildings may overlap if you see them from far away，find the outline of them.
	 * An outline can be represented by a triple, (start, end, height), where start is the start position on x-axis of the outline, 
	 * end is the end position on x-axis and height is the height of the outline.

		Building Outline
		http://www.lintcode.com/media/problem/jiuzhang3.jpg
		
		Example
		Given 3 buildings：
		
		[
		  [1, 3, 3],
		  [2, 4, 4],
		  [5, 6, 1]
		]
		The outlines are：
		
		[
		  [1, 2, 3],
		  [2, 4, 4],
		  [5, 6, 1]
		]
		Note
		Please merge the adjacent outlines if they have the same height and make sure different outlines cant overlap on x-axis.
	 */
	
	//aka skyline problem
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	return res;
    }
}
