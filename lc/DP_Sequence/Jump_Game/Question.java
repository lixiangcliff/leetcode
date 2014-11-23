package Jump_Game;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,2,3};
		System.out.println(canJump(A));
	}
	
	//my way : O(n^2) time complex
/*    public static boolean canJump(int[] A) {
        if(A == null || A.length == 0 || A.length > 1 && A[0] == 0){
        	return false;
        }
        for(int i=A.length-1;i>0;i--){
        	if(A[i]==0){
        		boolean found = false;
        		for(int j=i-1;j>=0;j--){
        		    // i==A.length-1 && A[j]>=i-j ---- when 0 at last index
        		    // A[j]>i-j ---- when 0 at other index
        			if (i==A.length-1 && A[j]>=i-j || A[j]>i-j){
        				found = true;
        				break;
        			}
        		}
        		if (!found){
        			return false;
        		}
        	}
        }
        return true;
    }*/
	
	//O(n) time complex
	//http://blog.csdn.net/linhuanmars/article/details/21354751
	public static boolean canJump(int[] A) {
		if (A==null || A.length==0){
			return false;
		}
		//int global = A[0]; 
		//for(int i= 1; i< A.length-1;i++){
		//above and below both work!
		int global = 0;
		for(int i= 0; i< A.length-1;i++){ 
			if (global < i){ //means current global cannot reach current i;
				return false;
			}
			int local = A[i] + i;//at current i, local is the longest index it can reach
			global = Math.max(local, global); //"global" is longest index it can ever reach for each current i;
			if (global >= A.length-1){ // already find one index that can jump to the end directly
				return true;
			}
		}
		return (global >= A.length-1);
	}

}
