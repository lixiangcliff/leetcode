package Search_Insert_Position;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = {1,3,5,6};
		System.out.println(searchInsert(A, 0));
	}
	
	public static int searchInsert(int[] A, int target) {
		
		if (A.length<1){
			return 0;
		}
		for(int i=0; i<A.length;i++){
			if(target <= A[i]){
				return i;
			}
		}
		return A.length;
        
    }

}
