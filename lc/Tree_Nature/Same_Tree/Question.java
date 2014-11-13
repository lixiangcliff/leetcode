package Same_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
	//http://blog.csdn.net/linhuanmars/article/details/22839819
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null){//两个都到头了，返回true
			return true;
		}
		if (p == null || q == null){//一个到头了，但是另一个没到头，所以不同，返回false
			return false;
		}
		if (p.val != q.val){//两个都不为空，但是值不相同，返回false
			return false;
		}
		//递归。这里之所以用&&，是因为这里需要：只要有一个为false，则整个为false
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
	
class TreeNode {
	      int val;
	     TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
