package Implement_Iterator_of_Binary_Search_Tree;

import java.util.LinkedList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 /* Example of iterate a tree:
		 * Solution iterator = new Solution(root);
		 * while (iterator.hasNext()) {
		 *    TreeNode node = iterator.next();
		 *    do something for node
		 * } 
		 */
	    
	private LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	private TreeNode cur;
	//@param root: The root of binary tree.
    public Solution(TreeNode root) { //构造函数
    	cur = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
    	return (cur != null || !stack.isEmpty());
    }
    
    //@return: return next node
    //中序遍历保证保证node以升序顺序访问
    public TreeNode next() {
    	while (cur != null) {//【左】，找到最小值，然后沿途依次压入栈
    		stack.push(cur);
    		cur = cur.left;
    	}
    	cur = stack.pop();//【根】，弹出栈顶node并返回
    	TreeNode node = cur;
    	cur = cur.right;//【右】，当前cur指向它的右孩子
    	return node;
    }
	
	

}

class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
 }
