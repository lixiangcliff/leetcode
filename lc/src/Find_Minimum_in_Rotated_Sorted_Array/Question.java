package Find_Minimum_in_Rotated_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {4, 5, 6, 7, 0, 1, 2};
		//int[] A = {0, 1, 2,4, 5, 6, 7, };
		int[] A = {2,1 };
		System.out.println(findMin(A));
		
		
		
	}
	
    public static int findMin(int[] num) {
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
