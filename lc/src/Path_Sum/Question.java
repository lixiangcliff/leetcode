package Path_Sum;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/23654413
    public boolean hasPathSum(TreeNode root, int sum) {
       if(root == null){
    	   return false;
       }
       if(root.left == null && root.right == null && root.val == sum){
    	   return true;
       }
       //wrong 
       //return hasPathSum(root.left, sum - root.left.val ) || hasPathSum(root.right, sum - root.right.val );
       //correct!
       return hasPathSum(root.left, sum - root.val ) || hasPathSum(root.right, sum - root.val );
    }

}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}