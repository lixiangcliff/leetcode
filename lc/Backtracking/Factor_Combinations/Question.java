package Factor_Combinations;

import java.util.ArrayList;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		List<List<Integer>> result = q.getFactors(32);
		
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = (ArrayList<Integer>) result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}
	}
	
	/**
	 * Numbers can be regarded as product of its factors. For example,
			8 = 2 x 2 x 2;
		  	= 2 x 4.
		Write a function that takes an integer n and return all possible combinations of its factors.
		Note:
		Each combination’s factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
		You may assume that n is always positive.
		Factors should be greater than 1 and less than n.
		Examples:
		
		input: 1
		
		output:
		[]
		
		input: 37
		output:
		[]
		
		input: 12
		output:
		[
		  [2, 6],
		  [2, 2, 3],
		  [3, 4]
		]
		
		input: 32
		output:
		[
		  [2, 16],
		  [2, 2, 8],
		  [2, 2, 2, 4],
		  [2, 2, 2, 2, 2],
		  [2, 4, 4],
		  [4, 8]
		]																																			
	 */
	
	// 类似combination sum
	// https://leetcode.com/discuss/51250/my-recursive-dfs-java-solution
	public List<List<Integer>> getFactors(int n) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> item = new ArrayList<Integer>();
	    int start = 2;
	    helper(result, item , n, start);
	    return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
		if (n <= 1 && item.size() > 1) {
			result.add(new ArrayList<Integer>(item));
			return;
		}
	    for (int i = start; i <= n; i++) {
	        if (n % i == 0) {
				item.add(i);
				helper(result, item, n / i, i);
				item.remove(item.size() - 1);
	        }
	    }
	}
	
	//从大到小
	//http://www.shuatiblog.com/blog/2015/02/13/combination-of-factors/
/*	public List<List<Integer>> getFactors(int n) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> item = new ArrayList<Integer>();
	    int start = n / 2;
	    helper(result, item , n, start);
	    return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
		if (n == 1) {
			result.add(new ArrayList<Integer>(item));
	        return;
	    }
	    for (int i = start; i > 1; i--) {
	        if (n % i == 0) {
				item.add(i);
				helper(result, item, n / i, i);
				item.remove(item.size() - 1);
	        }
	    }
	}*/
	


}
