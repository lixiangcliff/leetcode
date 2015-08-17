package Binary_Tree_Maximum_Path_Sum;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
	 * Given a binary tree, find the maximum path sum.
		The path may start and end at any node in the tree.
		
		For example:
		Given the below binary tree,
		
		       1
		      / \
		     2   3
		     
		Return 6.
	 */
	
	//node中可能有负数
	//ninechapter解题思路更加清晰：看图！
	//singlePath: 从当前node到任意叶子的最大路径和（可以一个node都不取）
	//maxPath   :　包括当前node在内的，任意node到任意node最大路径和（至少要取一个node）
	//之所以在ResultType里要维护两个变量singlePath和maxPath，是因为：
	//我们最终想要的是maxPath。但是要得到maxPath的话，我们需要使用singlePath作为一个辅助值，来构造maxPath。
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		ResultType result = helper(root);
		return result.maxPath;
	}
	
	public ResultType helper (TreeNode root) { // 下面的注释如果看不懂，可以复习。
		//【注】递归跳出条件：当root走到叶子的left或者right时，即root==null时候，
		//我们要确保此时返回的ResultType里面的singlePath和maxPath不会对该叶子节点的singlePath和maxPath产生影响。
		//对叶子节点的singlePath来讲，根据题意，如果它的node.val>0, 则选node.val，否则就选0）
		//	又因为singlePath = Math.max((Math.max(left.singlePath, right.singlePath) + root.val), 0);
		//	则只有让left.singlePath和right.singlePath都为0，才能符合题意。即root == null时 singlePath == 0。
		//对叶子节点的maxPath来讲，无论它的node.val值是多少，都必须取。
		//	又因为maxPath = Math.max(Math.max(left.maxPath, right.maxPath), left.singlePath + right.singlePath + root.val);
		//	由上面可知left.singlePath和right.singlePath都为0，若要保证maxPath可以取到root.val， 则必须让left.maxPath和right.maxPath都为Integer.MIN_VALUE。
		if (root == null) {
			return new ResultType(0, Integer.MIN_VALUE); // 【注】maxPath要想取最大的，所以初始化的时候要尽量小，选MIN
		}
		//divide
		ResultType left = helper (root.left); 
		ResultType right = helper (root.right); 
		//conquer
		//当前的singlePath可能是左子树的最大singlePath，也可能是右子树的singlePath，也可能就是0（如果左右子树的singlePath都小于0的话）
		int singlePath = Math.max((Math.max(left.singlePath, right.singlePath) + root.val), 0); 
		//当前的maxPath：1.如果不包含当前root，可能是左子树或者右子树的maxPath；2.如果包含当前root，可能是左右子树的singlePath加上root值的和
		int maxPath = Math.max(Math.max(left.maxPath, right.maxPath), left.singlePath + right.singlePath + root.val);
		return new ResultType(singlePath, maxPath);
	}
	
	class ResultType{
		int singlePath;
		int maxPath;
		ResultType(int singlePath, int maxPath) {
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}
	
	
	
	//http://blog.csdn.net/linhuanmars/article/details/22969069
    public int maxPathSum2(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(Integer.MIN_VALUE);
        helper(root, result);
        return result.get(0);
    }
    
    private int helper(TreeNode root, ArrayList<Integer> result){
    	if(root == null){
    		return 0;
    	}
    	int left = helper(root.left, result);
    	int right = helper(root.right, result);
    	//"一个结点自身的最长路径就是它的左子树返回值（如果大于0的话），加上右子树的返回值（如果大于0的话），再加上自己的值。"
    	int cur = root.val + (left>0?left:0) + (right>0?right:0);
    	if(cur>result.get(0)){//如果当前值cur比结果大，则更新结果
    		result.set(0, cur);
    	}
    	//"函数的返回值定义为以自己为根的一条从根到子结点的最长路径，这个返回值是为了提供给它的父结点计算自身的最长路径用，"
    	//"返回值则自己的值加上  左子树返回值，或者右子树返回值，或者0（注意这里是“或者”，而不是“加上”，因为返回值只取一支的路径和）"
    	return root.val+(Math.max(left, Math.max(right, 0)));
    }
    //以下问答帮助理解
    // 	请问
    //	    1. 为什么cur(应该就是自身路径)和返回值 root.val+Math.max(left, Math.max(right,0))的计算式子略有不同呢？您上面提到了返回值是为了提供给它的父结点计算自身的最长路径用，但还是不太懂这和结点自身最长路径有什么不同？
    //	    2. left,right为什么需要一个大于0的限制？
    //	回复
    //		因为自身最长路径可以通过在自己，然后联合左边和右边路径构成，然而如果是给父节点的就只能从一边（左或者右）构成的路径才能给~ 大于0是因为如果小于0，那么就不如不要这个分支了，因为会使路径的总和变小哈~
    //
    
   

}

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
