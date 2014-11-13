package Maximum_Depth_of_Binary_Tree;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/19659525
	//recursive way
	public int maxDepth(TreeNode root) {
		if (root == null){
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
	//traverse by level(using bsf)
	public int maxDepthBSF(TreeNode root) {
		if (root == null){
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		//curNum和nextNum的作用，是用他们来标记在queue的不同层的位置，每多加一层level，深度就+1
		int curNum = 1;
		int nextNum = 0;
		int level = 0; //根据题意，只有一个root的的Tree高度为0
		queue.offer(root);
		//BSF的原理，看图！
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			curNum--;
			if(node.left != null){
				queue.offer(node.left);
				nextNum++;
			}
			if(node.right != null){
				queue.offer(node.right);
				nextNum++;
			}
			if(curNum == 0){//本层的node已经全部从队列中取出
				curNum = nextNum;
				nextNum = 0;
				level++;
			}
		}
		return level;
	}
	

}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }