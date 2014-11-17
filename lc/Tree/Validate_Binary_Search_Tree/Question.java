package Validate_Binary_Search_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //【注】leetcode增加了之后MAX_VALUE和MIN_VALUE的corner case，上面的code不会pass
	//http://blog.csdn.net/linhuanmars/article/details/23810735
	//http://www.ninechapter.com/solutions/validate-binary-search-tree/
	//思想：以中序遍历查看当前root的value是不是大于上一次的root的value
/*	public boolean isValidBST(TreeNode root) {
		if (root == null){
			return true;
		}
		int[] preNodeVal = {Integer.MIN_VALUE};
		return helper(root, preNodeVal);
	}
	
	private boolean helper(TreeNode root, int[] preNodeVal){
		if (root == null){
			return true;
		}
		if (!helper(root.left, preNodeVal)){//【左】
			return false;
		}
		if(root.val <= preNodeVal[0]){//【根】
			return false;
		}
		preNodeVal[0] = root.val; // 更新 preNodeVal[0];
		if (!helper(root.right, preNodeVal)){
			return false;//【右】
		}
		return true;//只有上面三个判断都为true，最终才能返回true。
	}*/
	

	//下面的思想是：用前序遍历，
	//1.先处理根，检查根的值必须在在给定的上界与下界之间，且根本身值是MIN_VALUE或MAX_VALUE，则对应的左或右孩子必须为null，否则false（于是客观上根的下界，根值，根的上界三个数值把整个树所有node可能的取值分成两部分）
	//2.处理左子树，左子树的值必须在[根的下界，根值-1]范围内，否则false
	//3.处理右子树，右子树的值必须在[根值+1，根的上界]范围内，否则false
	//https://oj.leetcode.com/discuss/16352/java-solution-after-adding-test-cases
	public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        
        //3方面判断【根】是否符合条件(3点可以可以写在同一行，但是这样看着更清晰):
        //1.根在上下界内
        if (node.val < min || node.val > max ) {
            return false;
        }
        // 2.如果根的值为Integer.MIN_VALUE，则它不能有左孩子
        if (node.val == Integer.MIN_VALUE && node.left != null) {
            return false;
        }
        // 3.如果根的值为Integer.MAX_VALUE，则它不能有右孩子
        if (node.val == Integer.MAX_VALUE && node.right != null) {
            return false;
        }
        
        //下面处理【左】,左子树的值必须在[根的下界，根值-1]范围内，否则false
        if (!helper(node.left, min, node.val - 1)){
        	return false;
        }
        
        //下面处理【右】，右子树的值必须在[根值+1，根的上界]范围内，否则false
        if (!helper(node.right, node.val + 1, max)){
        	return false;
        }
        return true;//勿忘！
    }

}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
