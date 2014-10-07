package Sum_Root_to_Leaf_Numbers;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//http://blog.csdn.net/kenden23/article/details/14100851
    public int sumNumbers(TreeNode root) {
    	return doSumNumbers(root, 0);
    }
    
    private int doSumNumbers(TreeNode root, int sum){
    	if (root == null){
    		return 0;
    	}
    	if(root.left == null && root.right == null){
    		return sum * 10 + root.val;
    	}else{
    		return (doSumNumbers(root.left, sum*10+root.val) + doSumNumbers(root.right, sum*10+root.val));
    	}   	
    }
    
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }