package Sum_Root_to_Leaf_Numbers;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//http://blog.csdn.net/kenden23/article/details/14100851
	//算法的本质是一次先序遍历（为啥？），递归条件即是把当前的sum乘以10并且加上当前节点传入下一函数
	//http://blog.csdn.net/linhuanmars/article/details/22913699
    public int sumNumbers(TreeNode root) {
    	return helper(root, 0);
    }
    
    private int helper(TreeNode root, int sum){
    	if (root == null){//空节点，已经不是叶子了，不需要把数值加入结果，直接返回0
    		return 0;
    	}
    	if(root.left == null && root.right == null){//已到达叶子节点，将这一个branch的结果加入总和中
    		return sum * 10 + root.val;
    	}else{
    		//不为空也不为叶子时，把左右两颗子树的返回结果相加
    		return (helper(root.left, sum*10+root.val) + helper(root.right, sum*10+root.val));
    	}   	
    }
    
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }