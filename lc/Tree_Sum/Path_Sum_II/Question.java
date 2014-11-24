package Path_Sum_II;

import java.util.ArrayList;



public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//看【注】里的问题
	//http://www.ninechapter.com/solutions/path-sum-ii/
	//http://blog.csdn.net/linhuanmars/article/details/23655413
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (root == null){
    		return null;
    	}
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	helper(root, sum, item, result);
    	return result;
    }
    
    private void helper(TreeNode root, int sum, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result) {
    	if (root == null) {
    		return;
    	}
    	sum -= root.val; //sum减去当前root.val之后的新sum值
    	if (root.left == null && root.right == null) { //root为叶子node
    		if (sum == 0) { //刚好该叶子节点的值等于上次剩余的sum值
    			item.add(root.val); //当前叶子node加入item，使其成为solution之一
    			result.add(new ArrayList<Integer>(item));
    			item.remove(item.size() - 1); //【注】操作完叶子节点之后为什么要做这一步？
    		}
    	}
    	//如果root不为叶子，则把当前root.val加入item，然后对左右子树 分别递归。
    	item.add(root.val);
    	helper(root.left, sum, item, result);
    	helper(root.right, sum, item, result);
    	item.remove(item.size() - 1); //恢复调用递归前的现场
    }
    
    

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}