package Median_of_Two_Sorted_Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {2,4,8,10};
		int[] B = {1,3,5,7,9,11,13};
/*		int[] A = {1};
		int[] B = {2,3,4};*/
		
		System.out.println(findMedianSortedArrays(A, B));
		
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/19905515
	//http://blog.csdn.net/yutianzuijin/article/details/11499917
    public static double findMedianSortedArrays(int A[], int B[]) {
        if((A.length+B.length)%2==1){
        	//i2 or j2 means the last item in their array
        	return helper(A, B, 0, A.length-1, 0, B.length-1, (A.length+B.length)/2+1);
        }else{
        	return (helper(A, B, 0, A.length-1, 0, B.length-1, (A.length+B.length)/2)+
        			helper(A, B, 0, A.length-1, 0, B.length-1, (A.length+B.length)/2+1)) /2.0;
        }
    }
    
    private static double helper(int[] A, int[] B, int i, int i2, int j, int j2, int k){
    	//m for count of item for A, n for B;
    	//or consider m is the new end position if you make current i as index '0'
    	int m = i2-i+1;
    	int n = j2-j+1;
    	//always make sure "A" is the smaller one
    	if(m>n){
    		return helper(B, A, j, j2, i, i2, k);
    	}
    	if(m==0){
    		return B[j+k-1];
    	}
    	if(k==1){
    		return Math.min(A[i],B[j]);
    	}
    	//here is why we always make sure A has small size than B
    	int posA = Math.min(k/2, m);
    	int posB = k-posA;
    	//i+posA-1 is the true postion from A; simliar for B
    	if(A[i+posA-1] == B[j+posB-1]){
    		//find it! return either one.
    		return (A[i+posA-1]);
    	}else if(A[i+posA-1] < B[j+posB-1]){
    		//will abandon the small one's all "left" items(all item lefter than i+posA-1, including it). 
    		//and abandon the big one's all "right" from current item(all item righter than j+posB-1, excluding it).
    		//for k, substract posA from it
    		return helper(A, B, i+posA, i2, j, j+posB-1, k-posA);
    	}else{
    		return helper(A, B, i, i+posA-1, j+posB, j2, k-posB);
    	}
    }

}
