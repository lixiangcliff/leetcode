package Remove_Duplicates_from_Sorted_Array_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {1,1,2,3,4,4,5,5,5,5,5,5,6,7,7,7,7};
		int[] A = {1,2,2};
		int length = removeDuplicates(A);
		System.out.println(length);
		for (int i=0;i<length;i++){
			System.out.print(A[i] + ",");
		}

	}
	//http://blog.csdn.net/linhuanmars/article/details/24343525
	//http://needjobasap.blogspot.com/2014/01/remove-duplicates-from-sorted-array-ii.html
    public static int removeDuplicates(int[] A) {
    	if(A ==  null || A.length == 0){
    		return 0;
    	}
    	int index = 1;
    	int count = 1;    	
    	for(int i=1; i< A.length;i++){
    		if(A[i-1] == A[i]){ 
    			count++;
    		}else{
    			count = 1;
    		}
    		if (count <=2){//只有count<=2时才把此元素继续保留在array中
    			A[index++] = A[i];
    		}
    	}
        return index;
    }
  
}