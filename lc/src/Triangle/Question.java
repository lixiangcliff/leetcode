package Triangle;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);
		
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(3);
		a2.add(4);
		
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(6);
		a3.add(5);
		a3.add(7);
		
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(4);
		a4.add(1);
		a4.add(8);
		a4.add(3);
		
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(a1);
		triangle.add(a2);
		triangle.add(a3);
		triangle.add(a4);
		
		System.out.println(minimumTotal(triangle));

	}
	
	//https://oj.leetcode.com/discuss/7313/problem-statment-should-updated-accepted-solution-approcah
	//to understand the question: "adjacent here means same index or index +1 and not index -1."
	//http://blog.sina.com.cn/s/blog_71d59f9a01017b85.html
	//use this idea: https://oj.leetcode.com/discuss/5337/dp-solution-for-triangle
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	int n = triangle.size();
    	int[] sum = new int[n+1];
    	for(int i=n-1;i>=0;i--){
    		//for(int j=0; j<=n; j++){ // wrong!!!
    		for(int j=0; j<=i; j++){ // j<=i !!
    			sum[j] = Math.min(sum[j], sum[j+1]) + triangle.get(i).get(j);
    		}
    	}
    	return sum[0];
    }

}
