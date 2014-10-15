package First_Missing_Positive;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A =  {3,4,4,4,-1,1};
		int[] A =  {3,4,-1,1};
		System.out.println(firstMissingPositive(A));
	}
	

	//http://blog.csdn.net/linhuanmars/article/details/20884585
	//our purpose it to make: A[0]==1, A[1]==2...
    public static int firstMissingPositive(int[] A) {
    	if (A == null || A.length == 0){
    		return 1;
    	}
    	for(int i=0;i<A.length;i++){
    		if(A[i] > 0 && A[i] <= A.length && A[i] != A[A[i]-1]){ // A[i] != A[A[i]-1]: means as long as value at "A[i]-1" is NOT value at "i", do swap 
    			//int temp = A[i]; //Wrong!! important!  
    			//A[i] = A[A[i]-1]; //because if A[A[i]-1] <= 0, then A[i] <=0, then A[i]-1 <= -1,
    			//A[A[i]-1] = temp; //then when doing "A[A[i]-1] = temp" will be out of array bounds
    			//but below swap will not cause similar issue
                int temp = A[A[i]-1];  
                A[A[i]-1] = A[i];  
                A[i] = temp;  
    			i--;// means will stay on current i, until value at "A[i]-1" EQUAl value at "i"
    		}
    	}
    	
    	for(int i=0; i<A.length;i++){
    		if(A[i] != i+1){
    			return i+1;
    		}
    	}
    	return A.length+1; // means: in A, it include values from "1" to "A.length()-1";
    }

}
