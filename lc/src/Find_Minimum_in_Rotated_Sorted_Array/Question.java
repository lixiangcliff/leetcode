package Find_Minimum_in_Rotated_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int findMin(int[] num) {
        if(num == null || num.length == 0){
        	return Integer.MAX_VALUE;
        }
        for(int i=1;i<num.length;i++){
        	if(num[i]<num[0]){
        		return num[i];
        	}
        }
        return num[0];
    }

}
