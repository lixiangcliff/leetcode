package Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		System.out.println(result.size());

	}

	/**
	 * https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

		For example:
		Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its zigzag level order traversal as:
		[
		  [3],
		  [20,9],
		  [15,7]
		]

	 */
	//类似https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
	//http://blog.csdn.net/linhuanmars/article/details/24509105
	//http://www.ninechapter.com/solutions/binary-tree-zigzag-level-order-traversal/ 
	//ninechapter代码更简练，因为处理当前行是node值（即把node加入item），而linhuan处理的是下一行（增加了很多item.add()的代码）
	//偶数层自左向右（正序），而奇数层自右向左（逆序）。(根为第0层)
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(root == null){
    		return result;
    	}
    	
    	LinkedList<TreeNode> curStack = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> nextStack = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> temp;
    	curStack.push(root);
    	boolean normalOrder = true;//即偶数层，即自左向右
    	while(!curStack.isEmpty()){
    		ArrayList<Integer> item = new ArrayList<Integer>();
    		while(!curStack.isEmpty()){
    			TreeNode node = curStack.pop();
        		item.add(node.val);//当前node值加入item
        		//当前为偶数层，把下一层按正序压入栈。然后这一层处理完之后，处理下一层时，奇数层就能按逆序弹出栈，依次加入item中
	    		if(normalOrder){
	    			if(node.left != null){
	    				nextStack.push(node.left);
	    			}
	    			if(node.right != null){
	    				nextStack.push(node.right);
	    			}
	    		}else{//奇数层，和偶数层正好相反
	    			if(node.right != null){
	    				nextStack.push(node.right);
	    			}
	    			if(node.left != null){
	    				nextStack.push(node.left);
	    			}
	    		}
    		}
    		//swap stack
    		//意图是：最开始时候curStack里面有node，而nextStack里没有。随着处理，curStack里的node依次被弹出，而nextStack依次被压入这些node的孩子们。
    		//直到curStack为空，即curStack里面的node都处理完了。而nextStack里现在压入了原来curStack的孩子们。
    		//接下来该处理nextStack了，就把curStack和nextStack的指针交换一下，重新让curStack装着node，而nextStack为空。
    		temp = curStack;
    		curStack = nextStack;
    		nextStack = temp;
    		
    		normalOrder = !normalOrder;//翻转normalOrder的boolean值
    		result.add(item);
    	}
    	return result;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}