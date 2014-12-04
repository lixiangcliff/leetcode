package Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num = {1,1,1,2,2,2,2,2};
		Question q = new Question();
		ArrayList<ArrayList<Integer>> result = q.permuteUnique(num);
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}

	}
	
	/**
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations.
	 * 
	 * For example, 
	 * [1,1,2] have the following unique permutations: 
	 * [1,1,2], [1,2,1], and [2,1,1].
	 */
	//【注】因为元素可以重复，此题必须用boolean used[]来标记那些被使用过，哪些没有。
	//而不能像Permutations那样简单用item.contains(num[i])来判断item是否已经存在num[i]
	//这是因为，像例子中的即使是都是1和1，但是两个1是有顺序的，使用了一个做递归，就不能再用递归处理另一个，
	//否则就会出现重复，而used[]就可以来标记不同的1分别是哪一个位子的。item.contains(num[i])却做不到
	//
	//http://blog.csdn.net/linhuanmars/article/details/21570835
	//http://fisherlei.blogspot.com/2012/12/leetcode-permutations-ii.html
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length == 0){
    		return result;
    	}
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	boolean used[] = new boolean[num.length];
    	Arrays.sort(num);//important!
    	helper(result, item, num, used);
    	return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[] num, boolean used[]){
    	if(item.size() == num.length){
    		result.add(new ArrayList<Integer>(item));
    		return;
    	}
    	for(int i = 0; i < num.length; i++){
    		if (!used[i]) {//当前元素没用过，才可能做下面的递归，否则排除此i递归
    			//下面条件也要排除此i的递归："先判断前面的一个数是否和自己相等，相等的时候则前面的数必须使用了，自己才能使用，这样就能保证不会产生重复的排列。"
    			//(上面来自：http://fisherlei.blogspot.com/2012/12/leetcode-permutations-ii.html)
    			//理解为虽然数值相同，但是不同位子的元素在排列好的item中必须保持原来分别的位子
    			//举例说"假设有两个1，排序后位置不同，我们规定这两个1在排序中出现的顺序必须和数组中位置顺序一样，也就是第一个1只能出现在前面，第二个1只能出现在后面，这样就消除了重复解。
    			//对应到代码中，要排除的情况就是在前面的位置选择第二个1，这时检查发现第一个1还没用过就是这种情况，于是可以跳过了。"
    			//(上面来自评论： http://blog.csdn.net/linhuanmars/article/details/21570835)
	    		if(i > 0 && num[i - 1] == num[i] && !used[i - 1]){  
	    			continue;								
	    		}											
				used[i] = true;
	    		item.add(num[i]);
				helper(result, item, num, used);
				item.remove(item.size() - 1);
				used[i] = false;
    		}
    	}
    }
}
