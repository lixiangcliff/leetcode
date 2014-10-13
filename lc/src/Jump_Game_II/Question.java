package Jump_Game_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,1,4};
		System.out.println(jump(A));
	}
	

	//http://blog.csdn.net/linhuanmars/article/details/21356187
	/*
	 * example that helps understanding:
	 * 
	 * 		 index: 0 1 2 3 4
	 * input array: 2 3 1 1 4
	 * longestJump: 3 4 3 4 8
	 * last  reach: 0 2 2 4 4  //each column means the farthest it can currently reach. e.g col2: value is 2, means it can reach to index 2 at the most, so we have to make one step(update lastReach into reach) to move further 
	 * 		 reach: 2 4 4 4 8
	 * 		  step:	0 1 1 2 2	
	 * 
	 */
	public static int jump(int[] A) {
		if(A== null || A.length == 0){
			return 0;
		}
		int reach = 0;
		int lastReach = 0;
		int step = 0;
		for(int i=0;i<A.length && reach >= i;i++){
			int longestJump = A[i] + i;
			if(lastReach < i){ //means lastReach cannot reach current i, we must make one more step to reach here; (meanwhile to update lastReach)
				step++;
				lastReach = reach;
			}
			reach = Math.max(longestJump, reach);
		}
		return reach >= A.length-1 ? step : 0;
	}

}
