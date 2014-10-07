package Merge_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,7, 0 , 0 , 0 , 0};
		int[] B = {2,6,8};
		//int[] B = {};
		int aLen = 4;
		merge(A, aLen, B, B.length);
		for(int i=0;i< aLen+B.length;i++){
			System.out.println(A[i]+ ",");
		}

	}
 /*   public static void merge(int A[], int m, int B[], int n) {
    	if (m==0 && n==0){
    		return;
    	}
    	if (m==0){
    		for (int i=0;i<n;i++){
    			A[i] = B[i];
    		}
    		return;
    	}
    	if(n==0){
    		return;
    	}
    	m--;
    	n--;
        for (int end = m+n+1;end >=0;end--){
        	if(m>=0 && n>=0){
        		if(A[m] <= B[n]){
        			A[end] = B[n--];
        		}else{
        			A[end] = A[m--];
        		}
        	}else if(n>=0){
        		A[end] = B[n--];
        	}else{
        		return;
        	}
        	
        }
        return;
    }*/
    
    //simpler code
    //http://answer.ninechapter.com/solutions/merge-sorted-array/
    public static void merge(int A[], int m, int B[], int n) {
    	//dont need extra code to take care of when m==0 or n==0 because code below will deal with it; 
    	int end = m + n;
		while(m>0 && n>0){
			if(A[m-1] <= B[n-1]){ // now only compare, so do not decrement!
				A[--end] = B[--n];
			}else{
				A[--end] = A[--m];
			}
		}
		while(n>0){//i.e B[] still has element to process
			A[--end] = B[--n];
		}
		//we do need to consider while(m>0), because the rest of A[] will be ok to leave it there
    	return;
    }
}
