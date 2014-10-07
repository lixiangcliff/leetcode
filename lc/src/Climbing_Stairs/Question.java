package Climbing_Stairs;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(33));

	}
	// this will cause "Time Limit Exceeded" on leetcode, so we need dynamic programming to solve it.
/*	public static int climbStairs(int n) {
		if (n<=0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		
		if(n==2){
			return 2;
		}
		*//**
		 * for last climb you have and only have 2 way: 1 step or 2 step to finish;
		 * so to finish n stairs, we can group all methods into two groups
		 * group1 is to finish last climb by 1 step
		 * group2 is to finish last climb by 2 steps
		 * add them up we will get all methods;
		 * then we split the big problem into two small problems.
		 * i.e. 1. how we can leave 1 step before finish all n stairs
		 * 		2. how we can leave 2 step before finish all n stairs
		 * there comes the recursion
		 *//*
		return climbStairs(n-1)+climbStairs(n-2);         
    }*/
	/*public static int climbStairs(int n) {
		int[] map = new int[n+1];
		return climbStairsDP(n, map);
	}
	private static int climbStairsDP(int n, int[] map) {
		if(n<=0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}
		if(map[n]>0){
			return map[n];
		}	
		return map[n] = climbStairsDP(n-1, map) + climbStairsDP(n-2, map);
	}*/
	
	public static int climbStairs(int n){
		int[] map = new int[n+1];
		map[0] = 0;
		map[1] = 1;
		map[2] = 2;
		for(int i=3; i<=n; i++){
			map[i] =  map[i-1] + map[i-2];
		}
		return map[n];
		
	}

}
