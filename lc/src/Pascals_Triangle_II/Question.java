package Pascals_Triangle_II;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result = getRow(4);
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i) + ",");
		}
	}
	
/*    public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> currentRow = new ArrayList<Integer>(); 
		if (rowIndex < 0){
			return currentRow;
		}
		ArrayList<Integer> preRow = new ArrayList<Integer>();
		preRow.add(1);
		currentRow = preRow;
		for(int i=0; i< rowIndex ;i++){
			currentRow = getRow(preRow);
			preRow = currentRow;
		}
		return currentRow;
    }
	
	private ArrayList<Integer> getRow(ArrayList<Integer> preRow){
		int count = preRow.size();
		ArrayList<Integer> newRow = new ArrayList<Integer>();
		newRow.add(1);
		for(int i=1;i<count;i++){
			newRow.add(preRow.get(i-1) + preRow.get(i));
		}
		newRow.add(1);
		return newRow;
	}*/
	
	//to use O(k) space only: rolling array
	//http://blog.csdn.net/abcbc/article/details/8982651
	//http://fisherlei.blogspot.com/2012/12/leetcode-pascals-triangle-ii.html
	
	public static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		if (rowIndex < 0){
			return result;
		}
		
		for (int i=0;i<=rowIndex;i++){
			result.add(0);
		}
		result.set(0, 1);
		for(int i=1;i<=rowIndex;i++){
			result.set(i, 1);
			for(int j=i-1;j>0;j--){
				result.set(j, result.get(j) + result.get(j-1));
			}
		}
		return result;
	}
}
