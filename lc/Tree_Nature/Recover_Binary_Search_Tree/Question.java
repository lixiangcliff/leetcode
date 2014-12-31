package Recover_Binary_Search_Tree;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t4.left = t2;
		t4.right = t6;
		t2.left = t5;
		t2.right = t3;
		t6.left = t1;
		t6.right = t7;
		inorder(t4);
		System.out.println("");
		recoverTree(t4);
		inorder(t4);
		System.out.println("");
		

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24566995
	public static void recoverTree(TreeNode root) {
		if (root == null){
			return;
		}
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
		pre.add(null);
		helper(root, pre, result);
		if(result.size()>0){
			int temp = result.get(0).val;
			result.get(0).val = result.get(1).val;
			result.get(1).val = temp;
		}
	}
	private static void helper(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> result){
		if(root == null){
			return;
		}
		helper(root.left, pre, result);
		if(pre.get(0)!= null && pre.get(0).val > root.val){//find current TreeNode(root) is bigger than pre.
			if(result.size() == 0){	//first time find a descended node 
				//result.set(0, pre.get(0)); Wrong!
				//result.set(1, root);
				//http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
				//set(int index, E element)
				//Replaces the element at the specified position in this list with the specified element.
				//i.e. you must add something, then set(to replace)
				result.add(0, pre.get(0)); 
				result.add(1, root);
			}else{
				result.set(1, root); // update second node in result if finding another descended node 
			}
		}
		pre.set(0, root);// update pre
		helper(root.right, pre, result);
	}
    
    public static void inorder(TreeNode root) {
        if(root == null){
        	return;
        }
        if(root.left != null){
        	inorder(root.left);
        }
        System.out.print(root.val + ",");
        if(root.right != null){
        	inorder(root.right);
        }
    }

}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }