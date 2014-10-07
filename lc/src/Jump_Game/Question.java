package Jump_Game;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,0,0};
		System.out.println(canJump(A));
	}
	
    public static boolean canJump(int[] A) {
        if(A == null || A.length == 0 || A.length > 1 && A[0] == 0){
        	return false;
        }
        for(int i=A.length-1;i>0;i--){
        	if(A[i]==0){
        		boolean found = false;
        		for(int j=i-1;j>=0;j--){
/*        			System.out.println("j:" + j);
        			System.out.println("A[j]:" + A[j]);
        			System.out.println("i-j:" + (i-j));
        			System.out.println("=========");*/
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
    }

}
