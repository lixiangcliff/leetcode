package Pascals_Triangle;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * https://oj.leetcode.com/problems/pascals-triangle/
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * 
	 * For example, given numRows = 5, Return
	 * 
	 * [ 
	 * 	   [1], 
	 * 	  [1,1], 
	 * 	 [1,2,1], 
	 * 	[1,3,3,1], 
	 * [1,4,6,4,1] 
	 * ]
	 * 
	 */

	//easier to understand
	//http://www.cnblogs.com/huntfor/p/3859522.html
	public ArrayList<ArrayList<Integer>> generate(int numRows){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0){
			return result;
		}
		ArrayList<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(1);
		result.add(firstRow);
		ArrayList<Integer> preRow = firstRow;
		for(int i=1; i< numRows ;i++){//还剩numRows-1行要处理
			ArrayList<Integer> newRow = getRow(preRow);
			result.add(newRow);
			preRow = newRow;//更新preRow
		}
		return result;
	}
	
	//通过上一行，来得到当前行
	private ArrayList<Integer> getRow(ArrayList<Integer> preRow){
		int last = preRow.size()-1;
		ArrayList<Integer> newRow = new ArrayList<Integer>();
		newRow.add(1);
		//上一行相邻两个相加，产生的新元素加入到list里
		for(int i=0;i<=last-1;i++){
			newRow.add(preRow.get(i) + preRow.get(i+1));
		}
		newRow.add(1);
		return newRow;
	}

}
