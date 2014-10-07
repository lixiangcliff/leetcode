package Remove_Element;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {5,1,5,1,2,4,8,5,3,8,5,1,2,4};
		int[] A = {};
		int a = removeElement(A,5);
		System.out.println(a);
		for(int i = 0; i<a; i++){
			System.out.print(A[i] + ",");
		}

	}
/*    public static int removeElement(int[] A, int elem) {
    	if(A.length == 0){
    		return 0;
    	}
    	int last=A.length-1;
    	for(int i=0; i<last;i++){
    		if(A[i] == elem){
    			while(last>i){
    				if(A[last] != elem){
    					A[i] = A[last];
    					last--;
    					break;
    				}
    				last--;
    			}
    		}
    	}
    	if (A[last] == elem){
    		last--;
    	}
    	return last+1;       
    }*/
    
    //simpler code below
    public static int removeElement(int[] A, int elem) {
        int i = 0;
        int pointer = A.length - 1;
        while(i <= pointer){
            if(A[i] == elem){
                A[i] = A[pointer]; //does not matter if A[pointer] equals elem too; 
                pointer--; //because i won't increase forward until A[i] successfully replace by a "non-elem" value
            } else {
                i++;
            }
        }
        return pointer + 1;
    }

}
