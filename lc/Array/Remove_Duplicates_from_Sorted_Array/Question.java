package Remove_Duplicates_from_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] A = {1,1,2,3,4,4,5,5,5,5,5,5,6,7,7,7,7};
		int[] A = {1};
		// TODO Auto-generated method stub
		int length = removeDuplicates(A);
		System.out.println(length);
		for (int i=0;i<length;i++){
			System.out.println(A[i] + ",");
		}

	}
	
	//got runtime error on leetcode oj. don't know why..
 /*   public static int removeDuplicates(int[] A) {
    	if(A == null){
    		return 0;
    	}
    	if (A.length == 1){
    		return 1;
    	}
    	int current = 0;
    	int end = 1;
    	while(end < A.length){
    		while(A[current] == A[end]){
    			if (end == A.length-1){
    				return current+1;
    			}
    			end++;
    		}
    		A[++current] = A[end++];
    	}
        return current+1;
    }
    */
    //http://answer.ninechapter.com/solutions/remove-duplicates-from-sorted-array/   
    public static int removeDuplicates(int[] A) {
    	if(A == null || A.length==0){
    		return 0;
    	}
    	int size =0;
    	for (int i=0; i<A.length;i++ ){
    		if(A[size] != A[i]){
    			A[++size] = A[i];
    		}
    	}
    	return size+1;
    }

}
