package Sort_Colors;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,2,1,2,0,1,1,1,2,0};
		sortColors(A);
		for (int i=0;i<A.length;i++){
        	System.out.println(A[i] + ",");
        }

	}
    public static void sortColors(int[] A) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for (int i=0;i<A.length;i++){
        	if(A[i] == 0){
        		zeros++;
        	} else if(A[i] == 1){
        		ones++;
        	} else if(A[i] == 2){
        		twos++;
        	}
        }
        for(int i=0;i < A.length; i++){
        	if (i<zeros){
        		A[i] = 0;
        	}else if(i<ones+zeros){
        		A[i] = 1;
        	}else {
        		A[i] = 2;
        	}
        }
    }

}
