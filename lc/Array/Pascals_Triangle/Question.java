package Pascals_Triangle;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
/*    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i =0;i<numRows;i++) {
            int number = 1;
            ArrayList<Integer> line = new ArrayList<Integer>();
            for(int j=0;j<=i;j++) {
                 line.add(number);
                 number = number * (i - j) / (j + 1);                
            }
            result.add(line);
        }
		return result;
    }*/
	
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
		for(int i=1; i< numRows ;i++){
			ArrayList<Integer> newRow = getRow(preRow);
			result.add(newRow);
			preRow = newRow;
		}
		return result;
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
	}

}
